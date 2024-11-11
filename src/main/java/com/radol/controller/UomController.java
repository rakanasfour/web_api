package com.radol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radol.dto.UomDTO;
import com.radol.service.UomService;

@RestController
@RequestMapping("/api/uoms")
public class UomController {

    private final UomService uomService;

    @Autowired
    public UomController(UomService uomService) {
        this.uomService = uomService;
    }
/*
    @PostMapping
    public ResponseEntity<UomDTO> createUom(@RequestBody UomDTO uomDTO) {
        UomDTO createdUom = uomService.createUom(uomDTO);
        return new ResponseEntity<>(createdUom, HttpStatus.CREATED);
    }
 

    @GetMapping("/{uomId}")
    public ResponseEntity<UomDTO> getUomById(@PathVariable Integer uomId) {
        UomDTO uom = uomService.getUomById(uomId);
        return new ResponseEntity<>(uom, HttpStatus.OK);
    }



    @PutMapping("/{uomId}")
    public ResponseEntity<UomDTO> updateUom(@PathVariable Integer uomId, @RequestBody UomDTO uomDTO) {
        UomDTO updatedUom = uomService.updateUom(uomId, uomDTO);
        return new ResponseEntity<>(updatedUom, HttpStatus.OK);
    }

    @DeleteMapping("/{uomId}")
    public ResponseEntity<Void> deleteUom(@PathVariable Integer uomId) {
        uomService.deleteUom(uomId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
       */
    @GetMapping
    public ResponseEntity<List<UomDTO>> getAllUoms() {
        List<UomDTO> uoms = uomService.getAllUoms();
        return new ResponseEntity<>(uoms, HttpStatus.OK);
    }
}
