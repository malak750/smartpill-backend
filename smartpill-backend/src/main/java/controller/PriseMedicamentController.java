package com.smartpill.smartpill_backend.controller;

import com.smartpill.smartpill_backend.model.PriseMedicament;
import com.smartpill.smartpill_backend.repository.PriseMedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique")
@CrossOrigin(origins = "*")
public class PriseMedicamentController {

    @Autowired
    private PriseMedicamentRepository repository;

    // Récupérer tout l'historique
    @GetMapping
    public List<PriseMedicament> getHistorique() {
        return repository.findAll();
    }

    // Ajouter une prise
    @PostMapping
    public PriseMedicament ajouterPrise(@RequestBody PriseMedicament prise) {
        return repository.save(prise);
    }
}
