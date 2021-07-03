package com.thecodeveal.app.gcc.Repository;

import com.thecodeveal.app.gcc.Models.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

}
