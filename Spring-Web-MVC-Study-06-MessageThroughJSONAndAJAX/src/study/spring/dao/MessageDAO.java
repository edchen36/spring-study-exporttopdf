package study.spring.dao;

import java.util.List;

import study.spring.domain.Message;

public interface MessageDAO {
	public void sendMessage(Message message);
	public List<Message> getAllMessages();

}
