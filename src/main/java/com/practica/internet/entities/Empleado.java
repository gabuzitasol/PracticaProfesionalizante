package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nombre_empleado;
    private String apellido_empleado;
    private String email_empleado;
    private Date fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String estado_civil;
    private String nro_documento;
    private String nombre_contacto;
    private String telefono_contacto;

    @OneToMany(mappedBy = "empleado")
    private List<Asignacion_actividad> asignacion_actividads;





}
