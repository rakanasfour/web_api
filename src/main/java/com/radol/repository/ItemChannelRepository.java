package com.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radol.model.Channel;
import com.radol.model.ItemChannel;

import jakarta.transaction.Transactional;

@Repository
public interface ItemChannelRepository extends JpaRepository<ItemChannel, Integer> {

    @Transactional
    void deleteAllByMappedChannel(Channel mappedChannel);
}