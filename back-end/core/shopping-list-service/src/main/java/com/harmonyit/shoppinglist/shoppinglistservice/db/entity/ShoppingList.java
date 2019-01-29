package com.harmonyit.shoppinglist.shoppinglistservice.db.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class ShoppingListDTO.
 */
@Entity
@Table(name = "SHOPPING_LIST")
public class ShoppingList {

	/** The identifier. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHOPPING_LIST_SEQ")
	@SequenceGenerator(allocationSize = 1, name = "SHOPPING_LIST_SEQ", sequenceName = "SHOPPING_LIST_SEQ")
	@Column(name = "SH_LIST_ID", updatable = false)
	private Integer identifier;

	/** The Description. */
	@Column(name = "SH_LIST_DESCRIPTION")
	private String description;

	/** The owner id. */
	@Column(name = "SH_LIST_OWNER_ID")
	private Integer ownerId;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ShoppingListItem> comments = new ArrayList<>();

}
