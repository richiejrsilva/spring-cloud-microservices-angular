package com.harmonyit.shoppinglist.api.service.item;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harmonyit.shoppinglist.domain.ItemDTO;

/**
 * The Interface ShoppingListServiceProxy.
 */
@FeignClient(name = "item-service")
public interface ItemServiceProxy {

	/**
	 * Gets the item.
	 *
	 * @param itemId the item id
	 * @return the item
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/item/{itemId}")
	ItemDTO getItem(@PathVariable(name = "itemId", required = true) final String itemId);

	/**
	 * Gets the item list.
	 *
	 * @return the item list
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/item/all")
	List<ItemDTO> getItemList();

	/**
	 * Gets the item list.
	 *
	 * @param userId the user id
	 * @return the item list
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/item/all/{userId}")
	List<ItemDTO> getItemList(@PathVariable(name = "userId", required = true) final String userId);

}
