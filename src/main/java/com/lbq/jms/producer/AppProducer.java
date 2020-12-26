package com.lbq.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
		
		ProducerService service = (ProducerService) context.getBean("queueProducerService");
		
		for(int i = 0; i<100;i++) {
			service.sendMessage("spring-jms-queue_"+i);
		}
		
		context.close();
	}

}
