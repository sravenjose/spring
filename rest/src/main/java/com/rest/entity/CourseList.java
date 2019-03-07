package com.rest.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="courses")
public class CourseList{

    public CourseList() {
    }

    @Id
    @Column(name="name")
    private String name;

    @Column(name="link")
    private String link;

    @Column(name="duration")
    private int duration;

    @Column(name="price")
    private int price;



    public CourseList(String name, String link, int duration, int price) {
        this.name = name;
        this.link = link;
        this.duration = duration;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}