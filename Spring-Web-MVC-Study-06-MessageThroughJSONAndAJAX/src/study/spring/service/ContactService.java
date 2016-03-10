package study.spring.service;

import java.util.List;

import study.spring.domain.Contact;

public interface ContactService {
	public void addContact(Contact contact);
	public void deleteContact(Integer id);
	public Contact getContact(Integer id);
	public List<Contact> getAllContacts();
//	public List<Contact> searchByMobile(String searchStr);
//	public List<Contact> serachByEmail(String searchStr);
	
	
}
