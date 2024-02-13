package com.tienda_l.service;

import com.tienda_l.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //se obtiene un arraylist de objetos tipo Categoria
    public List<Categoria> getCategorias(boolean activos);
    
}
