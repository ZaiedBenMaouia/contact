package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	/*	DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		contactRepository.save(new Contact("zaied", "ben maouia",df.parse("15/01/1989"),"zaiedbenmaouia@yahoo.fr",26987765,"zaied.JPEG"));
		
		List<Contact> contact =  contactRepository.findAll();
		
		for(Contact c:contact) {
			System.out.println(c.getPrenom());
		} */
		
	}
}
