package com.company;

import java.io.*;

public class AppointmentTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*
        Appointment a1 = new Appointment(15, 30, "wash", "cut");
        a1.display();
        Appointment a2 = new Appointment(1, 2, "wash");
        //a2.display();

 */
        Appointment a1 = new Appointment(13, 30, 1, 1,"wash", "color");
        Appointment a2 = new Appointment(1,2,2020, 13, 30,1,2, "wash", "color");

        //Artikel speichern
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("termin.dat"));
        out.writeObject(a1);
        out.writeObject(a2);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("termin.dat"));
        Appointment b1 = (Appointment) in.readObject();
        Appointment b2 = (Appointment) in.readObject();
        b1.display();
        b2.display();
        in.close();

    }


}
