package com.tienda_l.service.impl;

import com.tienda_l.dao.CategoriaDao;
import com.tienda_l.domain.Categoria;
import com.tienda_l.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl
        implements CategoriaService {

    {
    }
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if (activos) {//si solo quiero los activos
            lista.removeIf(c -> !c.isActivo());

        }
        return lista;
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void saveCategoria(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    //Esta consulta ampliada utiliza el metodo lengiaje JPQL 
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> metodoJPQL(int idCategoriaInf, int idCategoriaSup) {
        return categoriaDao.metodoJPQL(idCategoriaInf, idCategoriaSup);
    }
}
