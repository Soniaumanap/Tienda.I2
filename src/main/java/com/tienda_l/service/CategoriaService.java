package com.tienda_l.service;

import com.tienda_l.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //se obtiene un arraylist de objetos tipo Categoria
    public List<Categoria> getCategorias(boolean activos);
    
    //se obtiene un objeto categoria a partir del idCategoria que nos pasan
    public Categoria getCateroria(Categoria categoria);
    
    //se hace lo siguiente:
    //si idCategoria tiene un valor se actualiza
    //si idCategoria no tiene un valor se inserta
    public void saveCategoria(Categoria categoria);
   
    //se elimina un registro de la tabla categoria a partir del idCategoria que nos pasan
    public void deleteCategoria(Categoria categoria);
    
}
