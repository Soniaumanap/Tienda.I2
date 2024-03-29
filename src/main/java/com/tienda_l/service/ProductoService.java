package com.tienda_l.service;

import com.tienda_l.domain.Producto;
import java.util.List;

public interface ProductoService {
    //se obtiene un arraylist de objetos tipo Producto
    public List<Producto> getProductos(boolean activos);
    
    //se obtiene un objeto producto a partir del idProducto que nos pasan
    public Producto getCateroria(Producto producto);
    
    //se hace lo siguiente:
    //si idProducto tiene un valor se actualiza
    //si idProducto no tiene un valor se inserta
    public void saveProducto(Producto producto);
   
    //se elimina un registro de la tabla producto a partir del idProducto que nos pasan
    public void deleteProducto(Producto producto);
    
    //Esta consulta ampliada utiliza el metodo Query
    public List<Producto>metodoQuery(double precioInf,double precioSup);
    
    //Esta consulta ampliada utiliza el metodo lengiaje JPQL 
    public List<Producto> metodoJPQL(double precioInf,double precioSup);
    
    //Esta consulta utiliza el lenguaje SQL
    public List<Producto> metodoNativo(double precioInf,double precioSup);
    
}
