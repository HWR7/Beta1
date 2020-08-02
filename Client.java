package com.company;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Client extends Person implements Serializable {

    //private int kNr;
    private long phone;
    private String email;

    //Client mit Platzhalter
    public Client() {
        super(null, null);
        //this.kNr = -1;
        this.phone = -1;
        this.email = null;
    }

    public Client(String fname, String lname, String email, long phoneNr) {
        super(fname, lname);
        //this.kNr = kNr;
        this.phone = phoneNr;
        this.email = email;
    }

    //AlternativDaten
    //no in use, just for experiments
    /*
    public static Client definedClient(int kNr){

        Client client = new Client();

        switch(kNr){
            case 1:
                Client c1 = new Client("Chanti", "Mueller", "c.mueller@mail.de", 123123);
                return c1;
                //break;
            case 2:
                Client c2 = new Client("Chanta", "Mueller", "c.mueller@mail.de", 123123);
                return c2;
                //break;
            case 3:
                Client c3 = new Client("Chanto", "Mueller", "c.mueller@mail.de", 123123);
                return c3;
                //break;
            case 4:
                Client c4 = new Client("Chantu", "Mueller", "c.mueller@mail.de", 123123);
                return c4;
                //break;
            case 5:
                Client c5 = new Client("Chantö", "Mueller", "c.mueller@mail.de", 123123);
                return c5;
                //break;
            default:
                return client;
        }

    }

     */

    //verkürzte Ausgabe, da bei termin sonst zu viel ausgebeben wird / Text zu lang wird
    public void shortDisplay(){
        //System.out.println("Kundennummer: "+kNr);
        System.out.println("Name: "+getLname()+", "+getFname());
        System.out.println("Phone: "+phone+"; E-Mail: "+getEmail());
    }

    //übersichtlichere Variante
    public void display(){
        //System.out.println("Kundennummer: "+kNr);
        System.out.println("Nachname: "+ getLname());
        System.out.println("Vorname: "+ getFname());
        System.out.println("Telefonnummer: "+phone);
        System.out.println("E-Mail: "+email);
    }

    public long getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
