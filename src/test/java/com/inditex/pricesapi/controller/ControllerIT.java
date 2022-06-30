package com.inditex.pricesapi.controller;

import com.inditex.pricesapi.PricesApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = PricesApiApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ControllerIT {

    @Autowired
    MockMvc mockMvc;

    String uri = "/api/prices";

    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test1() throws Exception {
        // Arrange
        var date = "2020-06-14-10.00.00";
        var brandId = 1;
        var productId = 35455;
        var expectedResponse = Files.readString(Path.of("src/test/resources/test1_response.json"));

        // Act and Assert
        mockMvc.perform(
            get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("date", date)
                .queryParam("productId", String.valueOf(productId))
                .queryParam("brandId", String.valueOf(brandId)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(expectedResponse, true));
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test2() throws Exception {
        // Arrange
        var date = "2020-06-14-16.00.00";
        var brandId = 1;
        var productId = 35455;
        var expectedResponse = Files.readString(Path.of("src/test/resources/test2_response.json"));

        // Act and Assert
        mockMvc.perform(
            get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("date", date)
                .queryParam("productId", String.valueOf(productId))
                .queryParam("brandId", String.valueOf(brandId)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(expectedResponse, true));
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test3() throws Exception {
        // Arrange
        var date = "2020-06-14-21.00.00";
        var brandId = 1;
        var productId = 35455;
        var expectedResponse = Files.readString(Path.of("src/test/resources/test3_response.json"));

        // Act and Assert
        mockMvc.perform(
            get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("date", date)
                .queryParam("productId", String.valueOf(productId))
                .queryParam("brandId", String.valueOf(brandId)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(expectedResponse, true));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test4() throws Exception {
        // Arrange
        var date = "2020-06-15-10.00.00";
        var brandId = 1;
        var productId = 35455;
        var expectedResponse = Files.readString(Path.of("src/test/resources/test4_response.json"));

        // Act and Assert
        mockMvc.perform(
            get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("date", date)
                .queryParam("productId", String.valueOf(productId))
                .queryParam("brandId", String.valueOf(brandId)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(expectedResponse, true));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test5() throws Exception {
        // Arrange
        var date = "2020-06-16-21.00.00";
        var brandId = 1;
        var productId = 35455;
        var expectedResponse = Files.readString(Path.of("src/test/resources/test5_response.json"));

        // Act and Assert
        mockMvc.perform(
            get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("date", date)
                .queryParam("productId", String.valueOf(productId))
                .queryParam("brandId", String.valueOf(brandId)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(expectedResponse, true));
    }
}
