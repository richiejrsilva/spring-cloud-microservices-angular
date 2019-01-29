package com.harmonyit.shoppinglist.itemservice.service;

import java.util.List;
import java.util.Optional;

import com.harmonyit.shoppinglist.domain.ItemDTO;

/**
 * The Interface ItemService.
 */
public interface ItemService {

	/**
	 * Gets the item.
	 *
	 * @param itemId the item id
	 * @return the item
	 */
	Optional<ItemDTO> getItem(final String itemId);

	/**
	 * Gets the item list.
	 *
	 * @return the item list
	 */
	Optional<List<ItemDTO>> getItemList();

	/**
	 * Gets the item list.
	 *
	 * @param userId the user id
	 * @return the item list
	 */
	Optional<List<ItemDTO>> getItemList(final String userId);

}
