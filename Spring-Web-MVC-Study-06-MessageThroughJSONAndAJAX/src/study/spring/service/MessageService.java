package study.spring.service;

import java.util.List;

import study.spring.domain.Message;

public interface MessageService {
	
	public void sendMessage(Message message);
	public List<Message> getAllMessages();

}
