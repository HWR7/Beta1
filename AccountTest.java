package com.company;


public class AccountTest{

    public static void main (String[] args){
        PersonData pdb = new PersonData(10, 100);
        pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);
        pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
        pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);

        System.out.println();
        System.out.println("Inhalte der Datenbank db: ");
        pdb.display();
        //db.saveSAccounts("Konten.dat");
        //db.saveCAccounts("CKonten.dat");
        pdb.saveAccounts("Konten.dat");

        System.out.println("Inhalte der Datenbank c: ");
        PersonData c = new PersonData(10, 100);
        c.loadingSAccounts("Konten.dat");
        c.loadingCAccounts("CKonten.dat");
        //c.loadingAccounts("Konten.dat");
        c.display();
    }

}
