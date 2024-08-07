package com.project.planet_api.app.service;

import com.project.planet_api.domain.model.Planet;
import com.project.planet_api.infra.postgreprovider.entity.PlanetEntity;
import org.hibernate.mapping.Any;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface PlanetApiService {

    ResponseEntity<Page<PlanetEntity>> findAll(int page, int size);
    ResponseEntity<Planet> findById(Long id);
    ResponseEntity<Planet> save(Planet planet);
    ResponseEntity<Planet> updateById(Long id, Planet planet);
    ResponseEntity<Any> deleteById(Long id);
}
