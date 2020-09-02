package com.company.MusicStore.modules;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, maker, country, full_text, prod_text, prodcoast;


    public String getProdcoast() {
        return prodcoast;
    }

    public void setCoast(String coast) {
        this.prodcoast = prodcoast;
    }

    public String getProd_text() {
        return prod_text;
    }

    public void setProd_text(String prod_text) {
        this.prod_text = prod_text;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Post() {
    }

    public Post(String name, String maker, String country, String prod_text, String prodcoast, String full_text) {
        this.name = name;
        this.maker = maker;
        this.country = country;
        this.prod_text = prod_text;
        this.prodcoast = prodcoast;
        this.full_text = full_text;
    }
}
