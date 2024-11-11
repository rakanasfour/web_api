package com.radol.model;

import jakarta.persistence.*;


@Entity
@Table(name = "document_storage")
public class DocumentStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_storage_id" , columnDefinition = "INT UNSIGNED")
    private Integer documentStorageId;

    @Column(name = "document_storage_1", length = 300)
    private String documentStorage1;

    // Many-to-one relationship with Item
    @ManyToOne
    @JoinColumn(name = "document_s_item_id", referencedColumnName = "item_id", nullable = false)
    private Item item;

    // Getters and Setters
    public Integer getDocumentStorageId() {
        return documentStorageId;
    }

    public void setDocumentStorageId(Integer documentStorageId) {
        this.documentStorageId = documentStorageId;
    }

    public String getDocumentStorage1() {
        return documentStorage1;
    }

    public void setDocumentStorage1(String documentStorage1) {
        this.documentStorage1 = documentStorage1;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
