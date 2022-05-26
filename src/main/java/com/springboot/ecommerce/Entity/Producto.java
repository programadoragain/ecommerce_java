package com.springboot.ecommerce.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter @ToString
@Entity
@Table (name = "productos")
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String precio;
    private String imagen;
    private String stock;
    private String descripcion;
    @ManyToOne
    private Usuario usuario;
}
