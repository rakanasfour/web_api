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

import com.radol.dto.ModelPictureDTO;
import com.radol.service.ModelPictureService;

@RestController
@RequestMapping("/api/modelpictures")
public class ModelPictureController {

    private final ModelPictureService modelPictureService;

    @Autowired
    public ModelPictureController(ModelPictureService modelPictureService) {
        this.modelPictureService = modelPictureService;
    }

    @PostMapping
    public ResponseEntity<ModelPictureDTO> createModelPicture(@RequestBody ModelPictureDTO modelPictureDTO) {
        ModelPictureDTO createdModelPicture = modelPictureService.createModelPicture(modelPictureDTO);
        return new ResponseEntity<>(createdModelPicture, HttpStatus.CREATED);
    }

    @GetMapping("/{modelPictureId}")
    public ResponseEntity<ModelPictureDTO> getModelPictureById(@PathVariable Integer modelPictureId) {
        ModelPictureDTO modelPicture = modelPictureService.getModelPictureById(modelPictureId);
        return new ResponseEntity<>(modelPicture, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ModelPictureDTO>> getAllModelPictures() {
        List<ModelPictureDTO> modelPictures = modelPictureService.getAllModelPictures();
        return new ResponseEntity<>(modelPictures, HttpStatus.OK);
    }

    @PutMapping("/{modelPictureId}")
    public ResponseEntity<ModelPictureDTO> updateModelPicture(@PathVariable Integer modelPictureId, @RequestBody ModelPictureDTO modelPictureDTO) {
        ModelPictureDTO updatedModelPicture = modelPictureService.updateModelPicture(modelPictureId, modelPictureDTO);
        return new ResponseEntity<>(updatedModelPicture, HttpStatus.OK);
    }

    @DeleteMapping("/{modelPictureId}")
    public ResponseEntity<Void> deleteModelPicture(@PathVariable Integer modelPictureId) {
        modelPictureService.deleteModelPicture(modelPictureId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

