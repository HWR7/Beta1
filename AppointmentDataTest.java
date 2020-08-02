package com.company;

import java.io.*;

public class AppointmentDataTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        PersonData pdb = new PersonData(10, 100);
        pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);
        pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);
        pdb.saveAccounts("Konten.dat");

        AppointmentData adb = new AppointmentData(100);

        //funktioniert
        //adb.insertAppointment(1,2,3,15, 30, 1, 1,"wash");
        //adb.insertToday(13,15, 1, 1,"wash");

        //Test erfolgreich

        adb.insertCheckAppointment(1,2,3,15, 30, 1, 1,"wash", "dry");
        System.out.println("+1");
        adb.insertCheckAppointment(2,3,4,15, 30,1, 1, "wash", "color");
        System.out.println("+1");
        adb.insertCheckAppointment(1,2,3,15, 30, 1, 1,"wash", "wash");
        System.out.println("+1");
        adb.insertCheckAppointment(3,4,5,15, 30, 1, 1,"wash");
        System.out.println("+1");


        System.out.println("Terminplaner: ");
        adb.display();


/*      //funktioniert
        System.out.println("delete: ");
        adb.delete(1);
        adb.display();
*/
        adb.saveAppointments("Termine.dat");
        System.out.println("Test: ");

        //Test erfolgreich
        //Appointment a = new Appointment(1,2,3,15,30,1,1,"wash");
        //Appointment b = new Appointment(1,2,3,15,30,1,1,"wash");
        //System.out.println(adb.checkOverlap(a, b));

        //Test checkExpired erfolgreich
        //Appointment a = new Appointment(1,2,3,15,30,1,1,"wash");
        //System.out.println(adb.checkExpired(a));

        //Test erfolgreich
        //adb.organizeAndDeleteExpiredData();

        //funktioniert
        //adb.bubbleSort();

        //adb.display();


        System.out.println("Inhalt des Terminplaners; ");
        AppointmentData b = new AppointmentData(100);
        b.loadingAppointments("Termine.dat");
        b.display();



    }

}
