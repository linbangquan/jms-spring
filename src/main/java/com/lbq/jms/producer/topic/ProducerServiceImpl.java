package com.lbq.jms.producer.topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.lbq.jms.producer.ProducerService;


public class ProducerServiceImpl implements ProducerService {
	
	@Autowired
	JmsTemplate jmsTemplate;

	@Resource(name="topicDestination")
	Destination destination;
	
	public void sendMessage(String message) {
		//使用JmsTemplate发送消息
		jmsTemplate.send(destination, new MessageCreator() {
			//创建一个消息
			@Override
			public Message createMessage(Session session) throws JMSException {
				//TextMessage textMessage = session.createTextMessage(message);
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setString("action", "updateStaff");
				mapMessage.setString("id","0df70ddf-0dbb-4679-9888-811a6a7e0a8b");
				mapMessage.setString("emplName","张森");
				mapMessage.setString("emplId","200000067");
				mapMessage.setString("uid","2b871fcf-2f74-4d61-9524-36e643c5920d");
				mapMessage.setString("businessUnit","CMFT");
				mapMessage.setString("birthdate","1991-01-28");
				mapMessage.setString("sex","M");
				mapMessage.setString("businessName","招商局金融科技有限公司");
				mapMessage.setString("enteringTime","2017-07-12");
				mapMessage.setString("workingTime","2013-07-04");
				List<Map<String,String>> staffPositionList = new ArrayList<>();
				Map<String,String> staffPosition = new HashMap<>();
				staffPosition.put("parentOrganizeNo","1000116");
				staffPosition.put("quartersDesc","招商金科研发支持平台部系统开发工程师");
				staffPosition.put("businessUnit","CMFT");
				staffPosition.put("organizeType","D");
				staffPosition.put("quartersCode","10019064");
				staffPosition.put("organizeName","研发支持平台部");
				staffPosition.put("businessName","招商局金融科技有限公司");
				staffPosition.put("organizeNo","1000117");
				staffPositionList.add(staffPosition);				
				mapMessage.setObject("staffPositionList", staffPositionList);
				
				Map<String,String> staffPropVal = new HashMap<>();
				staffPropVal.put("MOBILE_PHONE","13227049999");
				staffPropVal.put("STATUS","03");
				staffPropVal.put("PS_ID","10027822");
				staffPropVal.put("EMAIL","zhangs002@cmft.com");
				staffPropVal.put("DEPARTURE_TIME","2019-05-12");
				mapMessage.setObject("staffPropVal", staffPropVal);
				
				List<Map<String,String>> accountList = new ArrayList<>();
				Map<String,String> account = new HashMap<>();
				account.put("accountId","zhangs002");
				account.put("uid","2b871fcf-2f74-4d61-9524-36e643c5920d");
				account.put("userType","INNER");
				account.put("type","DOMAIN");
				accountList.add(account);
				mapMessage.setObject("accountList", accountList);
				
				return mapMessage;
			}
			
		});
		System.out.println("发送消息：" + message);
	}

}
