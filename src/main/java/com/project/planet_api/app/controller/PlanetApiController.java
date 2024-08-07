package com.project.planet_api.app.controller;

import com.project.planet_api.app.service.PlanetApiService;
import com.project.planet_api.domain.model.Planet;
import com.project.planet_api.infra.postgreprovider.entity.PlanetEntity;
import org.hibernate.mapping.Any;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/planets")
public class PlanetApiController {

    private final PlanetApiService planetApiService;

    public PlanetApiController(PlanetApiService planetApiService) {
        this.planetApiService = planetApiService;
    }

    @GetMapping
    public ResponseEntity<Page<PlanetEntity>> getAllPlanets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return planetApiService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> getPlanetById(@PathVariable Long id) {
        return planetApiService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet) {
        return planetApiService.save(planet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planet> updatePlanet(@PathVariable Long id, @RequestBody Planet planet) {
        return planetApiService.updateById(id, planet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Any> deletePlanet(@PathVariable Long id) {
        return planetApiService.deleteById(id);
    }
}
