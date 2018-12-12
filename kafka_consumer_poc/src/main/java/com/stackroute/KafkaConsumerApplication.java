package com.stackroute;

import com.stackroute.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@RestController
public class KafkaConsumerApplication {



	List <String> messages = new ArrayList<>();
	List <User> users = new ArrayList<>();
//
//	@GetMapping("/consumeStringMessage")
//	public List<String> consumeMsg(){
//		return messages;
//	}

	@GetMapping("/getjson")
	public List<User> consumeUser(){
		return users;
	}
//
//	@KafkaListener(groupId = "kafkaconsumer",topics="KafkaExample",containerFactory ="kafkaListenerContainerFactory")
//	public List getMsgFrmTopic(String data){
//		messages.add(data);
//		return messages;
//	}

	@KafkaListener(groupId = "kafkauserconsumer",topics="kafkajsontest",containerFactory ="kafkaUserListenerContainerFactory")
	public List getUserFrmTopic(@Payload User user){
		users.add(user);
		System.out.println("Consumed Json Message: "+ user.toString());
		return users;
	}
	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}
}
