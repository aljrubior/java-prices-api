package com.inditex.pricesapi.repository;

import com.inditex.pricesapi.model.entities.Price;
import com.inditex.pricesapi.model.entities.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, PriceId> {

    List<Price> findAllByBrandIdAndProductIdAndStartDateIsLessThanEqualAndEndDateIsGreaterThanEqualOrderByPriorityDesc(Integer brandId, Long productId, Date startDate, Date endDate);
}
