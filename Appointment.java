package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    //private static int meetingNumber = 0;
    private int day;
    private int month;
    private int year;
    private int hour;
    private int min;

    private Date date;
    //private Stylist stylist;
    //private Client client;

    private int time;
    private double price;

    private int stylistID;
    private int clientID;
    private Stylist stylist;
    private Client client;

    private String[] services;

    //sofortiger Termin
    public Appointment(int stylistID, int clientID, String... s) {

        Date d1 = new Date();
        this.day = d1.getDay();
        this.month = d1.getMonth();
        this.year = d1.getYear();
        this.hour = d1.getH();
        this.min = d1.getMin();

        Date d2 = new Date(this.day, this.month, this.year, this.hour, this.min);
        this.date = d2;

        this.stylistID = stylistID -1;
        this.clientID = clientID -1;
        PersonData pdb = new PersonData(10, 100);

        pdb.loadingAccounts("Konten.dat");
        //pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        //pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);

        this.client = pdb.getClient(clientID-1);
        this.stylist = pdb.getStylist(stylistID-1);
        //this.client = Client.definedClient(kNr);
        //this.stylist = Stylist.employee(coNr);

        this.time = Service.sumDuration(Service.stringsInArray(s));
        this.price = Service.sumPrice(Service.stringsInArray(s));

        this.services = Service.stringsInArray(s);
        //meetingnumber++;
    }

    //Termin am selben Tag mit gewünschter Uhrzeit
    public Appointment(int h,int min,int stylistID, int clientID, String... s) {

        Date d1 = new Date();
        this.day = d1.getDay();
        this.month = d1.getMonth();
        this.year = d1.getYear();
        this.hour = h;
        this.min = min;

        Date d2 = new Date(this.day, this.month, this.year, this.hour, this.min);
        this.date = d2;

        this.stylistID = stylistID-1;
        this.clientID = clientID-1;
        PersonData pdb = new PersonData(10, 100);

        pdb.loadingAccounts("Konten.dat");
        //pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        //pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);

        this.client = pdb.getClient(clientID-1);
        this.stylist = pdb.getStylist(stylistID-1);
        //this.client = Client.definedClient(kNr);
        //this.stylist = Stylist.employee(coNr);

        this.time = Service.sumDuration(Service.stringsInArray(s));
        this.price = Service.sumPrice(Service.stringsInArray(s));

        this.services = Service.stringsInArray(s);

        //meetingNumber++;
    }

    //Termin an einem gewünschten Datum und Uhrzeit
    public Appointment(int day, int month, int year, int h,int min, int stylistID, int clientID, String... s) {

        Date d1 = new Date();
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = h;
        this.min = min;

        Date d2 = new Date(this.day, this.month, this.year, this.hour, this.min);
        this.date = d2;

        this.stylistID = stylistID-1;
        this.clientID = clientID-1;
        PersonData pdb = new PersonData(10, 100);

        pdb.loadingAccounts("Konten.dat");
        //pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        //pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);

        this.client = pdb.getClient(clientID-1);
        this.stylist = pdb.getStylist(stylistID-1);
        //this.client = Client.definedClient(kNr);
        //this.stylist = Stylist.employee(coNr);

        this.time = Service.sumDuration(Service.stringsInArray(s));
        this.price = Service.sumPrice(Service.stringsInArray(s));

        this.services = Service.stringsInArray(s);

        //meetingNumber++;
    }


    public void display(){
        Date d = date;
        d.display();
        System.out.println();

        System.out.println("Duration: "+this.getTime()+" min");
        System.out.println("Price: "+this.getPrice()+"0 Euros");

        System.out.print("Services: ");
        for(int i = 0; i < services.length; i++){
            System.out.print(services[i]);
            if(i < (services.length-1)) System.out.print(", ");
            if(i == (services.length-1)) System.out.println(".");
        }

        System.out.println();

        PersonData pdb = new PersonData(10, 100);
        //pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        //pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);
        //pdb.display();
        pdb.loadingAccounts("Konten.dat");
        pdb.display1S(this.stylistID);
        pdb.display1C(this.clientID);

        //client.display();
        //stylist.display();

        //client.shortDisplay();
        //System.out.println();
        //stylist.shortDisplay();
        //System.out.println();


        System.out.println();



    }




    //Probierecke
    //try and error - like

    //für ein Array mit unbekannter ANzahl an elementen
    //stattdessen mit DB System?
    /*public static String[] stringsInArray(String... s){
        return s;
    }

     */
    /*
    //Funktion logische sinvoll?
    public void dispose(){
        meetingNumber--;
    }

    public static int getMeetingNumber() {
        return meetingNumber;
    }

    public static void setMeetingNumber(int meetingNumber) {
        Appointment.meetingNumber = meetingNumber;
    }

     */

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public Date getDate() {
        return date;
    }
/*
    public Stylist getStylist() {
        return stylist;
    }

    public Client getClient() {
        return client;
    }
 */
    public int getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStylistID() {
        return stylistID;
    }

    public int getClientID() {
        return clientID;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public Client getClient() {
        return client;
    }

    public String[] getServices() {
        return services;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setDate(Date date) {
        this.date = date;
    }
/*
    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    public void setClient(Client client) {
        this.client = client;
    }
*/

    public void setTime(int time) {
        this.time = time;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setServices(String[] services) {
        this.services = services;
    }
}
