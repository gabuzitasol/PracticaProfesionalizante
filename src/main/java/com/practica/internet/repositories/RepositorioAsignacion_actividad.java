package com.practica.internet.repositories;

import com.practica.internet.entities.Asignacion_actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAsignacion_actividad extends JpaRepository<Asignacion_actividad, Long> {
}
