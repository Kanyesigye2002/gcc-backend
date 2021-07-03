package com.thecodeveal.app.gcc.Models;

import javax.persistence.*;

@Entity
@Table(name = "sermons")
public class Sermon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;
    @Column(name = "host")
    private String host;
    @Column(name = "date")
    private String date;
    @Column(name = "description")
    private String description;
    @Column(name = "filename")
    private String fileName;
    @Column(name = "scripture")
    private String scripture;

    public Sermon() {

    }

    public Sermon(String title, String host, String date, String description, String fileName, String scripture) {
        this.title = title;
        this.host = host;
        this.date = date;
        this.description = description;
        this.fileName = fileName;
        this.scripture = scripture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getScripture() {
        return scripture;
    }

    public void setScripture(String scripture) {
        this.scripture = scripture;
    }
}
