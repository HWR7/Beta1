package com.company;

import java.io.*;

public class AppointmentDataTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {


        AppointmentData adb = new AppointmentData(100);
        //Appointment a1 = new Appointment(1, 2, "wash");

        //adb.insertAppointment(1,2,3,15, 30, 1, 1, "wash");
        //adb.insertAppointment(2,3,4,15, 30, 1, 1,"wash");
        //adb.insertAppointment(1,2,3,15, 30, 1, 1,"wash");
        adb.insertToday(13,15, 1, 1,"wash");
/*
        adb.insertCheck(1,2,3,15, 30, "wash");
        adb.insertCheck(2,3,4,15, 30, "wash");
        adb.insertCheck(1,2,3,15, 30, "wash");
        adb.insertCheck(3,4,5,15, 30, "wash");
 */

        System.out.println("Terminplaner: ");
        adb.display();

        adb.delete(1);
        adb.display();

        adb.saveAppointments("Termine.dat");
        adb.bubbleSort("Termine.dat");
        adb.display();

        /*
        System.out.println("Inhalt des Terminplaners; ");
        AppointmentData b = new AppointmentData(100);
        b.loadingAppointments("termin.dat");
        b.display();

         */

    }

}
