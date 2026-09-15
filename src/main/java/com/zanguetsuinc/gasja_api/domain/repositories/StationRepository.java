package com.zanguetsuinc.gasja_api.domain.repositories;

import com.zanguetsuinc.gasja_api.domain.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {
}
