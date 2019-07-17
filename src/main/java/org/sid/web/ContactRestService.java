package org.sid.web;

import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.internal.xml.ReturnValueType;
import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	
	@Autowired
	ContactRepository contactRepository;
	
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getAllContact(){
		return contactRepository.findAll();
	}
	
	@RequestMapping(value="/contact/{id}",method=RequestMethod.GET)
	public Contact getContact(@PathVariable long id){
		return contactRepository.findOne(id);
	}
	
	@RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
	public Page<Contact> chercher(@RequestParam(name="mc", defaultValue="") String mc,
			                      @RequestParam(name="page", defaultValue="0")int page, 
			                      @RequestParam(name="size", defaultValue="5")int size){
		return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact addContact(@RequestBody Contact c){
		return contactRepository.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable long id){
	        contactRepository.delete(id);
	        return true;
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact update(@PathVariable long id, Contact c){
	     c.setId(id);    
		 return contactRepository.save(c);
	        
	}

}
