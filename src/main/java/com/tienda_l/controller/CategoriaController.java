package com.tienda_l.controller;

import com.tienda_l.domain.Categoria;
import com.tienda_l.service.CategoriaService;
import com.tienda_l.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listado";
    }
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageImpl;

    @PostMapping("/guardar")
    public String guardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            // si estamos aca hay que gaurdar la foto
            categoriaService.saveCategoria(categoria);
            categoria.setRutaImagen(
                    firebaseStorageImpl.cargaImagen(imagenFile,
                            "categoria", categoria.getIdCategoria())
            );
        }
        categoriaService.saveCategoria(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String elimina(Categoria categoria) {
        categoriaService.deleteCategoria(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String modifica(Categoria categoria, Model model) {
        categoria = categoriaService.getCateroria(categoria);
        model.addAttribute("categoria", categoria);
        return "redirect:/categoria/modifica";

    }
}
