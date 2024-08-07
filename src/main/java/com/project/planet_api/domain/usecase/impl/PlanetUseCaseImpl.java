package com.project.planet_api.domain.usecase.impl;

import com.project.planet_api.domain.model.Planet;
import com.project.planet_api.domain.usecase.PlanetUseCase;
import com.project.planet_api.infra.postgreprovider.PlanetRepository;
import com.project.planet_api.infra.postgreprovider.entity.PlanetEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlanetUseCaseImpl implements PlanetUseCase {

    private final PlanetRepository planetRepository;

    public PlanetUseCaseImpl(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public Page<PlanetEntity> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return planetRepository.findAll(pageable);
    }

    @Override
    public Planet findById(Long id) {
        Optional<PlanetEntity> planetEntity = findEntityById(id);

        if (planetEntity.isPresent()) {
            return convertEntityToModel(planetEntity.get());
        }

        return null;
    }

    @Override
    public Planet save(Planet planet) {
        PlanetEntity planetEntity = convertModelToEntity(planet);
        PlanetEntity newPlanet = planetRepository.save(planetEntity);

        return convertEntityToModel(newPlanet);
    }

    @Override
    public Planet updateById(Long id, Planet planet) {
        Optional<PlanetEntity> planetEntityActual = findEntityById(id);

        if (planetEntityActual.isPresent()) {

            PlanetEntity planetEntityUpdate = convertModelToEntity(planet);

            BeanUtils.copyProperties(planetEntityUpdate, planetEntityActual.get(), "id");

            PlanetEntity planetEntity = planetRepository.save(planetEntityUpdate);

            return convertEntityToModel(planetEntity);
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (existsById(id)) {
            planetRepository.deleteById(id);
        }
    }

    private Planet convertEntityToModel(PlanetEntity planetEntity) {
        Planet planet = new Planet();
        BeanUtils.copyProperties(planetEntity, planet);
        return planet;
    }

    private PlanetEntity convertModelToEntity(Planet planet) {
        PlanetEntity planetEntity = new PlanetEntity();
        BeanUtils.copyProperties(planetEntity, planetEntity);
        return planetEntity;
    }

    private Optional<PlanetEntity> findEntityById(Long id) {
        return planetRepository.findById(id);
    }

    private boolean existsById(Long id) {
        return planetRepository.existsById(id);
    }
}
