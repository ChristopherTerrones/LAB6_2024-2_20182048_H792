package com.example.lab6_20242_20182048_h792.controller;

import com.example.lab6_20242_20182048_h792.entity.Director;
import com.example.lab6_20242_20182048_h792.entity.Pelicula;
import com.example.lab6_20242_20182048_h792.repository.DirectorRepository;
import com.example.lab6_20242_20182048_h792.repository.PeliculaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Controller
@RequestMapping("/directores")
public class DirectorController {
    final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;

    }

    @GetMapping("/list")
    public String director(Model model){
        model.addAttribute("listaDirectores",directorRepository.findAll());
        return "directores/list";
    }

    @GetMapping("/registrarDirector")
    public String director(@ModelAttribute("director") Director director, Model model){
        model.addAttribute("tipo","Registrar director");
        return "directores/guardardirector";
    }
    @GetMapping("/editarDirector")
    public String pelicula(@ModelAttribute("director") Director director, @RequestParam("id")Integer id, Model model){
        Optional<Director> optDirector=directorRepository.findById(id);
        if(optDirector.isPresent()){
            director=optDirector.get();
            model.addAttribute("director",director);
            model.addAttribute("tipo","Editar pelicula");
            return "directores/guardardirector";
        }else {
            return "redirect:/directores/list";
        }
    }
}
