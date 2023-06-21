package com.dw.locmns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.sql.SQLOutput;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class LocmnsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(LocmnsApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LocmnsApplication.class);
	}

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}


}
