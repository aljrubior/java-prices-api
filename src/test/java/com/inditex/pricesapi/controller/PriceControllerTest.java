package com.inditex.pricesapi.controller;

import com.inditex.pricesapi.model.entities.Price;
import com.inditex.pricesapi.service.PriceService;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PriceService priceService;

    String uri = "/api/prices";

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

    @Test
    void givenNoPrice_whenGetPrice_thenReturnEmptyAndOK() throws Exception {
        // Arrange
        var random = new Random();
        var date = new Date(System.currentTimeMillis());
        var brandId = random.nextInt();
        var productId = random.nextLong();
        var dateQueryParam = formatter.format(date);

        when(priceService.getPrice(date, brandId, productId)).thenReturn(Optional.empty());

        // Act and Assert
        mockMvc.perform(
            get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("date", dateQueryParam)
                .queryParam("productId", String.valueOf(productId))
                .queryParam("brandId", String.valueOf(brandId)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(Strings.EMPTY));
    }

    @Test
    void givenPriceExists_whenGetPrice_thenReturnPriceAndOK() throws Exception {
        // Arrange
        var random = new Random();
        var date = new Date(System.currentTimeMillis());
        var brandId = random.nextInt();
        var productId = random.nextLong();
        var dateQueryParam = formatter.format(date);

        var price = mock(Price.class);

        when(priceService.getPrice(date, brandId, productId)).thenReturn(Optional.of(price));

        // Act and Assert
        mockMvc.perform(
            get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("date", dateQueryParam)
                .queryParam("productId", String.valueOf(productId))
                .queryParam("brandId", String.valueOf(brandId)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}