package com.tienda_l.controller;

import com.tienda_l.domain.Categoria;
import com.tienda_l.domain.Usuario;
import com.tienda_l.service.CategoriaService;
import com.tienda_l.service.RegistroService;
import com.tienda_l.service.impl.FirebaseStorageServiceImpl;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuario usuario) {
        //usuarioService.crear(usuario);
        return "/registro/nuevo";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "/registro/nuevo";
    }
    @Autowired
    private RegistroService registroService;

    @GetMapping("/recordar")
    public String recordar(Model model, Usuario usuario) {
        return "/registro/recordar";
    }

    @GetMapping("/activacion/{usuario}/{id}")
    public String activar(
            Model model,
            @PathVariable(value = "usuario") String usuario,
            @PathVariable(value = "id") String id) {
        model = registroService.activar(model, usuario, id);
        if (model.containsAttribute("usuario")) {
            return "/registro/activa";
        } else {
            return "/registro/salida";
        }
    }

    @PostMapping("/activar")
    public String activar(
            Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        registroService.activar(usuario, imagenFile);
        return "redirect:/";
    }

    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Usuario usuario)
            throws MessagingException {
        model = registroService.recordarUsuario(model, usuario);
        return "/registro/salida";
    }
}
