package com.NewCode.ServiceProduct;

import com.NewCode.ServiceProduct.command.api.Exception.ProductServiceEventsHandler;
import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProductApplication.class, args);
	}

	public void configure(EventProcessingConfigurer configurer){
		configurer.registerListenerInvocationErrorHandler("product", configuration -> new ProductServiceEventsHandler());
	}
}
