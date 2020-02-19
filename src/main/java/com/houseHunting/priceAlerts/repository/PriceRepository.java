package com.houseHunting.priceAlerts.repository;

import com.houseHunting.priceAlerts.domain.PriceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<PriceInfo, Long> {

    PriceInfo findByHouseId(Long houseId);
}