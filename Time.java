package com.company;
//creator: Dang, Duy

import java.io.Serializable;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Time implements Serializable {

    private int min;
    private int h;

    //Konstruktor
    public Time(int h, int min) {
        this.min = min;
        this.h = h;
    }

    //Konstruktor mit aktueller Uhrzeit
    public Time() {
        GregorianCalendar now = new GregorianCalendar();
        this.min = now.get(GregorianCalendar.MINUTE);
        this.h = now.get(GregorianCalendar.HOUR_OF_DAY);
    }

    //Aufruf-Funktion
    public void display(){
        if(h<0 || 23<h) {
            System.out.println("Error: Please enter a valid number for the hour(s).");
            if(min<0||59<min) System.out.print("Error: Please enter a valid number for the minute(s).");
                return;
        }
        if(min<0 || 59<min) {
            System.out.println("Error: Please enter a valid number for the minute(s).");
            return;
        }
        if(min==0) System.out.print(h+":"+min+"0");
        else System.out.print(h+":"+min);
    }

    public void setTime(int h, int min){
        this.min = min;
        this.h = h;
    }

    //getter und setter Methoden
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}


