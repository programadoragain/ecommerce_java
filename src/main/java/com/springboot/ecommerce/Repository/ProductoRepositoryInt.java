package com.springboot.ecommerce.Repository;

import com.springboot.ecommerce.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositoryInt extends JpaRepository<Producto, Integer> {
}
