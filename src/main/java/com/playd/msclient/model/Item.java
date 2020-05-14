/*
 * @(#) Item.java 2020. 04. 22.
 *
 * Copyright 2020. PlayD Corp. All rights Reserved.
 */
package com.playd.msclient.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 박준영
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id",scope = Item.class)
@Data
@NoArgsConstructor
public class Item {
	private String itemName;
	private String category;
	private String description;
}
