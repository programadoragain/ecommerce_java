package com.springboot.ecommerce.Controller;

import com.springboot.ecommerce.Entity.Producto;
import com.springboot.ecommerce.Entity.Usuario;
import com.springboot.ecommerce.Service.ProductoServiceInt;
import com.springboot.ecommerce.Service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    private final Logger log= LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    private ProductoServiceInt prodService;
    private UploadFileService upImg= new UploadFileService();

    @GetMapping (value="/mostrarproductos")
    public String mostrarProductos (Model model) {
        model.addAttribute("productos", prodService.listar());
        return "productos/mostrar";
    }

    @GetMapping (value = "/agregarproducto")
    public String agregar () {
        return "productos/agregar";
    }

    @PostMapping(value= "api/agregarproducto")
    public String agregarProducto (Producto p, @RequestParam("img") MultipartFile imagen) throws IOException {
        log.info("Este es el objeto PRODUCTO: {}",p);
        Usuario user= new Usuario(1,"","","","","","","");

        p.setUsuario(user);

        if (imagen.isEmpty()) p.setImagen("imagendefault.jpg");
        else
            p.setImagen(upImg.guardarImagen(imagen));

        prodService.guardar(p);
        return ("redirect:/mostrarproductos");
    }

    @GetMapping (value = "/editarproducto/{id}")
    public String editar (@PathVariable int id, Model model) {
        Producto prod = prodService.buscar(id);
        model.addAttribute("producto", prod);

        return ("productos/editar");
    }
    @PostMapping (value = "/api/editarproducto")
    public String editarProducto (Producto p, @RequestParam("img") MultipartFile imagen) throws IOException {
        String nombreImagen= prodService.buscar(p.getId()).getImagen();

        if (imagen.isEmpty()) {
            p.setImagen(nombreImagen);
        }
        else
        {
            if (!nombreImagen.equals("imagendefault.jpg")) {
                upImg.eliminarImagen(nombreImagen);
            }
            p.setImagen(upImg.guardarImagen(imagen));
        }

        prodService.guardar(p);
        return "redirect:/mostrarproductos";
    }

    @GetMapping (value = "api/eliminarproducto/{id}")
    public String eliminarProducto (@PathVariable Integer id) throws IOException {
        String nombreImagen= prodService.buscar(id).getImagen();

        if ((nombreImagen != null) && (!nombreImagen.equals("imagendefault.jpg")) && (upImg.existeImagen(nombreImagen))) {
            upImg.eliminarImagen(nombreImagen);
        }

        prodService.eliminar(id);
        return ("redirect:/mostrarproductos");
    }
}
