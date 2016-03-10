package study.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.dao.MessageDAO;
import study.spring.domain.Message;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDAO messagedao; // new MessageDAOImpl ();
	
	@Override
	public void sendMessage(Message message) {
		messagedao.sendMessage(message);

	}

	@Override
	public List<Message> getAllMessages() {
		return messagedao.getAllMessages();
	}

}
