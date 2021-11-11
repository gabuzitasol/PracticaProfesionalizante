package com.practica.internet.services;

import com.practica.internet.entities.Actividad;
import com.practica.internet.repositories.RepositorioActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioActividad  implements ServicioBase<Actividad>{
    @Autowired
    private RepositorioActividad repositorio;

    @Override
    @Transactional
    public List<Actividad> findAll() throws Exception {
        try {
            List<Actividad> actividads = this.repositorio.findAll();
            return actividads;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Actividad findById(long id) throws Exception {
        try {
            Optional<Actividad> opt =this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Actividad saveOne(Actividad entity) throws Exception {
        try {
            Actividad actividad = this.repositorio.save(entity);
            return actividad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Actividad updateOne(Actividad entity, long id) throws Exception {
        try {
            Optional<Actividad> opt = this.repositorio.findById(id);
            Actividad actividad = opt.get();
            actividad =this.repositorio.save(entity);
            return actividad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Actividad> opt =this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Actividad actividad = opt.get();
                //actividad.setActivo(!actividad.isActivo());
                this.repositorio.save(actividad);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
