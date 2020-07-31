package com.company;
//creator: Dang, Duy

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Date extends Time implements Serializable {

    private int day;
    private int month;
    private int year;

    //Konstruktoren
    public Date(int day, int month, int year, int h, int min){
        super(h, min);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //mit aktuellem Datum und individueller Zeit
    public Date(int h, int min){
        super( h,  min);
        GregorianCalendar now = new GregorianCalendar();
        this.day = now.get(Calendar.DATE);
        this.month = now.get(Calendar.MONTH)+1;
        this.year = now.get(Calendar.YEAR);

    }

    //mit aktuellem Datum und Zeit
    public Date() {
        super();
        GregorianCalendar now = new GregorianCalendar();
        this.day = now.get(Calendar.DATE);
        this.month = now.get(Calendar.MONTH) + 1;
        this.year = now.get(Calendar.YEAR);
    }

    //display mit einheitlicher Ausgabe vom Datum (mit 0 vorne, bei Einstelligkeit)
    public void display(){
        if (checkDay(day) == true);
        if (checkMonth(month) == true);
        else if (day<10 && month<10) System.out.print("0"+day+"/0"+month+"/"+year+" | "+getH()+":"+getMin());
        else if (day<10) System.out.print("0"+day+"/"+month+"/"+year+" | "+getH()+":"+getMin());
        else if (month<10) System.out.print(day+"/0"+month+"/"+year+" | "+getH()+":"+getMin());
        else System.out.print(day+"/"+month+"/"+year+" | "+getH()+":"+getMin());
    }

    //Überprüfung von validen Datumseingaben mit Bezug auf Monaten
    private boolean checkDay(int d){
        boolean failD = false;
        if (d<1) {
            System.out.println("invalid day-value, lower then 0");
            failD = true;
        }
        else if (month == 2 && d != 28) {
            System.out.println("invalid day-value, for Feb");
            failD = true;
        }
        else if (30>d && d>30 && month%2 == 1) {
            System.out.println("invalid day-value, in a odd month (31d)");
            failD = true;
        }
        else if ( 31>d && d>31 && month%2 == 0) {
            System.out.println("invalid day-value, in a straight month (30d)");
            failD = true;
        }

        return failD;
    }

    //Überprüfung von validen Monatsangaben mit Bezug auf Tagesangabe
    private boolean checkMonth(int m){
        boolean failM = false;
        if(m<1) {
            System.out.println("invalid month-value, lower then 1");
            failM = true;
        }
        if(m>12) {
            System.out.println("invalid month-value, higher then 12");
            failM = true;
        }
        if (m%2 == 0 && day>30){
            System.out.println("day value doesn't match to the month, please change day-value");
            failM = true;
        }
        if (m%2 == 1 && day>31){
            System.out.println("day value doesn't match to the month, please change day-value");
            failM = true;
        }
        if (m%2 == 1 && day>31){
            System.out.println("day value doesn't match to the month, please change day-value");
            failM = true;
        }
        if (m == 2 && day>28){
            System.out.println("day value doesn't match to the February, please change day-value");
            failM = true;
        }

        return failM;
    }



    public void setDate(int day, int month, int year, int h, int min) {
        this.setTime(h, min);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(checkDay(day) == true) ;
        else this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (checkMonth(month)) ;
        else this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
