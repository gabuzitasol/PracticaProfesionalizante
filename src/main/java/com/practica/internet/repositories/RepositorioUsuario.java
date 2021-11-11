package com.practica.internet.repositories;

import com.practica.internet.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>  {

   // @Query(value = "SELECT * FROM videojuegos  WHERE videojuegos.activo = true", nativeQuery = true)
   // List<Videojuego> findAllByActivo();

    @Query(value = "SELECT * FROM Usuario  WHERE Usuario.username = :username AND Usuario.password = :password", nativeQuery = true)
    Optional<Usuario> findByUsername(@Param("username") String username,@Param("password") String password);

  //  @Query(value = "SELECT * FROM videojuegos WHERE videojuegos.titulo LIKE %:q% AND videojuegos.activo =true", nativeQuery = true)
    //List<Videojuego> findByTitle(@Param("q")String q);
}
