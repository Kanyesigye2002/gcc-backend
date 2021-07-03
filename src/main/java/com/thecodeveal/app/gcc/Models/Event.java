package com.thecodeveal.app.gcc.Models;

import com.google.errorprone.annotations.Var;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "events")
@ToString
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;
    @Column(name = "host")
    private String host;
    @Column(name = "date")
    private String date;
    @Column(name = "description", columnDefinition = "TEXT", length = 1024)
    private String description;
    @Column(name = "filename")
    private String fileName;

    public Event() {

    }

    public Event(String title, String host, String date, String description, String fileName) {
        this.title = title;
        this.host = host;
        this.date = date;
        this.description = description;
        this.fileName = fileName;
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
}
