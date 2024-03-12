package com.tienda_l.controller;

import com.tienda_l.domain.Categoria;
import com.tienda_l.service.CategoriaService;
import com.tienda_l.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listadoDetalle(Categoria categoria, Model model) {
        categoria = categoriaService.getCateroria(categoria);
        var categorias = categoriaService.getCategorias(false);
        var productos = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("productos", productos);
        return "/pruebas/listado";
    }

    @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/pruebas/listado2";

    }

    @PostMapping("/query1")
    public String consultaQuery1(
            @RequestParam(value = "precioInf")double precioInf,
            @RequestParam(value = "precioSup")double precioSup,
            Model model) {
        var productos = productoService.metodoQuery(precioInf, precioSup);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";

    }

    @PostMapping("/query2")
    public String consultaQuery2(
            @RequestParam(value = "precioInf")double precioInf,
            @RequestParam(value = "precioSup")double precioSup,
            Model model) {
        var productos = productoService.metodoJPQL(precioInf,precioSup);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";

    }

    @PostMapping("/query3")
    public String consultaQuery3(
            @RequestParam(value = "precioInf")double precioInf,
            @RequestParam(value = "precioSup")double precioSup,
            Model model) {
        var productos = productoService.metodoNativo(precioInf,precioSup);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";
    }
}
