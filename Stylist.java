package com.company;

import org.h2.store.fs.FileChannelOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Stylist extends Person implements Serializable {

    //private int id;
    private String email;
    private long phone;
    private String[] special;

    public Stylist() {
        super(null, null);
        //this.id = -1;
        this.email = null;
        this.phone = -1;
        this.special = null;
    }

    public Stylist(String first, String last, String email, long phone, String... special) {
        super(first, last);
        //this.id = coNr;
        this.email = email;
        this.phone = phone;
        this.special = special;
    }

    public String[] getSpecial(){
        return special;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    //Test Datenbank
/*
    public static Stylist employee(int coNr) {
        Stylist stylist = new Stylist();

        switch (coNr) {
            case 1:
                Stylist c1 = new Stylist( "Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut");
                return c1;
                //break;
            case 2:
                Stylist c2 = new Stylist( "Chanta", "Mueller", "c.mueller@mail.de", 123123, "cut");
                return c2;
                //break;
            case 3:
                Stylist c3 = new Stylist( "Chanto", "Mueller", "c.mueller@mail.de", 123123, "cut");
                return c3;
                //break;
            case 4:
                Stylist c4 = new Stylist("Chantu", "Mueller", "c.mueller@mail.de", 123123, "cut");
                return c4;
                //break;
            case 5:
                Stylist c5 = new Stylist( "Chantö", "Mueller", "c.mueller@mail.de", 123123, "cut");
                return c5;
                //break;
            default:
                System.out.print("Unknown CoworkerID.");
                return stylist;
                //break;
        }

    }

 */

    //Alternate/Alternative
/*
    public static Stylist employee(int coNr) {
        //Stylist stylist = new Stylist(1, "Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut");

        String first = null;
        String last = null;
        String email = null;
        int phone = -1;
        String special = null;

        switch (coNr) {
            case 1:
                coNr = 1;
                first = "Chanti";
                last = "Mueller";
                email = "c.mueller@mail.de";
                phone = 123123;
                special = "cut";
                break;
            case 2:
                coNr = 2;
                first = "Chanto";
                last = "Mueller";
                email = "c.mueller@mail.de";
                phone = 123123;
                special = "cut";
                break;
            case 3:
                coNr = 3;
                first = "Chantu";
                last = "Mueller";
                email = "c.mueller@mail.de";
                phone = 123123;
                special = "cut";
                break;
            case 4:
                coNr = 4;
                first = "Chanta";
                last = "Mueller";
                email = "c.mueller@mail.de";
                phone = 123123;
                special = "cut";
                break;
            case 5:
                coNr = 5;
                first = "Chantel";
                last = "Mueller";
                email = "c.mueller@mail.de";
                phone = 123123;
                special = "cut";
                break;
            default:
                System.out.print("Unknown CoworkerID.");
                break;
        }
        Stylist s = new Stylist(coNr, first, last, email, phone, special);
        return s;
    }

 */

    public void shortDisplay(){
        //System.out.println("MitarbeiterID: "+id);
        System.out.println("Name: "+getLname()+", "+getFname());
        System.out.println("Phone: "+phone+"; E-Mail: "+getEmail());
        //displaySpecial();
    }

    public void display(){
        //System.out.println("MitarbeiterID: "+id);
        System.out.println("Nachname: "+ getLname());
        System.out.println("Vorname: "+ getFname());
        System.out.println("Telefonnummer: "+phone);
        System.out.println("E-Mail: "+email);
        displaySpecial();
    }

    public void displaySpecial(){
        System.out.print("Specialization: ");
        for(int i = 0; i < special.length; i++){
            System.out.print(special[i]);
            if(i < (special.length-1)) System.out.print(", ");
            if(i == (special.length-1)) System.out.print(".");
        }
    }

}







