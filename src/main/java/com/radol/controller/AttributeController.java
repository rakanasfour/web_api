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

import com.radol.dto.AttributeDTO;
import com.radol.service.AttributeService;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {

    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping
    public ResponseEntity<AttributeDTO> createAttribute(@RequestBody AttributeDTO attributeDTO) {
        AttributeDTO createdAttribute = attributeService.createAttribute(attributeDTO);
        return new ResponseEntity<>(createdAttribute, HttpStatus.CREATED);
    }

    @GetMapping("/{attributeId}")
    public ResponseEntity<AttributeDTO> getAttributeById(@PathVariable Integer attributeId) {
        AttributeDTO attribute = attributeService.getAttributeById(attributeId);
        return new ResponseEntity<>(attribute, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AttributeDTO>> getAllAttributes() {
        List<AttributeDTO> attributes = attributeService.getAllAttributes();
        return new ResponseEntity<>(attributes, HttpStatus.OK);
    }

    @PutMapping("/{attributeId}")
    public ResponseEntity<AttributeDTO> updateAttribute(@PathVariable Integer attributeId, @RequestBody AttributeDTO attributeDTO) {
        AttributeDTO updatedAttribute = attributeService.updateAttribute(attributeId, attributeDTO);
        return new ResponseEntity<>(updatedAttribute, HttpStatus.OK);
    }

    @DeleteMapping("/{attributeId}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable Integer attributeId) {
        attributeService.deleteAttribute(attributeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

