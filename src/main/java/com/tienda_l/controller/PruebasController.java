package com.tienda_l.controller;

import com.tienda_l.domain.Categoria;
import com.tienda_l.service.CategoriaService;
import com.tienda_l.service.ProductoService;
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
@RequestMapping("/pruebas") //todos estos metodos van a estar debajo de la ruta pruebas
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
        model.addAttribute("totalCategorias", categorias.size()); //muestra el total de categorias en la pagina
        return "/pruebas/listado"; //ubicacion del html
    }

    @GetMapping("/listado/{idCategoria}")
    public String listadoDetalle(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        var productos = categoria.getProductos();
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("productos", productos);
        return "/pruebas/listado"; //ubicacion del html
    }

    @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/pruebas/listado2"; //ubicacion del html
    }
    

    @PostMapping("/query1")
    public String consultaQuery1(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.metodoQuery(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";
    }

    @PostMapping("/query2")
    public String consultaQuery2(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";
    }

    @PostMapping("/query3")
    public String consultaQuery3(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var productos = productoService.metodoNativo(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "pruebas/listado2";
    }
    @GetMapping("/listado3")
    public String listado3(Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado3"; //ubicacion del html
    }
   
    @PostMapping("/query4")
    public String consultaQuery4(
            @RequestParam(value="idCategoriaInf") int idCategoriaInf,
            @RequestParam(value="idCategoriaSup") int idCategoriaSup,
            Model model) {
        var categoria = categoriaService.metodoJPQL(idCategoriaInf, idCategoriaSup);
        model.addAttribute("categorias", categoria);
        model.addAttribute("idCategoriaInf", idCategoriaInf);
        model.addAttribute("idCategoriaSup", idCategoriaSup);
        return "pruebas/listado3";
    }
}
