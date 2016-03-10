package study.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Messages")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column
	private int msgId;
	@Column
	@NotEmpty
	private String personName;
	@Column
	@NotEmpty
	@Email
	private String email;
	@Column
	@NotEmpty
	private String subject;
	@Column
	@NotEmpty
	private String text;
	
	
	public Message() {
		
	}

	public Message(String personName, String email, String subject, String text) {
		this.personName = personName;
		this.email = email;
		this.subject = subject;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", personName=" + personName
				+ ", email=" + email + ", subject=" + subject + ", text="
				+ text + "]";
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	
	

}
