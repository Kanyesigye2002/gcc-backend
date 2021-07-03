package com.thecodeveal.app.gcc.Repository;


import com.thecodeveal.app.gcc.Models.GalleryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GalleryCategoryRepository extends JpaRepository<GalleryCategory, Long> {

    @Query("SELECT ud from gallerycategory ud where ud.name =?1")
    GalleryCategory findByCategory(String st);

}
