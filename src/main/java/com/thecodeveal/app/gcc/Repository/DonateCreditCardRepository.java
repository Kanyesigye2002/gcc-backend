package com.thecodeveal.app.gcc.Repository;

import com.thecodeveal.app.gcc.Models.ContactUs;
import com.thecodeveal.app.gcc.Models.DonateCreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateCreditCardRepository extends JpaRepository<DonateCreditCard, Long> {

}
