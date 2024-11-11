package com.radol.service;

import java.util.List;

import com.radol.dto.PackagingDTO;

public interface PackagingService {
    PackagingDTO createPackaging(PackagingDTO packagingDTO);
    PackagingDTO getPackagingById(Integer packagingId);
    List<PackagingDTO> getAllPackagings();
    PackagingDTO updatePackaging(Integer packagingId, PackagingDTO packagingDTO);
    void deletePackaging(Integer packagingId);
}