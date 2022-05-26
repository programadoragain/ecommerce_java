package com.springboot.ecommerce.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.swing.*;
import java.util.Date;

@Getter @Setter @ToString
@Entity
@Table (name = "Ordenes")
public class Orden {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private Double valorTotal;
    private Date fechaCreacion;
    private Date fechaRecibida;
    @ManyToOne
    private Usuario usuario;

    @OneToOne (mappedBy = "orden")
    private DetalleOrden detalle;
}
