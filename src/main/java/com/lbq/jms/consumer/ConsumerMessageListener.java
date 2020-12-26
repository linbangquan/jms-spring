package com.lbq.jms.consumer;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
//		TextMessage textMessage = (TextMessage) message;
//		try {
//			System.out.println("接收消息：" + textMessage.getText());
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
		
		MapMessage mapMessage = (MapMessage) message;
		try {
			
			String action = mapMessage.getString("action");
			System.out.println("action:"+action);
			System.out.println("接收消息：" +  mapMessage.toString());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
