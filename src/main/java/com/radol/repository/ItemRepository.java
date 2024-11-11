package com.radol.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.radol.dto.ItemUOMDTO;
import com.radol.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	
	
	//@Query("SELECT new com.radol.dto.ItemUOMDTO(i.itemName) FROM Item i WHERE i.itemId = :itemId")

	//@Query("SELECT new com.radol.dto.ItemUOMDTO(i.itemName, i.itemBasePrice) FROM Item i")
	//@Query("SELECT new com.radol.dto.ItemUOMDTO(i.itemName, i.itemBasePrice) FROM Item i WHERE i.itemId = :itemId")
	//public  List<ItemUOMDTO> findItemNames(@Param("itemId") int itemId);




	/*
	 @Query("SELECT new com.radol.dto.ItemUOMDTO(i.itemName, i.itemSku, i.itemDescription, i.itemType, i.itemQuantity, "
	           + "i.itemBasePrice, i.itemWeight, u.uomLevel, u.uomType, iu.itemUomQuantity, "
	           + "(iu.itemUomQuantity * i.itemBasePrice)) "
	           + "FROM Item i "
	           + "JOIN i.itemsUoms iu "
	           + "JOIN iu.uom u "
	           + "WHERE i.itemId = :itemId")
	    List<ItemUOMDTO> findItemUom(@Param("itemId") int itemId);

	///Optional<ItemUOMDTO> findItemNamesById(@Param("itemId") int itemId);
*/


}