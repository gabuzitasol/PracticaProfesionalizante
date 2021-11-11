package com.practica.internet.controllers;

import com.practica.internet.entities.Asignacion_actividad;
import com.practica.internet.entities.Cliente;
import com.practica.internet.entities.Empleado;
import com.practica.internet.entities.Producto;
import com.practica.internet.entities.Actividad;
import com.practica.internet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class controladorAsignarActividad {

    @Autowired
    private ServicioAsignacion_actividad svcAsignacion_actividad;
    @Autowired
    private ServicioEmpleado svcEmpleado;
    @Autowired
    private ServicioProducto svcProducto;
    @Autowired
    private ServicioActividad svcActividad;
    @Autowired
    private ServicioCliente scvCliente;

    @GetMapping("/asignaciones")
    public String listarAsignaciones(Model model){
        try {
            List<Asignacion_actividad> asignacion_actividad = this.svcAsignacion_actividad.findAll();
            model.addAttribute("asignacion_actividad",asignacion_actividad);

            return "views/listado_asignaciones";
        }catch(Exception e){
            //model.addAttribute("error", e.getMessage());
            return "views/inicio";
        }
    }
    @GetMapping("/asignacion/{id}")
    public String formularioAsignaciones(Model model,@PathVariable("id")long id){
        try {
            if(id==0){
               // List<Empleado> empleados = this.svcEmpleado.findAll();
                model.addAttribute("empleados",this.svcEmpleado.findAll());

                model.addAttribute("productos",this.svcProducto.findAll());

                model.addAttribute("actividades",this.svcActividad.findAll());

                model.addAttribute("clientes",this.scvCliente.findAll());
                model.addAttribute("asignacion",new Asignacion_actividad());
            }else{
                model.addAttribute("asignacion",this.svcAsignacion_actividad.findById(id));
                List<Empleado> empleados = this.svcEmpleado.findAll();
                model.addAttribute("empleados",empleados);
                List<Producto> productos = this.svcProducto.findAll();
                model.addAttribute("productos",productos);
                 List<Actividad> actividades = this.svcActividad.findAll();
                model.addAttribute("actividades",actividades);
                List<Cliente> clientes = this.scvCliente.findAll();
                model.addAttribute("clientes",clientes);
            }
            return "views/registrar_asignacion_actividad";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "views/error";
        }
    }


    @PostMapping("/asignacion/{id}")
    public String guardarAsignacion(
            @ModelAttribute("asignacion_actividad") Asignacion_actividad asignacion_actividad,
            Model model,@PathVariable("id")long id
    ) {

        try {
            if(id==0){

                this.svcAsignacion_actividad.saveOne(asignacion_actividad);
            }else{

                this.svcAsignacion_actividad.updateOne(asignacion_actividad,id);
            }
            return "views/listado_asignaciones";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());

            return "error";
        }
    }

}
