package com.thecodeveal.app.gcc.Repository;

import com.thecodeveal.app.gcc.Models.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactUs, Long> {

}
