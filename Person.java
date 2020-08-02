package com.company;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {

    private String fname;
    private String lname;

    //reine zum Testen der Vererbung
    public Person(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
