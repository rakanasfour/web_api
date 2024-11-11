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

import com.radol.dto.DocumentStorageDTO;
import com.radol.service.DocumentStorageService;

@RestController
@RequestMapping("/api/document-storages")
public class DocumentStorageController {

    private final DocumentStorageService documentStorageService;

    @Autowired
    public DocumentStorageController(DocumentStorageService documentStorageService) {
        this.documentStorageService = documentStorageService;
    }

    @PostMapping
    public ResponseEntity<DocumentStorageDTO> createDocumentStorage(@RequestBody DocumentStorageDTO documentStorageDTO) {
        DocumentStorageDTO createdDocumentStorage = documentStorageService.createDocumentStorage(documentStorageDTO);
        return new ResponseEntity<>(createdDocumentStorage, HttpStatus.CREATED);
    }

    @GetMapping("/{documentStorageId}")
    public ResponseEntity<DocumentStorageDTO> getDocumentStorageById(@PathVariable Integer documentStorageId) {
        DocumentStorageDTO documentStorage = documentStorageService.getDocumentStorageById(documentStorageId);
        return new ResponseEntity<>(documentStorage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DocumentStorageDTO>> getAllDocumentStorages() {
        List<DocumentStorageDTO> documentStorages = documentStorageService.getAllDocumentStorages();
        return new ResponseEntity<>(documentStorages, HttpStatus.OK);
    }

    @PutMapping("/{documentStorageId}")
    public ResponseEntity<DocumentStorageDTO> updateDocumentStorage(@PathVariable Integer documentStorageId, @RequestBody DocumentStorageDTO documentStorageDTO) {
        DocumentStorageDTO updatedDocumentStorage = documentStorageService.updateDocumentStorage(documentStorageId, documentStorageDTO);
        return new ResponseEntity<>(updatedDocumentStorage, HttpStatus.OK);
    }

    @DeleteMapping("/{documentStorageId}")
    public ResponseEntity<Void> deleteDocumentStorage(@PathVariable Integer documentStorageId) {
        documentStorageService.deleteDocumentStorage(documentStorageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
