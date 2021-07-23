package com.thecodeveal.app.gcc.admin;

import com.thecodeveal.app.gcc.Models.*;
import com.thecodeveal.app.gcc.Repository.*;
import com.thecodeveal.app.gcc.dto.GalleryRequest;
import com.thecodeveal.app.gcc.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

class SayHello extends TimerTask {
    public void run() {
        System.out.println("Up n Running!");
        try {
            URL url = new URL("https://gcc-app-ug.herokuapp.com/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            URL url = new URL("https://gcc-backend.herokuapp.com/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

@CrossOrigin(value = {"http://localhost:3000","https://master.d1zaj6z68k0ehd.amplifyapp.com", "https://gcc-app-ug.herokuapp.com/", "https://main.d2ia5wwug43lbw.amplifyapp.com"})
//@CrossOrigin(value = "https://gloriousch.herokuapp.com/")
@RestController
@RequestMapping("api/gcc/admin/v1/")
public class RootController {


    @Bean
    public void keeprunning() {
        Timer timer = new Timer();
        timer.schedule(new SayHello(), 0, 1000000);
    }

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private GalleryRepository galleryRepository;


    @Autowired
    private ImagesRepository imageRepository;

    @Autowired
    private SermonRepository sermonRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private DonateMobileMoneyRepository donateMobileMoneyRepository;

    @Autowired
    private DonateCreditCardRepository donateCreditCardRepository;

    @Autowired
    private GalleryCategoryRepository galleryCategoryRepository;

    @GetMapping
    public String work() {
        return "Admin Welcome to gcc-api";
    }

    //Save event
    @PostMapping("events")
    public Event createEvent(@RequestBody Event event, Object obj) {
        System.out.println(obj);
        System.out.println(event);
        return this.eventRepository.save(event);
    }

    @PostMapping("eventd")
    public String trys(@RequestBody Object obj) {
        System.out.println(obj);
        return "Sus";
    }

    //Update Event
    @PutMapping("events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long eventId,
                                             @Valid @RequestBody Event events)
            throws ResourceNotFoundException {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not Found for id: " + eventId));

        event.setTitle(events.getTitle());
        event.setHost(events.getHost());
        event.setDescription(events.getDescription());
        event.setDate(events.getDate());

        return ResponseEntity.ok(this.eventRepository.save(event));
    }

    //Delete Event
    @DeleteMapping("events/{id}")
    public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") Long eventId)
            throws ResourceNotFoundException {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not Found for id: " + eventId));

        this.eventRepository.delete(event);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    //Save event
    @PostMapping("home")
    public Home createHome(@RequestBody Home home) {
        return this.homeRepository.save(home);
    }


    //Update Home Data
    @PutMapping("home/{id}")
    public Home updateHome(@PathVariable(value = "id") Long homeId,
                           @Valid @RequestBody Home home) {

        return this.homeRepository.save(home);

    }

    @PostMapping("gallery")
    public GalleryCategory uploadedImages(@RequestBody GalleryRequest galleryRequest) {
        GalleryCategory galleryCategoryNew = galleryRequest.getGalleryCategory();
        GalleryCategory galleryCategory = galleryCategoryRepository.findByCategory(galleryCategoryNew.getName());
        System.out.println("\n\n\n" + galleryRequest.toString());
        System.out.println("New Request:  " + galleryCategoryNew.toString());
        System.out.println("Older Request:  " + galleryCategoryNew.toString());
        System.out.println("Allllll Lit: -----------> " + this.galleryCategoryRepository.findAll());
        if (galleryCategory == null) {
            System.out.println("new:" + galleryCategoryNew.toString());
            return this.galleryCategoryRepository.save(galleryRequest.getGalleryCategory());
        } else {
            System.out.println("exits:" + galleryCategory);
            galleryCategory.setName(galleryCategoryNew.getName());
            galleryCategory.getImages().addAll(galleryCategoryNew.getImages());
            return this.galleryCategoryRepository.save(galleryCategory);
        }
    }

    //Update Image
    @PutMapping("gallery/{gallery}")
    public ResponseEntity<GalleryCategory> updatePhoto (@PathVariable(value = "gallery") String gallery,
                                                        @RequestBody GalleryRequest galleryRequest) {
        GalleryCategory galleryCategoryNew = galleryRequest.getGalleryCategory();
        GalleryCategory galleryCategory = galleryCategoryRepository.findByCategory(gallery);

        System.out.println(galleryCategory);

        if (galleryCategory != null) {
            System.out.println("exists:" + gallery);
            galleryCategory.setName(galleryCategoryNew.getName());
            galleryCategory.getImages().addAll(galleryCategoryNew.getImages());
            return ResponseEntity.ok(this.galleryCategoryRepository.save(galleryCategory));
        } else {
            System.out.println("new:" + gallery);
            return ResponseEntity.ok(this.galleryCategoryRepository.save(galleryCategoryNew));
        }

    }


    //Delete Image
    @DeleteMapping("gallery/{id}")
    public Map<String, Boolean> deleteImage(@PathVariable(value = "id") Long imageID)
            throws ResourceNotFoundException {

        Images image = imageRepository.findById(imageID)
                .orElseThrow(() -> new ResourceNotFoundException("Event not Found for id: " + imageID));

        this.imageRepository.delete(image);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted" + image.getImage(), Boolean.TRUE);

        return response;
    }

    //Save Sermon
    @PostMapping("sermons")
    public Sermon createSermon(@RequestBody Sermon sermon) {
        return this.sermonRepository.save(sermon);
    }

    //Update sermon
    @PutMapping("Sermons/{id}")
    public ResponseEntity<Sermon> updateSermon(@PathVariable(value = "id") Long sermonId,
                                               @Valid @RequestBody Sermon sermons)
            throws ResourceNotFoundException {

        Sermon sermon = sermonRepository.findById(sermonId)
                .orElseThrow(() -> new ResourceNotFoundException("Sermon not Found for id: " + sermonId));

        sermon.setTitle(sermons.getTitle());
        sermon.setHost(sermons.getHost());
        sermon.setDescription(sermons.getDescription());
        sermon.setDate(sermons.getDate());
        sermon.setScripture(sermons.getScripture());

        return ResponseEntity.ok(this.sermonRepository.save(sermon));
    }

    //Delete Sermon
    @DeleteMapping("sermons/{id}")
    public Map<String, Boolean> deleteSermon(@PathVariable(value = "id") Long sermonId)
            throws ResourceNotFoundException {

        Sermon sermon = sermonRepository.findById(sermonId)
                .orElseThrow(() -> new ResourceNotFoundException("sermon not Found for id: " + sermonId));

        this.sermonRepository.delete(sermon);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    //Save New Message
    @PostMapping("message")
    public ContactUs createMessage(@RequestBody ContactUs message) {
        return this.contactRepository.save(message);
    }

    //Save New Donations Mobile Money
    @PostMapping("give")
    public DonateMobileMoney createDonateM(@RequestBody DonateMobileMoney donateMobileMoney) {
        return this.donateMobileMoneyRepository.save(donateMobileMoney);
    }

    //Save New Donations Credit Card
    @PostMapping("givec")
    public DonateCreditCard createDonateCreditCard(@RequestBody DonateCreditCard donateCreditCard) {
        return this.donateCreditCardRepository.save(donateCreditCard);
    }
}
