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

    @Autowired //para no tener que inicializar
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll(); //se crea un array llamado lista donde se almacena todo
        //productoDao.findAll() es el metodo que busca en la base de datos, por lo tanto usar el metodo @Transactional(readOnly=true)
        if (activos) { //si solo quiero los activos 
            lista.removeIf(c -> !c.isActivo()); //remueva todos los que no estan activos, c es un predicado, se puede llamar como uno quiera, 
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null); //si no lo encuentra entonces que devuelva null
    }

    @Override
    @Transactional
    public void deleteProducto(Producto producto) {
        productoDao.delete(producto);//para eliminar
    }

    @Override
    @Transactional
    public void saveProducto(Producto producto) {
        productoDao.save(producto); //para salvar
    }

    //Esta consulta ampliada utiliza método @Query
    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoQuery(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    //Esta consulta utiliza lenguaje JPQL
    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }

    //Esta consulta utiliza lenguaje JPQL nativo
    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByIdBetweenOrderByDescripcion(int idInf, int idSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(idInf, idSup);
    }
}
