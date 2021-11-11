package com.practica.internet.controllers;

import com.practica.internet.entities.Cliente;

import com.practica.internet.services.ServicioCliente;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class controladorCliente {
    @Autowired
    private ServicioCliente svcCliente;

    @GetMapping("/clientes")
    public String listarClientes(Model model){
        try {
            List<Cliente> clientes = this.svcCliente.findAll();
            model.addAttribute("clientes",clientes);
            return "views/listado_clientes";
        }catch(Exception e){
            //model.addAttribute("error", e.getMessage());
            return "views/inicio";
        }
    }
    @GetMapping("/cliente/{id}")
    public String formularioCliente(Model model,@PathVariable("id")long id){
        try {
            if(id==0){
                model.addAttribute("cliente",new Cliente());
            }else{
                model.addAttribute("cliente",this.svcCliente.findById(id));
            }
            return "views/registrar_cliente";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "views/error";
        }
    }


    @PostMapping("/cliente/{id}")
    public String guardarCliente(
            @ModelAttribute("cliente") Cliente cliente,
            Model model,@PathVariable("id")long id
    ) {

        try {
            if(id==0){

                this.svcCliente.saveOne(cliente);
            }else{

                this.svcCliente.updateOne(cliente,id);
            }
            return "redirect:/views/listado_clientes";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());

            return "error";
        }
    }

}
