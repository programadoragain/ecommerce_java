package com.springboot.ecommerce.Controller;

import com.springboot.ecommerce.Entity.DetalleOrden;
import com.springboot.ecommerce.Entity.Orden;
import com.springboot.ecommerce.Entity.Producto;
import com.springboot.ecommerce.Service.ProductoServiceInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/")
public class HomeController {

    private final Logger log= LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    private ProductoServiceInt prodService;

    List<DetalleOrden> detalle= new ArrayList<DetalleOrden>();

    Orden orden= new Orden();

    @GetMapping ("")
    public String home (Model model) {

        model.addAttribute("productos", prodService.listar());

        return "usuarios/home";
    }

    @GetMapping ("productohome/{id}")
    public String productoHome (@PathVariable Integer id, Model model) {
        log.info("Este es el id del PRODUCTO: {}",id);

        model.addAttribute("producto", prodService.buscar(id));

        return "usuarios/producto_home";
    }

    @PostMapping("/carrito")
    public String agregarCarrito (@RequestParam Integer id, @RequestParam Integer cantidad) {
        DetalleOrden detalle= new DetalleOrden();
        Producto prod= prodService.buscar(id);

        log.info("PRODUCTO: {}", prod);
        log.info("CANTIDAD: {}", cantidad);
        //model.addAttribute("producto", prodService.buscar(id));

        return "usuarios/carrito";
    }
}
