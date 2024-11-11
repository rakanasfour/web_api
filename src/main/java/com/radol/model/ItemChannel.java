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
@Table(name = "items_channels")
public class ItemChannel {
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_ch_id" , columnDefinition = "INT UNSIGNED")
    private Integer itemChannelId;

    @ManyToOne
    @JoinColumn(name = "item_ch_channel_id", nullable = false)
    private Channel mappedChannel;

    @ManyToOne
    @JoinColumn(name = "item_ch_item_id", nullable = false)
    private Item mappedItemChannel;

    
    
	public ItemChannel(Integer itemChannelId, Channel mappedChannel, Item mappedItemChannel) {
		super();
		this.itemChannelId = itemChannelId;
		this.mappedChannel = mappedChannel;
		this.mappedItemChannel = mappedItemChannel;
	}

	public ItemChannel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemChannelId() {
		return itemChannelId;
	}

	public void setItemChannelId(Integer itemChannelId) {
		this.itemChannelId = itemChannelId;
	}

	public Channel getMappedChannel() {
		return mappedChannel;
	}

	public void setMappedChannel(Channel mappedChannel) {
		this.mappedChannel = mappedChannel;
	}

	public Item getMappedItemChannel() {
		return mappedItemChannel;
	}

	public void setMappedItemChannel(Item mappedItemChannel) {
		this.mappedItemChannel = mappedItemChannel;
	}

    
    
    
    
}
