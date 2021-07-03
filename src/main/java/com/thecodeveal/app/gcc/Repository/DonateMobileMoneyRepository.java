package com.thecodeveal.app.gcc.Repository;

import com.thecodeveal.app.gcc.Models.ContactUs;
import com.thecodeveal.app.gcc.Models.DonateMobileMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateMobileMoneyRepository extends JpaRepository<DonateMobileMoney, Long> {

}
