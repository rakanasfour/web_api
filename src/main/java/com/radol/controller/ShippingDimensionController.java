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

import com.radol.dto.ShippingDimensionDTO;
import com.radol.service.ShippingDimensionService;

@RestController
@RequestMapping("/api/shipping-dimensions")
public class ShippingDimensionController {

    private final ShippingDimensionService shippingDimensionService;

    @Autowired
    public ShippingDimensionController(ShippingDimensionService shippingDimensionService) {
        this.shippingDimensionService = shippingDimensionService;
    }

    @PostMapping
    public ResponseEntity<ShippingDimensionDTO> createShippingDimension(@RequestBody ShippingDimensionDTO shippingDimensionDTO) {
        ShippingDimensionDTO createdShippingDimension = shippingDimensionService.createShippingDimension(shippingDimensionDTO);
        return new ResponseEntity<>(createdShippingDimension, HttpStatus.CREATED);
    }

    @GetMapping("/{shippingDimensionId}")
    public ResponseEntity<ShippingDimensionDTO> getShippingDimensionById(@PathVariable Integer shippingDimensionId) {
        ShippingDimensionDTO shippingDimension = shippingDimensionService.getShippingDimensionById(shippingDimensionId);
        return new ResponseEntity<>(shippingDimension, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShippingDimensionDTO>> getAllShippingDimensions() {
        List<ShippingDimensionDTO> shippingDimensions = shippingDimensionService.getAllShippingDimensions();
        return new ResponseEntity<>(shippingDimensions, HttpStatus.OK);
    }

    @PutMapping("/{shippingDimensionId}")
    public ResponseEntity<ShippingDimensionDTO> updateShippingDimension(@PathVariable Integer shippingDimensionId, @RequestBody ShippingDimensionDTO shippingDimensionDTO) {
        ShippingDimensionDTO updatedShippingDimension = shippingDimensionService.updateShippingDimension(shippingDimensionId, shippingDimensionDTO);
        return new ResponseEntity<>(updatedShippingDimension, HttpStatus.OK);
    }

    @DeleteMapping("/{shippingDimensionId}")
    public ResponseEntity<Void> deleteShippingDimension(@PathVariable Integer shippingDimensionId) {
        shippingDimensionService.deleteShippingDimension(shippingDimensionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
