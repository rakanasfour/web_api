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

import com.radol.dto.ManufacturerDTO;
import com.radol.service.ManufacturerService;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    public ResponseEntity<ManufacturerDTO> createManufacturer(@RequestBody ManufacturerDTO manufacturerDTO) {
        ManufacturerDTO createdManufacturer = manufacturerService.createManufacturer(manufacturerDTO);
        return new ResponseEntity<>(createdManufacturer, HttpStatus.CREATED);
    }

    @GetMapping("/{manufacturerId}")
    public ResponseEntity<ManufacturerDTO> getManufacturerById(@PathVariable Integer manufacturerId) {
        ManufacturerDTO manufacturer = manufacturerService.getManufacturerById(manufacturerId);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ManufacturerDTO>> getAllManufacturers() {
        List<ManufacturerDTO> manufacturers = manufacturerService.getAllManufacturers();
        return new ResponseEntity<>(manufacturers, HttpStatus.OK);
    }

    @PutMapping("/{manufacturerId}")
    public ResponseEntity<ManufacturerDTO> updateManufacturer(@PathVariable Integer manufacturerId, @RequestBody ManufacturerDTO manufacturerDTO) {
        ManufacturerDTO updatedManufacturer = manufacturerService.updateManufacturer(manufacturerId, manufacturerDTO);
        return new ResponseEntity<>(updatedManufacturer, HttpStatus.OK);
    }

    @DeleteMapping("/{manufacturerId}")
    public ResponseEntity<Void> deleteManufacturer(@PathVariable Integer manufacturerId) {
        manufacturerService.deleteManufacturer(manufacturerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
