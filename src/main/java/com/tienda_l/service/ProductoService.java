package com.tienda_l.service;

import com.tienda_l.domain.Producto;
import java.util.List;

public interface ProductoService {

    //se obtiene un arraylist de objetos tipo producto
    public List<Producto> getProductos(boolean activos); //recibe como parametro si esta activa o no

    //se obtiene un objeto Producto a partir del idProducto que nos pasan
    public Producto getProducto(Producto producto); //si producto tiene un valor se hace una busqueda en la base

    //se elimina un registro de la tabla producto a partir del idProducto que nos pasen. 
    public void deleteProducto(Producto producto);

    //Se hace lo siguiente
    //Si idProducto tiene un valor se actualiza 
    //Si idProducto NO tiene un valor se inserta 
    public void saveProducto(Producto producto);

    public List<Producto> metodoQuery(double precioInf, double precioSup);
    //Esta consulta utiliza lenguaje JPQL

    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    //Esta consulta utiliza lenguaje JPQL nativo

    public List<Producto> metodoNativo(double precioInf, double precioSup);

    public List<Producto>
            findByIdBetweenOrderByDescripcion(
                    int idInf,
                    int idSup);
}
