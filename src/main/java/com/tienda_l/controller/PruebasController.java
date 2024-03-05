package com.tienda_l.controller;

import com.tienda_l.service.CategoriaService;
import com.tienda_l.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private CategoriaService categoriaService;
 @Autowired
    private ProductoService productoService;
 
 
    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);
        var productos = productoService.getProductos(false);
        model.addAttribute("categorias", categorias);
         model.addAttribute("productos", productos);
        model.addAttribute("totalCategorias", categorias.size());
        return "/pruebas/listado";
    }
   
     @GetMapping("/listado/{idCategoria}")
    public String listadoDetalle(Model model) {
        var categorias = categoriaService.getCategorias(false);
        var productos = productoService.getProductos(false);
        model.addAttribute("categorias", categorias);
         model.addAttribute("productos", productos);
        model.addAttribute("totalCategorias", categorias.size());
        return "/pruebas/listado";
    }
}
