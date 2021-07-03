package com.thecodeveal.app.gcc.Models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "home")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "next_service")
    private String nextService;
    @Column(name = "latest_Video")
    private String latestVideo;
    @Column(name = "image1")
    private String image1;
    @Column(name = "image2")
    private String image2;
    @Column(name = "image3")
    private String image3;

    public Home() {

    }

    public Home(String nextService, String latestVideo, String image1, String image2, String image3) {
        this.nextService = nextService;
        this.latestVideo = latestVideo;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }

    public String getLatestVideo() {
        return latestVideo;
    }

    public void setLatestVideo(String latestVideo) {
        this.latestVideo = latestVideo;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Objects.equals(id, home.id) &&
                Objects.equals(nextService, home.nextService) &&
                Objects.equals(latestVideo, home.latestVideo) &&
                Objects.equals(image1, home.image1) &&
                Objects.equals(image2, home.image2) &&
                Objects.equals(image3, home.image3);
    }

    public boolean equalsId(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Objects.equals(id, home.id);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, nextService, latestVideo, image1, image2, image3);
    }
}
