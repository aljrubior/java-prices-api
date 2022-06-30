package com.inditex.pricesapi.controller;

import com.inditex.pricesapi.model.entities.Price;
import com.inditex.pricesapi.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Operation(
    summary = "Retrieve the price associated for given date, productId and brandId",
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Price.class))),
    })
    @GetMapping
    public ResponseEntity getPrices(
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date,
        @RequestParam Integer brandId,
        @RequestParam Long productId) throws Exception {

        Optional<Price> price = this.priceService.getPrice(date, brandId, productId);

        return ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(price.orElse(null));
    }
}
