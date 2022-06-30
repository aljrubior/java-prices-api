package com.inditex.pricesapi.service;

import com.inditex.pricesapi.model.entities.Price;
import com.inditex.pricesapi.repository.PriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultPriceServiceTest {

    @Mock
    PriceRepository priceRepository;

    @InjectMocks
    DefaultPriceService target;

    @Test
    void givenNoRows_whenGetPrice_thenReturnOptionalEmpty() {
        // Arrange
        var random = new Random();
        var date = new Date(System.currentTimeMillis());
        var brandId = random.nextInt();
        var productId = random.nextLong();

        when(priceRepository
            .findAllByBrandIdAndProductIdAndStartDateIsLessThanEqualAndEndDateIsGreaterThanEqualOrderByPriorityDesc(
                brandId,
                productId,
                date,
                date))
            .thenReturn(Collections.emptyList());

        // Act
        Optional<Price> result = target.getPrice(date, brandId, productId);

        // Assert
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void givenRows_whenPrice_thenReturnAnOptionalOfIndexZero() {
        // Arrange
        // Arrange
        var random = new Random();
        var date = new Date(System.currentTimeMillis());
        var brandId = random.nextInt();
        var productId = random.nextLong();

        var price1 = mock(Price.class);
        var price2 = mock(Price.class);
        var pricesOrderedByStartDateDescAndPriorityAsc = Arrays.asList(price1, price2);

        when(priceRepository
            .findAllByBrandIdAndProductIdAndStartDateIsLessThanEqualAndEndDateIsGreaterThanEqualOrderByPriorityDesc(
                brandId,
                productId,
                date,
                date))
            .thenReturn(pricesOrderedByStartDateDescAndPriorityAsc);

        // Act
        Optional<Price> result = target.getPrice(date, brandId, productId);

        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(price1, result.get());
    }

}