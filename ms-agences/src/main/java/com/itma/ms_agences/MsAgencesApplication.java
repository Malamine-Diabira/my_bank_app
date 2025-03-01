package com.itma.ms_agences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsAgencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAgencesApplication.class, args);
	}

}
