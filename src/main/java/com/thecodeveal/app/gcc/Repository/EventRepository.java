package com.thecodeveal.app.gcc.Repository;

import com.thecodeveal.app.gcc.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
