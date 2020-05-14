/*
 * @(#) CustomMessage.java 2020. 04. 20.
 *
 * Copyright 2020. PlayD Corp. All rights Reserved.
 */
package com.playd.msclient.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author 박준영
 */

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = CustomMessage.class)
public class CustomMessage {
	private String text;
	private int priority;
	private boolean secret;

	public CustomMessage(String text, int priority, boolean secret) {
		this.text = text;
		this.priority = priority;
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "CustomeMessage{" +
				"text = " + text + "\n" +
				"priority = " + priority + "\n" +
				"secret = "  + secret + "\n" +
				"}";
	}
}
