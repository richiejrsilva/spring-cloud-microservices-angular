package com.harmonyit.shoppinglist.shoppinglistservice.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class ShoppingListItem.
 */
@Entity
@Table(name = "SHOPPING_LIST_ITEMS")
public class ShoppingListItem {

	/** The identifier. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHOPPING_LIST_ITEM_SEQ")
	@SequenceGenerator(allocationSize = 1, name = "SHOPPING_LIST_ITEM_SEQ", sequenceName = "SHOPPING_LIST_ITEM_SEQ")
	@Column(name = "SH_L_ITEMS_ID", updatable = false)
	private Integer identifier;
	
	/** The SH_LIST_ID. */
	@Column(name = "SH_LIST_ID")
	private Integer shoppingListId;
	/** The item id. */
	@Column(name = "ITEM_ID")
	private Integer itemId;

}
