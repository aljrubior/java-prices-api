package com.inditex.pricesapi.service;

import com.inditex.pricesapi.model.entities.Price;
import com.inditex.pricesapi.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultPriceService implements PriceService {

    private PriceRepository priceRepository;

    @Autowired
    public DefaultPriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> getPrice(Date date, Integer brandId, Long productId) {

        List<Price> prices = this.priceRepository.findAllByBrandIdAndProductIdAndStartDateIsLessThanEqualAndEndDateIsGreaterThanEqualOrderByPriorityDesc(brandId, productId, date, date);

        if (prices.isEmpty()) return Optional.empty();

        return Optional.of(prices.get(0));
    }
}
