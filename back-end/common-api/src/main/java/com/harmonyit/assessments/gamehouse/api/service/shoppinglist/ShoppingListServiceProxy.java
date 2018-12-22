package com.harmonyit.assessments.gamehouse.api.service.shoppinglist;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harmonyit.assessments.gamehouse.domain.ShoppingListDTO;

/**
 * The Interface ShoppingListServiceProxy.
 */
@FeignClient(name = "shopping-list-service")
public interface ShoppingListServiceProxy {

	/**
	 * Gets the user shopping list.
	 *
	 * @param userId the user id
	 * @return the user shopping list
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/shoppinglist/user/{userId}")
	ShoppingListDTO getUserShoppingList(@PathVariable(name = "userId", required = true) final String userId);
	
	/**
	 * Gets the shopping list.
	 *
	 * @param shoppinglistId the shoppinglist id
	 * @return the shopping list
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/shoppinglist/{shoppinglistId}")
	ShoppingListDTO getShoppingList(@PathVariable(name = "shoppinglistId", required = true) final String shoppinglistId);
	
	/**
	 * Gets the total shopping lists.
	 *
	 * @return the total shopping lists
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/shoppinglist/count")
	Integer getTotalShoppingLists();
	
	/**
	 * Adds the shopping list.
	 *
	 * @param shoppingList the shopping list
	 * @return the shopping list
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/shoppinglist/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	ShoppingListDTO addShoppingList(@RequestBody final ShoppingListDTO shoppingList);

	/**
	 * Gets the total shopping list items.
	 *
	 * @return the total shopping list items
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/shoppinglist/items/total")
	Integer getTotalShoppingListItems();
}
