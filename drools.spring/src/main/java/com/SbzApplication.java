package com;

 
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

 
@SpringBootApplication

public class SbzApplication{

	public static void main(String[] args) {
		SpringApplication.run(SbzApplication.class, args);
	 
	}
	public SbzApplication(){}
	
	@Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }
}