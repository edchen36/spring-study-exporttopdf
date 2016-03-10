package study.spring.dao;

import java.util.List;

import study.spring.domain.Contact;

public interface ContactDAO {
	public void addContact(Contact contact);
	public void deleteContact(Integer id);
	public void editContact(Integer id);
	public Contact getContact(Integer id);
	public List<Contact> getAllContact();
	public List<Contact> searchByEmail(String searchStr);
	public List<Contact> searchByMobile(String searchStr);

}
