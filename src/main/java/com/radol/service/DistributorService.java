package com.radol.service;

import java.util.List;

import com.radol.dto.DistributorDTO;

public interface DistributorService {
    DistributorDTO createDistributor(DistributorDTO distributorDTO);
    DistributorDTO getDistributorById(Integer distributorId);
    List<DistributorDTO> getAllDistributors();
    DistributorDTO updateDistributor(Integer distributorId, DistributorDTO distributorDTO);
    void deleteDistributor(Integer distributorId);
}