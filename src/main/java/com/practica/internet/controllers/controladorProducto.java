package com.practica.internet.controllers;


import com.practica.internet.entities.Producto;
import com.practica.internet.services.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class controladorProducto {

    @Autowired
    private ServicioProducto svcProducto;

    @GetMapping("/productos")
    public String listarProductos(Model model){
        try {
            List<Producto> productos = this.svcProducto.findAll();
            model.addAttribute("productos",productos);
            return "views/listado_productos";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
    @GetMapping("/producto/{id}")
    public String formularioProducto(Model model,@PathVariable("id")long id){
        try {
            if(id==0){
                model.addAttribute("producto",new Producto());
            }else{
                model.addAttribute("producto",this.svcProducto.findById(id));
            }
            return "views/registrar_producto";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "views/error";
        }
    }


    @PostMapping("/producto/{id}")
    public String guardarProducto(
            @ModelAttribute("producto") Producto producto,
            Model model,@PathVariable("id")long id
    ) {

        try {
            if(id==0){

                this.svcProducto.saveOne(producto);
            }else{

                this.svcProducto.updateOne(producto,id);
            }
            return "views/listado_productos";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());

            return "error";
        }
    }


}
