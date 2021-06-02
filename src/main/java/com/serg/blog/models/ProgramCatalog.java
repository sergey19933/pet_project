package com.serg.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// Table prog
@Entity
public class ProgramCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number, nameProgram;

    public ProgramCatalog() {
    }

    public ProgramCatalog(String number, String nameProgram) {
        this.number = number;
        this.nameProgram = nameProgram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }
}
