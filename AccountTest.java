package com.company;


public class AccountTest{

    public static void main (String[] args){
        PersonData db = new PersonData(10, 100);
        db.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        db.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);
        db.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        db.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);

        System.out.println();
        System.out.println("Inhalte der Datenbank db: ");
        db.display();
        //db.saveSAccounts("Konten.dat");
        //db.saveCAccounts("CKonten.dat");
        db.saveAccounts("Konten.dat");

        System.out.println("Inhalte der Datenbank c: ");
        PersonData c = new PersonData(10, 100);
        c.loadingSAccounts("Konten.dat");
        c.loadingCAccounts("CKonten.dat");
        //c.loadingAccounts("Konten.dat");
        c.display();
    }

}
