package com.springboot.ecommerce.Service;

import com.springboot.ecommerce.Entity.Producto;
import com.springboot.ecommerce.Repository.ProductoRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoServiceInt {
    @Autowired
    private ProductoRepositoryInt prodRepo;
    // @Autowired
    // EntityManager em;
    @Override
    public void guardar(Producto p) {
        prodRepo.save(p);
    }

    @Override
    public Producto buscar(Integer id) {
        return prodRepo.getById(id);
    }

    @Override
    public void actualizar(Producto p) {
        prodRepo.save(p);
    }

    @Override
    public void eliminar(Integer id) {
        prodRepo.deleteById(id);
    }

    @Override
    public List<Producto> listar() {
        return prodRepo.findAll();
    }
}
