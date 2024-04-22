package com.lyrus.spshop.controller;

import com.lyrus.spshop.entity.Producto;
import com.lyrus.spshop.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    @Autowired
    ProductoRepository productoRepository;

    // Leer
    @GetMapping("/")
    public String getData(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);

        return "listado";
    }

    // Guardar
    @GetMapping("/registro")
    public String getFormData(Model model) {
        model.addAttribute("producto", new Producto());

        return "registro";
    }

    @PostMapping("/registro")
    public String postData(Producto producto) {
        productoRepository.save(producto);

        return "redirect:/";
    }

    // Editar
    @GetMapping("/editar/{id}")
    public String putData(@PathVariable Integer id, Model model) {
        Optional<Producto> producto = productoRepository.findById(id);
        model.addAttribute("producto", producto);

        return "registro";
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String deleteData(@PathVariable Integer id) {
        productoRepository.deleteById(id);

        return "redirect:/";
    }
}
