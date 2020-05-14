package com.playd.msclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlaydMsClientApplication{
	public static void main(String[] args) {
		SpringApplication.run(PlaydMsClientApplication.class, args);
	}
}
