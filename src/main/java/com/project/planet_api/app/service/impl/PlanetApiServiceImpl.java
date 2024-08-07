package com.project.planet_api.app.service.impl;

import com.project.planet_api.app.service.PlanetApiService;
import com.project.planet_api.domain.model.Planet;
import com.project.planet_api.domain.usecase.PlanetUseCase;
import com.project.planet_api.infra.postgreprovider.entity.PlanetEntity;
import org.hibernate.mapping.Any;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlanetApiServiceImpl implements PlanetApiService {

    private final PlanetUseCase planetUseCase;

    public PlanetApiServiceImpl(PlanetUseCase planetUseCase) {
        this.planetUseCase = planetUseCase;
    }

    @Override
    public ResponseEntity<Page<PlanetEntity>> findAll(int page, int size) {
        Page<PlanetEntity> planets = planetUseCase.findAll(page, size);
        return ResponseEntity.ok(planets);
    }

    @Override
    public ResponseEntity<Planet> findById(Long id) {
        Planet planet = planetUseCase.findById(id);
        return planet != null ? ResponseEntity.ok(planet) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Planet> save(Planet planet) {
        Planet planet1 = planetUseCase.save(planet);
        return ResponseEntity.ok(planet1);
    }

    @Override
    public ResponseEntity<Planet> updateById(Long id, Planet planet) {
        Planet planet1 = planetUseCase.updateById( id, planet);
        return ResponseEntity.ok(planet1);
    }

    @Override
    public ResponseEntity<Any> deleteById(Long id) {
        planetUseCase.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
