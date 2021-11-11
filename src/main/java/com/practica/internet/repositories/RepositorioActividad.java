package com.practica.internet.repositories;

import com.practica.internet.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioActividad extends JpaRepository<Actividad, Long> {
}
