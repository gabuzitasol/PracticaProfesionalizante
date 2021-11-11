package com.practica.internet.controllers;

import com.practica.internet.entities.Empleado;
import com.practica.internet.services.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class controladorInternet {
   // @Autowired
    //private ServicioEmpleado svcEmpleado;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        try {
          //  List<Empleado> empleado = this.svcEmpleado.findAll();
           // model.addAttribute("empleado", empleado);
            return "views/inicio";
        } catch (Exception e) {
            return "";
        }
    }
}
