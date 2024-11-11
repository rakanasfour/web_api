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

import com.radol.dto.BrandPictureDTO;
import com.radol.service.BrandPictureService;

@RestController
@RequestMapping("/api/brand-pictures")
public class BrandPictureController {

    private final BrandPictureService brandPictureService;

    @Autowired
    public BrandPictureController(BrandPictureService brandPictureService) {
        this.brandPictureService = brandPictureService;
    }

    @PostMapping
    public ResponseEntity<BrandPictureDTO> createBrandPicture(@RequestBody BrandPictureDTO brandPictureDTO) {
        BrandPictureDTO createdBrandPicture = brandPictureService.createBrandPicture(brandPictureDTO);
        return new ResponseEntity<>(createdBrandPicture, HttpStatus.CREATED);
    }

    @GetMapping("/{brandPictureId}")
    public ResponseEntity<BrandPictureDTO> getBrandPictureById(@PathVariable Integer brandPictureId) {
        BrandPictureDTO brandPicture = brandPictureService.getBrandPictureById(brandPictureId);
        return new ResponseEntity<>(brandPicture, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BrandPictureDTO>> getAllBrandPictures() {
        List<BrandPictureDTO> brandPictures = brandPictureService.getAllBrandPictures();
        return new ResponseEntity<>(brandPictures, HttpStatus.OK);
    }

    @PutMapping("/{brandPictureId}")
    public ResponseEntity<BrandPictureDTO> updateBrandPicture(@PathVariable Integer brandPictureId, @RequestBody BrandPictureDTO brandPictureDTO) {
        BrandPictureDTO updatedBrandPicture = brandPictureService.updateBrandPicture(brandPictureId, brandPictureDTO);
        return new ResponseEntity<>(updatedBrandPicture, HttpStatus.OK);
    }

    @DeleteMapping("/{brandPictureId}")
    public ResponseEntity<Void> deleteBrandPicture(@PathVariable Integer brandPictureId) {
        brandPictureService.deleteBrandPicture(brandPictureId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
