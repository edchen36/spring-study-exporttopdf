package study.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import study.spring.domain.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void sendMessage(Message message) {
		Session session = sessionFactory.getCurrentSession();
		session.save(message);
		System.out.println("Added Message "+message.toString());

	}

	@Override
	@Transactional
	public List<Message> getAllMessages() {
		Session session = sessionFactory.getCurrentSession();
		List<Message> messages = null;
		try {
			messages=(List<Message>)session.createQuery("from Message").list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return messages;
	}

}
