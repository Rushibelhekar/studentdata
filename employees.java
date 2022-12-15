package net.javaguides.springboot.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employeess")
public class employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

	public Object getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFirstName(Object firstName2) {
		// TODO Auto-generated method stub
		
	}

	public Object getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEmailId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLastName(Object lastName2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmailId(Object emailId2) {
		// TODO Auto-generated method stub
		
	}
}
