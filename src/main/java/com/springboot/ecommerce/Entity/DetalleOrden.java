package com.springboot.ecommerce.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @ToString
@Entity
@Table (name = "detalle_ordenes")
public class DetalleOrden {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
    @OneToOne
    private Orden orden;

    @ManyToOne
    private Producto producto;
}
