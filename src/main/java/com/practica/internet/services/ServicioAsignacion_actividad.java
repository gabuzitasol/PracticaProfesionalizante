package com.practica.internet.services;


import com.practica.internet.entities.Asignacion_actividad;
import java.util.List;
import java.util.Optional;


import com.practica.internet.repositories.RepositorioAsignacion_actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ServicioAsignacion_actividad implements ServicioBase<Asignacion_actividad> {
    @Autowired
    private RepositorioAsignacion_actividad repositorio;
    @Override
    @Transactional
    public List<Asignacion_actividad> findAll() throws Exception {
        try {
            List<Asignacion_actividad> asignacion_actividad = this.repositorio.findAll();
            return asignacion_actividad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Asignacion_actividad findById(long id) throws Exception {
        try {
            Optional<Asignacion_actividad> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Asignacion_actividad saveOne(Asignacion_actividad entity) throws Exception {
        try {
            Asignacion_actividad asignacion_actividad = this.repositorio.save(entity);
            return asignacion_actividad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Asignacion_actividad updateOne(Asignacion_actividad entity, long id) throws Exception {
        try {
            Optional<Asignacion_actividad> opt = this.repositorio.findById(id);
            Asignacion_actividad asignacion_actividad = opt.get();
            asignacion_actividad = this.repositorio.save(entity);
            return asignacion_actividad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Asignacion_actividad> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Asignacion_actividad asignacion_actividad = opt.get();
                // actividad_producto.setActivo(!actividad_producto.isActivo());
                this.repositorio.save(asignacion_actividad);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
