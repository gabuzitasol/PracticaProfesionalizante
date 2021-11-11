package com.practica.internet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre_cliente;
    private String nro_documento;
    private String direccion_cliente;
    private String telefono_cliente;
    private String correo_cliente;


    @OneToMany(mappedBy = "cliente")
    private List<Asignacion_actividad> asignacion_actividads;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_producto")
    private Producto producto;

}
