package com.company;

public class DateTest {

    public static void main(String[] args){

        Date d1 = new Date(15, 30);
        Date d2 = new Date();
        Date d3 = new Date(16, 1, 2020, 12, 30);

        //falsche Konstruktion eines Objektes mit Aufruf
        Date d4 = new Date(31, 4, 2020, 12, 30);
        d4.display();
        System.out.println();
        System.out.println();

        d1.display();
        System.out.println();
        System.out.println();
        d2.display();
        System.out.println();
        System.out.println();
        d3.display();
        System.out.println();
        System.out.println();

        //Test für Tage in ungeraden Monaten
        d3.setDay(33);
        //d3.display();
        System.out.println();

        //Test für Tage in geraden Monaten
        d3.setDay(31);
        d3.setMonth(4);
        //d3.display();
        System.out.println();

        //Test für Tage im Februar
        d3.setDay(30);
        d3.setMonth(2);
        //d3.display();
        System.out.println();

        //Test für 0 Tage
        d3.setDay(0);
        d3.setMonth(2);
        d3.display();
        System.out.println();
        System.out.println();

        //Test setDate()
        d3.setDate(1,2,3, 13, 30);
        //d3.setH(12);
        //d3.setMin(30);
        d3.display();
        System.out.println();
        System.out.println();

    }

}
