package com.multipolar.vagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VaGatewayApplication {

	public static void main(String[] args) {
//		String test = "Kode OTP:&nbsp; ${otp} Ref: ${ref} berlaku 5 menit.";
//		String echo = test.replace("${otp}", "1234").replace("${ref}", "456789");
//		System.out.println("ini test => "+echo);

		SpringApplication.run(VaGatewayApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "PUT", "POST", "DELETE");
				//.allowedOrigins("localhost:4200");
			}
		};
	}

}
