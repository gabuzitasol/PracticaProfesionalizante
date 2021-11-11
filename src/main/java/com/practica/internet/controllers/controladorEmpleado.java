package com.practica.internet.controllers;
import com.practica.internet.entities.Empleado;
import com.practica.internet.services.ServicioEmpleado;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class controladorEmpleado {

        @Autowired
        private ServicioEmpleado svcEmpleado;

        @GetMapping("/empleados")
        public String listarEmpleados(Model model){
            try {
                List<Empleado> empleados = this.svcEmpleado.findAll();
                model.addAttribute("empleados",empleados);
                return "views/listado_empleados";
            }catch(Exception e){
                //model.addAttribute("error", e.getMessage());
                return "views/inicio";
            }
        }
        @GetMapping("/empleado/{id}")
        public String formularioEmpleado(Model model,@PathVariable("id")long id){
            try {
                if(id==0){
                    model.addAttribute("empleado",new Empleado());
                }else{
                    model.addAttribute("empleado",this.svcEmpleado.findById(id));
                }
                return "views/registrar_empleados";
            }catch(Exception e){
                model.addAttribute("error", e.getMessage());
                return "views/error";
            }
        }


        @PostMapping("/empleado/{id}")
        public String guardarEmpleado(
                @ModelAttribute("empleado") Empleado empleado,
                Model model,@PathVariable("id")long id
        ) {

            try {
                if(id==0){

                    this.svcEmpleado.saveOne(empleado);
                }else{

                    this.svcEmpleado.updateOne(empleado,id);
                }
                return "views/listado_empleados";
            }catch(Exception e){
                model.addAttribute("error", e.getMessage());

               return "error";
            }
        }


    }
