package com.dw.locmns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.sql.SQLOutput;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class LocmnsApplication {

	public static void main(String[] args) {

		SpringApplication.run(LocmnsApplication.class, args);

	}


	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}


}
