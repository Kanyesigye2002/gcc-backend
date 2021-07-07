package com.thecodeveal.app.repository;

import com.thecodeveal.app.gcc.Models.GalleryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thecodeveal.app.entities.User;


@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

//	@Query("SELECT ud from User ud")
//	GalleryCategory findAllTeam(String st);

}
