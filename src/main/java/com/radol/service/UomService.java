package com.radol.service;

import java.util.List;

import com.radol.dto.UomDTO;

public interface UomService {
    UomDTO createUom(UomDTO uomDTO);
    UomDTO getUomById(Integer uomId);
    List<UomDTO> getAllUoms();
    UomDTO updateUom(Integer uomId, UomDTO uomDTO);
    void deleteUom(Integer uomId);
}
