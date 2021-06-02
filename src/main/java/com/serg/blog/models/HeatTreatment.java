package com.serg.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// Table termo
@Entity
public class HeatTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String position, requirement, orderr,  gost, size, hrc, steel, gone;
    private int quantity;


    public HeatTreatment() {
    }

    public HeatTreatment(String position, String requirement, String orderr, String size, int quantity, String gost, String hrc, String steel, String gone) {
        this.position = position;
        this.requirement = requirement;
        this.orderr = orderr;
        this.size = size;
        this.quantity = quantity;
        this.gost = gost;
        this.hrc = hrc;
        this.steel = steel;
        this.gone = gone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getOrderr() {
        return orderr;
    }

    public void setOrderr(String orderr) {
        this.orderr = orderr;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getGost() {
        return gost;
    }

    public void setGost(String gost) {
        this.gost = gost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHrc() {
        return hrc;
    }

    public void setHrc(String hrc) {
        this.hrc = hrc;
    }

    public String getSteel() {
        return steel;
    }

    public void setSteel(String steel) {
        this.steel = steel;
    }

    public String getGone() {
        return gone;
    }

    public void setGone(String gone) {
        this.gone = gone;
    }
}
