package com.lbq.jms.producer.topic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lbq.jms.producer.ProducerService;

public class AppProducer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
		
		ProducerService service = (ProducerService) context.getBean("topicProducerService");
		
		for(int i = 0; i<100;i++) {
			service.sendMessage("spring-jms-topic_"+i);
		}
		
		context.close();
	}

}
