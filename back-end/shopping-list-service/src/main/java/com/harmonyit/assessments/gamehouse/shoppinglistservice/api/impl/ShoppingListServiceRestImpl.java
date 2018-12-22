package com.harmonyit.assessments.gamehouse.shoppinglistservice.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harmonyit.assessments.gamehouse.api.service.shoppinglist.ShoppingListServiceProxy;
import com.harmonyit.assessments.gamehouse.domain.ShoppingListDTO;
import com.harmonyit.assessments.gamehouse.shoppinglistservice.service.ShoppingListService;

/**
 * The Class ShoppingListServiceRestImpl.
 */
@RestController
class ShoppingListServiceRestImpl implements ShoppingListServiceProxy {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ShoppingListServiceRestImpl.class);

	/** The shopping list service. */
	@Autowired
	private ShoppingListService shoppingListService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/shoppinglist/user/{userId}")
	public ShoppingListDTO getUserShoppingList(@PathVariable(name = "userId", required = true) final String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/shoppinglist/{shoppinglistId}")
	public ShoppingListDTO getShoppingList(@PathVariable(name = "shoppinglistId", required = true) final String shoppinglistId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = "/shoppinglist/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ShoppingListDTO addShoppingList(@RequestBody final ShoppingListDTO shoppingList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/shoppinglist/count")
	public Integer getTotalShoppingLists() {
		return shoppingListService.getTotalShoppingLists();
	}
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/shoppinglist/items/total")
	public Integer getTotalShoppingListItems() {
		return shoppingListService.getTotalShoppingListItems();
	}

}
