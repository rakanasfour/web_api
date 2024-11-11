package com.radol.service;

import java.util.List;

import com.radol.dto.ManufacturerFacilityDTO;

public interface ManufacturerFacilityService {
    ManufacturerFacilityDTO createFacility(ManufacturerFacilityDTO facilityDTO);
    ManufacturerFacilityDTO getFacilityById(Integer facilityId);
    List<ManufacturerFacilityDTO> getAllFacilities();
    ManufacturerFacilityDTO updateFacility(Integer facilityId, ManufacturerFacilityDTO facilityDTO);
    void deleteFacility(Integer facilityId);
}