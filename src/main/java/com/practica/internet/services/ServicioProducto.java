package com.practica.internet.services;

import com.practica.internet.entities.Producto;

import com.practica.internet.repositories.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ServicioProducto implements  ServicioBase<Producto> {
    @Autowired
    private RepositorioProducto repositorio;
    @Override
    @Transactional
    public List<Producto> findAll() throws Exception {
        try {
            List<Producto> producto = this.repositorio.findAll();
            return producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto findById(long id) throws Exception {
        try {
            Optional<Producto> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto saveOne(Producto entity) throws Exception {
        try {
            Producto producto = this.repositorio.save(entity);
            return producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto updateOne(Producto entity, long id) throws Exception {
        try {
            Optional<Producto> opt = this.repositorio.findById(id);
            Producto producto = opt.get();
            producto = this.repositorio.save(entity);
            return producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Producto> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Producto producto = opt.get();
                // actividad_producto.setActivo(!actividad_producto.isActivo());
                this.repositorio.save(producto);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
