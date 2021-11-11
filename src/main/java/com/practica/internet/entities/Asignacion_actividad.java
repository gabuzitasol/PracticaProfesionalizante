package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "asignacion_actividad")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asignacion_actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String observaciones;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_actividad", nullable = false)
    private Actividad actividad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_producto", nullable = false)
    private Producto producto;

}
