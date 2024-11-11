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

import com.radol.dto.UomPictureDTO;
import com.radol.service.UomPictureService;

@RestController
@RequestMapping("/api/uompictures")
public class UomPictureController {

    private final UomPictureService uomPictureService;

    @Autowired
    public UomPictureController(UomPictureService uomPictureService) {
        this.uomPictureService = uomPictureService;
    }

    @PostMapping
    public ResponseEntity<UomPictureDTO> createUomPicture(@RequestBody UomPictureDTO uomPictureDTO) {
        UomPictureDTO createdUomPicture = uomPictureService.createUomPicture(uomPictureDTO);
        return new ResponseEntity<>(createdUomPicture, HttpStatus.CREATED);
    }

    @GetMapping("/{uomPictureId}")
    public ResponseEntity<UomPictureDTO> getUomPictureById(@PathVariable Integer uomPictureId) {
        UomPictureDTO uomPicture = uomPictureService.getUomPictureById(uomPictureId);
        return new ResponseEntity<>(uomPicture, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UomPictureDTO>> getAllUomPictures() {
        List<UomPictureDTO> uomPictures = uomPictureService.getAllUomPictures();
        return new ResponseEntity<>(uomPictures, HttpStatus.OK);
    }

    @PutMapping("/{uomPictureId}")
    public ResponseEntity<UomPictureDTO> updateUomPicture(@PathVariable Integer uomPictureId, @RequestBody UomPictureDTO uomPictureDTO) {
        UomPictureDTO updatedUomPicture = uomPictureService.updateUomPicture(uomPictureId, uomPictureDTO);
        return new ResponseEntity<>(updatedUomPicture, HttpStatus.OK);
    }

    @DeleteMapping("/{uomPictureId}")
    public ResponseEntity<Void> deleteUomPicture(@PathVariable Integer uomPictureId) {
        uomPictureService.deleteUomPicture(uomPictureId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
