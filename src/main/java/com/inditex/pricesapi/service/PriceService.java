package com.inditex.pricesapi.service;

import com.inditex.pricesapi.model.entities.Price;

import java.util.Date;
import java.util.Optional;

public interface PriceService {

    Optional<Price> getPrice(Date date, Integer brandId, Long productId);
}
