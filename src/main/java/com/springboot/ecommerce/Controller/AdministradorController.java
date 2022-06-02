package com.springboot.ecommerce.Controller;

import com.springboot.ecommerce.Service.ProductoServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@Controller
public class AdministradorController {
    @Autowired
    private ProductoServiceInt prodService;

    @GetMapping (value = "/home")
    public String home(Model model) {
        model.addAttribute("productos", prodService.listar());

        return "home.html";
    }

}
