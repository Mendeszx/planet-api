package com.project.planet_api.domain.usecase;

import com.project.planet_api.domain.model.Planet;
import com.project.planet_api.infra.postgreprovider.entity.PlanetEntity;
import org.springframework.data.domain.Page;

public interface PlanetUseCase {

    Page<PlanetEntity> findAll(int page, int size);
    Planet findById(Long id);
    Planet save(Planet planet);
    Planet updateById(Long id, Planet planet);
    void deleteById(Long id);
}
