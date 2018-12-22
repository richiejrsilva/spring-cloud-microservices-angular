package com.harmonyit.assessments.gamehouse.itemservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.harmonyit.assessments.gamehouse.domain.ItemDTO;
import com.harmonyit.assessments.gamehouse.itemservice.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public Optional<ItemDTO> getItem(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<ItemDTO>> getItemList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<ItemDTO>> getItemList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
