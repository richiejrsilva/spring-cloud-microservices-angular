package com.harmonyit.shoppinglist.itemservice.api.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harmonyit.shoppinglist.api.service.item.ItemServiceProxy;
import com.harmonyit.shoppinglist.domain.ItemDTO;
import com.harmonyit.shoppinglist.itemservice.service.ItemService;

@RestController
class ItemServiceRestImpl implements ItemServiceProxy {

	private static final Logger LOG = LoggerFactory.getLogger(ItemServiceRestImpl.class);

	@Autowired
	private ItemService itemService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/item/{itemId}")
	public ItemDTO getItem(@PathVariable(name = "itemId", required = true) final String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/item/all")
	public List<ItemDTO> getItemList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/item/all/{userId}")
	public List<ItemDTO> getItemList(@PathVariable(name = "userId", required = true) final String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
