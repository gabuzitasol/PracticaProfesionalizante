package com.practica.internet.controllers;

import com.practica.internet.entities.Actividad;
import com.practica.internet.entities.Empleado;
import com.practica.internet.services.ServicioActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class controladorActividad {

    @Autowired
    private ServicioActividad svcActividad;

    @GetMapping("/actividades")
    public String listarActividades(Model model){
        try {
            List<Actividad> actividades = this.svcActividad.findAll();
            model.addAttribute("actividades",actividades);
            return "views/listado_actividades";
        }catch(Exception e){
            //model.addAttribute("error", e.getMessage());
            return "views/inicio";
        }
    }
    @GetMapping("/actividad/{id}")
    public String formularioActividad(Model model,@PathVariable("id")long id){
        try {
            if(id==0){
                model.addAttribute("actividad",new Actividad());
            }else{
                model.addAttribute("actividad",this.svcActividad.findById(id));
            }
            return "views/registrar_actividad";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "views/error";
        }
    }


    @PostMapping("/actividad/{id}")
    public String guardarActividad(
            @ModelAttribute("actividad") Actividad actividad,
            Model model,@PathVariable("id")long id
    ) {

        try {
            if(id==0){

                this.svcActividad.saveOne(actividad);
            }else{

                this.svcActividad.updateOne(actividad,id);
            }
            return "views/listado_actividades";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());

            return "error";
        }
    }

}
