package com.radol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_pictures")
public class ItemPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_picture_id" , columnDefinition = "INT UNSIGNED")
    private Integer itemPictureId;

    @Column(name = "item_picture_main", length = 250)
    private String itemPictureMain;

    // Many-to-one relationship with Item
    @ManyToOne
    @JoinColumn(name = "item_p_item_id", referencedColumnName = "item_id", nullable = false)
    private Item item;

    // Getters and Setters
    public Integer getItemPictureId() {
        return itemPictureId;
    }

    public void setItemPictureId(Integer itemPictureId) {
        this.itemPictureId = itemPictureId;
    }

    public String getItemPictureMain() {
        return itemPictureMain;
    }

    public void setItemPictureMain(String itemPictureMain) {
        this.itemPictureMain = itemPictureMain;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}