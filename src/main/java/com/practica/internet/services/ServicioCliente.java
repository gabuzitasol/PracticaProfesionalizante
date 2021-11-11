package com.practica.internet.services;

import com.practica.internet.entities.Cliente;
import com.practica.internet.repositories.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente implements ServicioBase<Cliente>{
    @Autowired
    private RepositorioCliente repositorio;

    @Override
    @Transactional
    public List<Cliente> findAll() throws Exception {
        try {
            List<Cliente> clientes = this.repositorio.findAll();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente findById(long id) throws Exception {
        try {
            Optional<Cliente> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente saveOne(Cliente entity) throws Exception {
        try {
            Cliente cliente = this.repositorio.save(entity);
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente updateOne(Cliente entity, long id) throws Exception {
        try {
            Optional<Cliente> opt = this.repositorio.findById(id);
            Cliente cliente = opt.get();
            cliente = this.repositorio.save(entity);
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Cliente> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Cliente cliente = opt.get();
                //cliente.setActivo(!cliente.isActivo());
                this.repositorio.save(cliente);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
