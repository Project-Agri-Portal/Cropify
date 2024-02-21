package com.cropify;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import com.cropify.services.impl.MailSenderService;

import org.modelmapper.Conditions;

@SpringBootApplication
public class Application {

	// @Autowired
	// private MailSenderService mailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
	.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}

	// @EventListener(ApplicationReadyEvent.class)
	// public void sendMail(){
	// 	mailSenderService.sendEmail("mohitkartejas002@gmail.com", "This is subject", "This is body");
	// }

}
