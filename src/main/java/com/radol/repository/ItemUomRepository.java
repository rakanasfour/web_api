package com.radol.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.radol.model.ItemUOM;
import com.radol.model.Uom;

@Repository
public interface ItemUomRepository extends JpaRepository<ItemUOM, Integer> {

  // @Transactional
  // void deleteAllByUom(Uom mappedUomItem );
    
    
}
