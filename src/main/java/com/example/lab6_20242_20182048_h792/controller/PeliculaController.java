package com.example.lab6_20242_20182048_h792.controller;

import com.example.lab6_20242_20182048_h792.entity.Pelicula;
import com.example.lab6_20242_20182048_h792.repository.PeliculaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    final PeliculaRepository peliculaRepository;

    public PeliculaController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;

    }

    @GetMapping("/list")
    public String tecnicos(Model model){
        model.addAttribute("listaPeliculas",peliculaRepository.findAll());
        return "peliculas/list";
    }

    @GetMapping("/registrarPelicula")
    public String pelicula(@ModelAttribute("pelicula") Pelicula pelicula, Model model){
        model.addAttribute("tipo","Registrar película");
        return "peliculas/guardarpelicula";
    }
    @GetMapping("/editarPelicula")
    public String pelicula(@ModelAttribute("pelicula") Pelicula pelicula,@RequestParam("id")Integer id,Model model){
        Optional<Pelicula> optPelicula=peliculaRepository.findById(id);
        if(optPelicula.isPresent()){
            pelicula=optPelicula.get();
            model.addAttribute("pelicula",pelicula);
            model.addAttribute("tipo","Editar pelicula");
            return "peliculas/guardarpelicula";
        }else {
            return "redirect:/peliculas/list";
        }
    }









}
