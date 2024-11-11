package com.radol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radol.dto.ManufacturerPricingDTO;
import com.radol.service.ManufacturerPricingService;

@RestController
@RequestMapping("/api/manufacturer-pricing")
public class ManufacturerPricingController {

    private final ManufacturerPricingService pricingService;

    @Autowired
    public ManufacturerPricingController(ManufacturerPricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping
    public ResponseEntity<ManufacturerPricingDTO> createPricing(@RequestBody ManufacturerPricingDTO pricingDTO) {
        ManufacturerPricingDTO createdPricing = pricingService.createPricing(pricingDTO);
        return new ResponseEntity<>(createdPricing, HttpStatus.CREATED);
    }

    @GetMapping("/{pricingId}")
    public ResponseEntity<ManufacturerPricingDTO> getPricingById(@PathVariable Integer pricingId) {
        ManufacturerPricingDTO pricing = pricingService.getPricingById(pricingId);
        return new ResponseEntity<>(pricing, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ManufacturerPricingDTO>> getAllPricing() {
        List<ManufacturerPricingDTO> pricingList = pricingService.getAllPricing();
        return new ResponseEntity<>(pricingList, HttpStatus.OK);
    }

    @PutMapping("/{pricingId}")
    public ResponseEntity<ManufacturerPricingDTO> updatePricing(@PathVariable Integer pricingId, @RequestBody ManufacturerPricingDTO pricingDTO) {
        ManufacturerPricingDTO updatedPricing = pricingService.updatePricing(pricingId, pricingDTO);
        return new ResponseEntity<>(updatedPricing, HttpStatus.OK);
    }

    @DeleteMapping("/{pricingId}")
    public ResponseEntity<Void> deletePricing(@PathVariable Integer pricingId) {
        pricingService.deletePricing(pricingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}