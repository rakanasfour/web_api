package com.radol.service;

import java.util.List;

import com.radol.dto.ManufacturerDTO;

public interface ManufacturerService {
    ManufacturerDTO createManufacturer(ManufacturerDTO manufacturerDTO);
    ManufacturerDTO getManufacturerById(Integer manufacturerId);
    List<ManufacturerDTO> getAllManufacturers();
    ManufacturerDTO updateManufacturer(Integer manufacturerId, ManufacturerDTO manufacturerDTO);
    void deleteManufacturer(Integer manufacturerId);
}