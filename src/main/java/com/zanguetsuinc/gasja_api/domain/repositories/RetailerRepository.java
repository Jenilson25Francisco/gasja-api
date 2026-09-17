package com.zanguetsuinc.gasja_api.domain.repositories;

import com.zanguetsuinc.gasja_api.domain.models.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, UUID> {

    Optional<Retailer> findByPhone(String phone);

}
