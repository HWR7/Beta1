package com.company;

public class TimeTest {

    public static void main(String[] args){
        //Testklasse

        //Erstellung von Testobjekten
        Time t1 = new Time();
        t1.display();

        System.out.println();
        Time t2 = new Time(16, 30);
        t2.display();

        //Test von unzulässigen Zahlen (Zahlenbereich)
        System.out.println();
        Time t3 = new Time(24, 60);
        t3.display();

        //Test der set Methode und der 00 Minuten Angabe
        System.out.println();
        t2.setH(17);
        t2.setMin(00);
        t2.display();

        System.out.println();
        t3.setH(23);
        t3.setMin(60);
        t3.display();


    }
}
