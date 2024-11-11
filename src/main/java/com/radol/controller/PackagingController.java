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

import com.radol.dto.PackagingDTO;
import com.radol.service.PackagingService;

@RestController
@RequestMapping("/api/packaging")
public class PackagingController {

    private final PackagingService packagingService;

    @Autowired
    public PackagingController(PackagingService packagingService) {
        this.packagingService = packagingService;
    }

    @PostMapping
    public ResponseEntity<PackagingDTO> createPackaging(@RequestBody PackagingDTO packagingDTO) {
        PackagingDTO createdPackaging = packagingService.createPackaging(packagingDTO);
        return new ResponseEntity<>(createdPackaging, HttpStatus.CREATED);
    }

    @GetMapping("/{packagingId}")
    public ResponseEntity<PackagingDTO> getPackagingById(@PathVariable Integer packagingId) {
        PackagingDTO packaging = packagingService.getPackagingById(packagingId);
        return new ResponseEntity<>(packaging, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PackagingDTO>> getAllPackagings() {
        List<PackagingDTO> packagings = packagingService.getAllPackagings();
        return new ResponseEntity<>(packagings, HttpStatus.OK);
    }

    @PutMapping("/{packagingId}")
    public ResponseEntity<PackagingDTO> updatePackaging(@PathVariable Integer packagingId, @RequestBody PackagingDTO packagingDTO) {
        PackagingDTO updatedPackaging = packagingService.updatePackaging(packagingId, packagingDTO);
        return new ResponseEntity<>(updatedPackaging, HttpStatus.OK);
    }

    @DeleteMapping("/{packagingId}")
    public ResponseEntity<Void> deletePackaging(@PathVariable Integer packagingId) {
        packagingService.deletePackaging(packagingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
