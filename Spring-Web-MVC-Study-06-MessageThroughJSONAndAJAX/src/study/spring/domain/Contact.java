package study.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import study.spring.validator.Phone;

@Entity
@Table(name="Contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int contactId;
	@Column
	@NotEmpty
	private String firstName;
	@Column
	@NotEmpty
	private String lastName;
	@Column
	//@Size(min=8, max=8, message="Mobile number must be only 8 digits")
	//@NotEmpty
	@Phone
	private String mobile;
	@Column
	@NotEmpty
	@Email(message="Invalid Email")
	private String email;
	@Column
	@NotEmpty
	private String gender;
	
	public Contact() {
		
	}

	public Contact(String firstName, String lastName, String mobile,
			String email, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobile=" + mobile + ", email="
				+ email + ", gender=" + gender + "]";
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
