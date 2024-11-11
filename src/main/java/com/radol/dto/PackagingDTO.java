package com.radol.dto;

import java.util.List;
import java.util.Set;

import com.radol.model.Packaging;
import com.radol.model.Packaging.PackagingType;

public class PackagingDTO {
    private Integer packagingId;
    private Packaging.PackagingType packagingType;
    private List<Integer> uomIds;
    
	public PackagingDTO(Integer packagingId, PackagingType packagingType, List<Integer> uomIds) {
		super();
		this.packagingId = packagingId;
		this.packagingType = packagingType;
		this.uomIds = uomIds;
	}

	public PackagingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPackagingId() {
		return packagingId;
	}

	public void setPackagingId(Integer packagingId) {
		this.packagingId = packagingId;
	}

	public Packaging.PackagingType getPackagingType() {
		return packagingType;
	}

	public void setPackagingType(Packaging.PackagingType packagingType) {
		this.packagingType = packagingType;
	}

	public List<Integer> getUomIds() {
		return uomIds;
	}

	public void setUomIds(List<Integer> uomIds) {
		this.uomIds = uomIds;
	}
    
    
	
    
    
}
