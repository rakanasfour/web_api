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

import com.radol.dto.ModelDTO;
import com.radol.service.ModelService;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ResponseEntity<ModelDTO> createModel(@RequestBody ModelDTO modelDTO) {
        ModelDTO createdModel = modelService.createModel(modelDTO);
        return new ResponseEntity<>(createdModel, HttpStatus.CREATED);
    }

    @GetMapping("/{modelId}")
    public ResponseEntity<ModelDTO> getModelById(@PathVariable Integer modelId) {
        ModelDTO model = modelService.getModelById(modelId);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ModelDTO>> getAllModels() {
        List<ModelDTO> models = modelService.getAllModels();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @PutMapping("/{modelId}")
    public ResponseEntity<ModelDTO> updateModel(@PathVariable Integer modelId, @RequestBody ModelDTO modelDTO) {
        ModelDTO updatedModel = modelService.updateModel(modelId, modelDTO);
        return new ResponseEntity<>(updatedModel, HttpStatus.OK);
    }

    @DeleteMapping("/{modelId}")
    public ResponseEntity<Void> deleteModel(@PathVariable Integer modelId) {
        modelService.deleteModel(modelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
