package com.thecodeveal.app.gcc.Repository;

import com.thecodeveal.app.gcc.Models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {

}
