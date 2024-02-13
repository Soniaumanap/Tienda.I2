package com.tienda_l.service.impl;

import com.tienda_l.dao.CategoriaDao;
import com.tienda_l.domain.Categoria;
import com.tienda_l.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl
        implements CategoriaService {
     {
    }
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> getCategorias(boolean activos) {
        return categoriaDao.findAll();
    }
}
