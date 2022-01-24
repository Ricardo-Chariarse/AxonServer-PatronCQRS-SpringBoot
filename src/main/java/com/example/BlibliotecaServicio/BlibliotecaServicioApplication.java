package com.example.BlibliotecaServicio;

import com.example.BlibliotecaServicio.exception.LibroServiceEventsErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlibliotecaServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlibliotecaServicioApplication.class, args);
	}
	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler(
				"libro",
				configuration -> new LibroServiceEventsErrorHandler()
		);
	}
}
