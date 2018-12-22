package com.harmonyit.assessments.gamehouse.shoppinglistservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harmonyit.assessments.gamehouse.shoppinglistservice.db.repository.ShoppingListRepository;
import com.harmonyit.assessments.gamehouse.shoppinglistservice.service.ShoppingListService;

/**
 * The Class ShoppingListServiceImpl.
 */
@Service
@Transactional
public class ShoppingListServiceImpl implements ShoppingListService {

	/** The application repository. */
	@Autowired
	private ShoppingListRepository applicationRepository;

	// @Autowired
	// private ShoppingListMapper ShoppingListMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.harmonyit.assessments.gamehouse.shoppinglistservice.service.
	 * ShoppingListService#getTotalShoppingLists()
	 */
	@Override
	public Integer getTotalShoppingLists() {
		return applicationRepository.getTotalShoppingLists();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.harmonyit.assessments.gamehouse.shoppinglistservice.service.
	 * ShoppingListService#getTotalShoppingListItems()
	 */
	@Override
	public Integer getTotalShoppingListItems() {
		return applicationRepository.getTotalShoppingListItems();
	}

}
