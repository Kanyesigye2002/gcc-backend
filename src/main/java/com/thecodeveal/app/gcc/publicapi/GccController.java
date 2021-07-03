package com.thecodeveal.app.gcc.publicapi;

import com.thecodeveal.app.gcc.Models.*;
import com.thecodeveal.app.gcc.Repository.*;
import com.thecodeveal.app.gcc.dto.GalleryRequest;
import com.thecodeveal.app.gcc.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value = {"http://localhost:3000","http://localhost:3001", "https://gcc-app-ug.herokuapp.com/", "https://main.d2ia5wwug43lbw.amplifyapp.com"})
//@CrossOrigin(value = "https://gloriousch.herokuapp.com/")
@RestController
@RequestMapping("api/gcc/v1")
public class GccController {


    List<String> categories = new ArrayList<>();

    private GalleryCategoryRepository galleryCategoryRepository;

    private EventRepository eventRepository;

    private HomeRepository homeRepository;

    private SermonRepository sermonRepository;

    private ContactRepository contactRepository;

    private DonateMobileMoneyRepository donateMobileMoneyRepository;

    private DonateCreditCardRepository donateCreditCardRepository;

    @Autowired
    public GccController(GalleryCategoryRepository galleryCategoryRepository, EventRepository eventRepository, HomeRepository homeRepository, SermonRepository sermonRepository, ContactRepository contactRepository, DonateMobileMoneyRepository donateMobileMoneyRepository, DonateCreditCardRepository donateCreditCardRepository) {

        this.galleryCategoryRepository = galleryCategoryRepository;
        this.eventRepository = eventRepository;
        this.homeRepository = homeRepository;
        this.sermonRepository = sermonRepository;
        this.contactRepository = contactRepository;
        this.donateMobileMoneyRepository = donateMobileMoneyRepository;
        this.donateCreditCardRepository = donateCreditCardRepository;

        System.out.println("Input Values");

        categories.add("Church");
        categories.add("Children");
        categories.add("Choir");
        categories.add("Church Service");
        categories.add("In-reach");
        categories.add("Marrieds");
        categories.add("Out-reach");
        categories.add("Pastors");
        categories.add("Youth");
        categories.add("School");
        categories.add("Other");

        for (String s: categories) {
            GalleryCategory galleryCategory = new GalleryCategory();
            galleryCategory.setName(s);
            galleryCategory.setImages(new ArrayList<>());
            if (galleryCategoryRepository.findByCategory(s) == null) {
                galleryCategoryRepository.save(galleryCategory);
            }
        }
    }

    @GetMapping("test")
    public String work() {
        return "Working";
    }

    //Get All Event
    @GetMapping("events")
    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }

    //Get event by id
    @GetMapping("events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long eventId)
            throws ResourceNotFoundException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not Found for id: " + eventId));
        return ResponseEntity.ok().body(event);
    }

    //Get Home Data
    @GetMapping("home/{id}")
    public ResponseEntity<Home> getHomeById(@PathVariable(value = "id") Long homeId)
            throws ResourceNotFoundException {
        Home home = homeRepository.findById(homeId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not Found for id: " + homeId));
        return ResponseEntity.ok().body(home);
    }

    //Get All Sermon
    @GetMapping("sermons")
    public List<Sermon> getAllSermons() {
        return this.sermonRepository.findAll();
    }

    //Get Sermon by id
    @GetMapping("sermons/{id}")
    public ResponseEntity<Sermon> getSermonById(@PathVariable(value = "id") Long sermonId)
            throws ResourceNotFoundException {
        Sermon sermon = sermonRepository.findById(sermonId)
                .orElseThrow(() -> new ResourceNotFoundException("Sermon not Found for id: " + sermonId));
        return ResponseEntity.ok().body(sermon);
    }

    //get All Donations Mobile Money
    @GetMapping("give")
    public List<DonateMobileMoney> getAllDonateMobileMoney() {
        return this.donateMobileMoneyRepository.findAll();
    }

    //get All Donations Credit Card
    @GetMapping("givec")
    public List<DonateCreditCard> getAllDonateCreditCard() {
        return this.donateCreditCardRepository.findAll();
    }

    //get All Sent Messages
    @GetMapping("message")
    public List<ContactUs> getAllMessages() {
        return this.contactRepository.findAll();
    }

    //Get All
    @GetMapping("home")
    public List<Home> getAllHomes() {
        return this.homeRepository.findAll();
    }

    @GetMapping("gallery/categories")
    public List<String> getAllCategories() {
        return this.categories;
    }

    @GetMapping("gallery")
    public List<GalleryCategory> getAllGalleryNew() {
        return this.galleryCategoryRepository.findAll();
    }
    //Save Image

    @GetMapping("gallery/{gallery}")
    public ResponseEntity<GalleryCategory> GetByName(@PathVariable(value = "gallery") String gallery) {
        System.out.println(gallery);
        GalleryCategory galleryCategory = galleryCategoryRepository.findByCategory(gallery);
        System.out.println(galleryCategory.getImages());
        return ResponseEntity.ok(galleryCategory);
    }

}
