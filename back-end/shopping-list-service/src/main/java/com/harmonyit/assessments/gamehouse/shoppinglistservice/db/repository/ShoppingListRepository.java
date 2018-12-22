package com.harmonyit.assessments.gamehouse.shoppinglistservice.db.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harmonyit.assessments.gamehouse.shoppinglistservice.db.entity.ShoppingList;

/**
 * The Interface ShoppingListRepository.
 */
@Repository
public interface ShoppingListRepository extends CrudRepository <ShoppingList, Integer>{

    /**
     * Gets the total shopping lists.
     *
     * @return the total shopping lists
     */
    @Query(value = "SELECT COUNT(distinct sl.SH_LIST_ID) FROM SHOPPING_LIST sl JOIN SHOPPING_LIST_ITEMS sli ON sl.SH_LIST_ID = sli.SH_LIST_ID", nativeQuery = true)
    Integer getTotalShoppingLists();

    /**
     * Gets the total shopping list items.
     *
     * @return the total shopping list items
     */
    @Query(value = "SELECT COUNT(sli.SH_LIST_ID) FROM SHOPPING_LIST_ITEMS sli", nativeQuery = true)
	Integer getTotalShoppingListItems();

}
