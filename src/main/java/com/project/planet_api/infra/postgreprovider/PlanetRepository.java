package com.project.planet_api.infra.postgreprovider;

import com.project.planet_api.infra.postgreprovider.entity.PlanetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetEntity, Long> {
}
