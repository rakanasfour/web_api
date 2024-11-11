package com.radol.model;


import jakarta.persistence.*;

@Entity
@Table(name = "items_channels")
public class ItemsChannels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_ch_id" , columnDefinition = "INT UNSIGNED")
    private Integer itemChId;

    @ManyToOne
    @JoinColumn(name = "item_ch_channel_id", referencedColumnName = "channel_id")
    private Channel mappedChannel; // Assuming you have a Channel entity

    @ManyToOne
    @JoinColumn(name = "item_ch_item_id", referencedColumnName = "item_id")
    private Item mappedItemChannel; // Assuming you have an Item entity

	public ItemsChannels(Integer itemChId, Channel mappedChannel, Item mappedItemChannel) {
		super();
		this.itemChId = itemChId;
		this.mappedChannel = mappedChannel;
		this.mappedItemChannel = mappedItemChannel;
	}

	public ItemsChannels() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemChId() {
		return itemChId;
	}

	public void setItemChId(Integer itemChId) {
		this.itemChId = itemChId;
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
