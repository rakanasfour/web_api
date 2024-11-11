package com.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radol.dto.DocumentStorageDTO;
import com.radol.exception.ResourceNotFoundException;
import com.radol.model.DocumentStorage;
import com.radol.repository.DocumentStorageRepository;
import com.radol.repository.ItemRepository;
import com.radol.service.DocumentStorageService;

@Service
public class DocumentStorageServiceImpl implements DocumentStorageService {

    private final DocumentStorageRepository documentStorageRepository;
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentStorageServiceImpl(DocumentStorageRepository documentStorageRepository, ItemRepository itemRepository, ModelMapper modelMapper) {
        this.documentStorageRepository = documentStorageRepository;
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DocumentStorageDTO createDocumentStorage(DocumentStorageDTO documentStorageDTO) {
        DocumentStorage documentStorage = modelMapper.map(documentStorageDTO, DocumentStorage.class);

        // Set Item relationship
        documentStorage.setItem(itemRepository.findById(documentStorageDTO.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found")));

        DocumentStorage savedDocumentStorage = documentStorageRepository.save(documentStorage);
        return modelMapper.map(savedDocumentStorage, DocumentStorageDTO.class);
    }

    @Override
    public DocumentStorageDTO getDocumentStorageById(Integer documentStorageId) {
        DocumentStorage documentStorage = documentStorageRepository.findById(documentStorageId)
            .orElseThrow(() -> new ResourceNotFoundException("Document Storage not found"));
        return modelMapper.map(documentStorage, DocumentStorageDTO.class);
    }

    @Override
    public List<DocumentStorageDTO> getAllDocumentStorages() {
        return documentStorageRepository.findAll().stream()
            .map(documentStorage -> modelMapper.map(documentStorage, DocumentStorageDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public DocumentStorageDTO updateDocumentStorage(Integer documentStorageId, DocumentStorageDTO documentStorageDTO) {
        DocumentStorage existingDocumentStorage = documentStorageRepository.findById(documentStorageId)
            .orElseThrow(() -> new ResourceNotFoundException("Document Storage not found"));

        // Update fields from DTO
        existingDocumentStorage.setDocumentStorage1(documentStorageDTO.getDocumentStorage1());

        // Update Item relationship
        existingDocumentStorage.setItem(itemRepository.findById(documentStorageDTO.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found")));

        DocumentStorage updatedDocumentStorage = documentStorageRepository.save(existingDocumentStorage);
        return modelMapper.map(updatedDocumentStorage, DocumentStorageDTO.class);
    }

    @Override
    public void deleteDocumentStorage(Integer documentStorageId) {
        DocumentStorage documentStorage = documentStorageRepository.findById(documentStorageId)
            .orElseThrow(() -> new ResourceNotFoundException("Document Storage not found"));
        documentStorageRepository.delete(documentStorage);
    }
}
