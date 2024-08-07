package com.api.olympic.controller;

import com.api.olympic.model.Medal;
import com.api.olympic.service.OlympicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/olympic")
public class OlympicController {

    @Autowired
    private OlympicService olympicService;

    // Endpoint para listar medalhas por país
    @GetMapping("/{countryId}/medals")
    public List<Medal> getMedalsByCountry(@PathVariable String countryId) {
        return olympicService.getMedalsByCountry(countryId);
    }
    // Endpoint para listar todas as medalhas
    @GetMapping("/medals")
    public List<Medal> getAllMedals() {
        return olympicService.getAllMedals();
    }
}
