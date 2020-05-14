/*
 * @(#) Constants.java 2020. 05. 12.
 *
 * Copyright 2020. PlayD Corp. All rights Reserved.
 */
package com.playd.msclient.model;

/**
 * @author 박준영
 */
public class Constants {
	private static final String QUEUE_NAME = "q-playd";
	public static final String INCOMING_QUEUE_NAME = QUEUE_NAME + ".incoming";
	public static final String EXCHANGE_NAME = QUEUE_NAME + ".exchange";
	public static final String WAITING_QUEUE_NAME = QUEUE_NAME + ".waiting";
	public static final String ROUTING_KEY_NAME = "q-playd";
}
