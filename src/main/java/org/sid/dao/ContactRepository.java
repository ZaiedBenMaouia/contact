package org.sid.dao;

import org.sid.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Long> {    //grace a spring data,on va faciliter le ORM
	@Query("select c from Contact c where c.nom like :x")                                                                        //en heritant de l'interface JPA
	public Page<Contact> chercher(@Param("x")String mc,Pageable pageable);

}
