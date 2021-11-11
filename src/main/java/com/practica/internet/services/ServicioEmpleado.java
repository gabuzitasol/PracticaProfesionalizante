package com.practica.internet.services;

import com.practica.internet.entities.Empleado;
import com.practica.internet.repositories.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ServicioEmpleado  implements  ServicioBase<Empleado>{
    @Autowired
    private RepositorioEmpleado repositorio;
    @Override
    @Transactional
    public List<Empleado> findAll() throws Exception {
        try {
            List<Empleado> empleado = this.repositorio.findAll();
            return empleado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado findById(long id) throws Exception {
        try {
            Optional<Empleado> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado saveOne(Empleado entity) throws Exception {
        try {
            Empleado empleado = this.repositorio.save(entity);
            return empleado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado updateOne(Empleado entity, long id) throws Exception {
        try {
            Optional<Empleado> opt = this.repositorio.findById(id);
            Empleado empleado = opt.get();
            empleado = this.repositorio.save(entity);
            return empleado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Empleado> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Empleado empleado = opt.get();
                //actividad_producto.setActivo(!actividad_producto.isActivo());
                this.repositorio.save(empleado);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
