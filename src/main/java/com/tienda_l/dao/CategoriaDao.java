package com.tienda_l.dao;

import com.tienda_l.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT c FROM Categoria c " //Producto se escribe asi por la clase no por la tabla
            + "where c.idCategoria "
            + "BETWEEN :idCategoriaInf and :idCategoriaSup "
            + "ORDER BY c.descripcion ASC")
    public List<Categoria> metodoJPQL(
            @Param("idCategoriaInf") int idCategoriaInf,
            @Param("idCategoriaSup") int idCategoriaSup);
}
