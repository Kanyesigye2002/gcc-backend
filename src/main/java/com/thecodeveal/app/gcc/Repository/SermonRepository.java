package com.thecodeveal.app.gcc.Repository;

import com.thecodeveal.app.gcc.Models.Sermon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SermonRepository extends JpaRepository<Sermon, Long> {

}
