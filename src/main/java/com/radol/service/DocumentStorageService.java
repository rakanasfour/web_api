package com.radol.service;

import java.util.List;

import com.radol.dto.DocumentStorageDTO;

public interface DocumentStorageService {
    DocumentStorageDTO createDocumentStorage(DocumentStorageDTO documentStorageDTO);
    DocumentStorageDTO getDocumentStorageById(Integer documentStorageId);
    List<DocumentStorageDTO> getAllDocumentStorages();
    DocumentStorageDTO updateDocumentStorage(Integer documentStorageId, DocumentStorageDTO documentStorageDTO);
    void deleteDocumentStorage(Integer documentStorageId);
}