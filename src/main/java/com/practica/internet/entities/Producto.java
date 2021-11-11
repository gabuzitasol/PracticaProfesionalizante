package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;
    private float cantidad;
    private float precio;

    @OneToMany(mappedBy = "producto")
    private List<Asignacion_actividad> asignacion_actividads;

    @OneToOne(mappedBy = "producto")
    private Cliente cliente;
}
