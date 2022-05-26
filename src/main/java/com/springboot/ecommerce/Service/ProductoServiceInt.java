package com.springboot.ecommerce.Service;

import com.springboot.ecommerce.Entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoServiceInt {
    void guardar (Producto p);
    Producto buscar (Integer id);
    void actualizar (Producto p);
    void eliminar (Integer id);
    List<Producto> listar();
}
