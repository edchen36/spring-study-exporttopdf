package study.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.dao.ContactDAO;
import study.spring.domain.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO contactdao; // new ContactDAOImpl();
	
	
	@Override
	public void addContact(Contact contact) {
		contactdao.addContact(contact);

	}

	@Override
	public void deleteContact(Integer id) {
		contactdao.deleteContact(id);

	}

	@Override
	public Contact getContact(Integer id) {
		// TODO Auto-generated method stub
		return contactdao.getContact(id);
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return contactdao.getAllContact();
	}

}
