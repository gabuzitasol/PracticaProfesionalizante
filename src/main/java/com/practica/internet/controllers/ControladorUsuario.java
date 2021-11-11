package com.practica.internet.controllers;
import com.practica.internet.entities.Asignacion_actividad;
import com.practica.internet.entities.Usuario;
import com.practica.internet.services.ServicioProducto;
import com.practica.internet.services.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario svcUsuario;
    @GetMapping("/")
    public String irLogin(Model model){
        try{
            model.addAttribute("usuario",new Usuario());
            return "views/InicioLogin";
        }catch (Exception e){
            return "views/inicio";
        }
    }
    @PostMapping("/validar_username/{username}/{password}")
    public String validarUsuario(Model model ,@PathVariable("username")String username,@PathVariable("password")String password){
        try {
            Usuario usuario = this.svcUsuario.validarUsername(username,password);
            model.addAttribute("usuario",usuario);
            return "views/listado_actividades";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
