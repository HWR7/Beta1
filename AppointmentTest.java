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

        PersonData pdb = new PersonData(10, 100);
        pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);
        pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);

        pdb.saveAccounts("Konten.dat");

        Appointment a1 = new Appointment(1, 1,"wash", "color");
        Appointment a2 = new Appointment(13, 30, 1, 1,"wash", "color");
        Appointment a3 = new Appointment(1,2,2020, 13, 30,1,1, "wash", "color");

        //Artikel speichern
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Termin.dat"));
        out.writeObject(a1);
        out.writeObject(a2);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Termin.dat"));
        Appointment b1 = (Appointment) in.readObject();
        //Appointment b2 = (Appointment) in.readObject();
        //Appointment b3 = (Appointment) in.readObject();
        b1.display();
        //System.out.println("hi");
        //b2.display();
        in.close();

    }


}
