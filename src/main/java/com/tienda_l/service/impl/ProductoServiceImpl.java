package com.tienda_l.service.impl;

import com.tienda_l.dao.ProductoDao;
import com.tienda_l.domain.Producto;
import com.tienda_l.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl
        implements ProductoService {
     {
    }
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        var lista=productoDao.findAll();
        if (activos){//si solo quiero los activos
            lista.removeIf(c-> !c.isActivo());
            
        }
        return lista;
    }

    @Override
    public Producto getCateroria(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        productoDao.delete(producto);
    }
    
    //Esta consulta ampliada utiliza el metodo Query
    @Override
    @Transactional(readOnly=true)
    public List<Producto>metodoQuery(double precioInf,double precioSup){
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    //Esta consulta ampliada utiliza el metodo lengiaje JPQL 
    @Override
    @Transactional(readOnly=true)
    public List<Producto> metodoJPQL(double precioInf,double precioSup){
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    
    //Esta consulta utiliza el lenguaje SQL
    @Override
    @Transactional(readOnly=true)
    public List<Producto> metodoNativo(double precioInf,double precioSup){
        return productoDao.metodoNativo(precioInf, precioSup);
    }
}
