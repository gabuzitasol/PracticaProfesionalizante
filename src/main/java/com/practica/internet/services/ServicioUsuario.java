package com.practica.internet.services;
import com.practica.internet.entities.Usuario;
import com.practica.internet.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ServicioUsuario implements  ServicioBase<Usuario> {
    @Autowired
    private RepositorioUsuario repositorio;
    @Override
    @Transactional
    public List<Usuario> findAll() throws Exception {
        try {
            List<Usuario> usuarios = this.repositorio.findAll();
            return usuarios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario findById(long id) throws Exception {
        try {
            Optional<Usuario> opt = this.repositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario saveOne(Usuario entity) throws Exception {
        try {
            Usuario usuario = this.repositorio.save(entity);
            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuario updateOne(Usuario entity, long id) throws Exception {
        try {
            Optional<Usuario> opt = this.repositorio.findById(id);
            Usuario usuario = opt.get();
            usuario = this.repositorio.save(entity);
            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Usuario> opt = this.repositorio.findById(id);
            if (!opt.isEmpty()) {
                Usuario usuario = opt.get();

                this.repositorio.save(usuario);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Usuario validarUsername(String username, String password) throws Exception{
        try{
            Optional<Usuario> opt = this.repositorio.findByUsername(username,password);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
