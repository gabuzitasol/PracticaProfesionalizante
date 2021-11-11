package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actividad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String descripcion;


    @OneToMany(mappedBy = "actividad")
    private List<Asignacion_actividad> asignacion_actividads;

}
