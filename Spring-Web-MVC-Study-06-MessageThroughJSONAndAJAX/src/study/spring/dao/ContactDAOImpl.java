package study.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import study.spring.domain.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addContact(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.save(contact);

	}

	@Transactional
	public void deleteContact(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Contact contact = (Contact)session.load(Contact.class, id);
		if(contact != null) {
			System.out.println("Contact " + contact.getContactId()+" "+contact.getFirstName());
			session.delete(contact);
			System.out.println("Deleted");
		}

	}

	@Override
	public void editContact(Integer id) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public Contact getContact(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Contact contact = (Contact)session.get(Contact.class, id);
		
		return contact;
	}

	@Transactional
	public List<Contact> getAllContact() {
		Session session = sessionFactory.getCurrentSession();
		List<Contact> contactList = null;
		try {
			contactList = session.createQuery("from Contact").list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return contactList;
	}

	@Transactional
	public List<Contact> searchByEmail(String searchStr) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Contact.class);
		crit.add(Restrictions.like("email", "%"+searchStr+"%"));
		List<Contact> contactlist = crit.list();
		return contactlist;
	}

	@Transactional
	public List<Contact> searchByMobile(String searchStr) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Contact.class);
		crit.add(Restrictions.like("mobile", "%"+searchStr+"%"));
		List<Contact> contactlist = crit.list();
		return contactlist;
		
	}

}
