package com.company;

import java.util.*;
import java.lang.String;

public class Main {

    public static int menu = 0;
    private static PersonData pdb;
    private static AppointmentData adb;

    public static void main(String[] args) {
	// write your code here
        //boolean listeda= false

/*
        System.out.println("Geben Sie Ihre gewünschte Maximalmenge an Stylisten und Klienten an. (1.Stylist; 2.Klient)");
        Scanner in1 = new Scanner(System.in);
        int z1 = in1.nextInt();
        int z2 = in1.nextInt();
        pdb = new PersonData(z1, z2);
        //pdb.saveAccounts("Konten.dat");
        System.out.println("Ihre Datensätze können bis zu "+z1+" Stylisten und "+z2+" Klienten enthalten.");
        System.out.println();

        System.out.println("Geben Sie Ihre gewünschte Maximalmenge an Terminen an. (abhängig von ihren Speicherkapazitäten)");
        Scanner in2 = new Scanner(System.in);
        int z3 = in2.nextInt();
        adb = new AppointmentData(z3);
        //adb.saveAppointments("Termine.dat");
        System.out.println("Ihre Datensätze können bis zu "+z3+" Einträge enthalten.");
        System.out.println();

 */

        pdb = new PersonData(10, 100);
        pdb.loadingAccounts("Konten.dat");
        adb = new AppointmentData(1000);
        adb.loadingAppointments("Termine.dat");

        while(menu != 99){
            Menu();
        }


        //System.exit(0);
    }


    public static int Menu(){ //Menü mit Auswahlmöglichkeiten

        int menu = 0;

        System.out.println();
        System.out.println();
        System.out.println("Terminplaner (gewünschte Option per Zahl auswaehlen)");
        //System.out.println();
        System.out.println("[1]  Terminliste speichern");
        System.out.println("[2]  Terminliste anzeigen");

        System.out.println("[3]  Stylisten- und Klientenliste speichern");
        System.out.println("[4]  Nur die Klientenliste speichern");
        System.out.println("[5]  Nur die Stylistenliste speichern");

        System.out.println("[6]  Termine aus dem Speicher laden und anzeigen (Nicht gespeicherte Daten können verloren gehen)");
        System.out.println("[7]  Alle Konten (Stylisten + Kunden) aus dem Speicher laden und anzeigen (Nicht gespeicherte Daten können verloren gehen)");
        System.out.println("[8]  Nur die Klientenliste aus dem Speicher laden und anzeigen (Nicht gespeicherte Daten können verloren gehen)");
        System.out.println("[9]  Nur die Stylistenliste aus dem Speicher laden und anzeigen (Nicht gespeicherte Daten können verloren gehen)");

        System.out.println("[10] Termin eintragen und anzeigen ");
        System.out.println("[101]Termin für heute eintragen und anzeigen lassen");
        System.out.println("[11] Stylisten eintragen und anzeigen ");
        System.out.println("[12] Klienten eintragen und anzeigen");

        System.out.println("[13] Termin löschen");
        System.out.println("[14] Stylisten-Konto löschen");
        System.out.println("[15] Klienten-Konto löschen");

        System.out.println("[16] Datenliste sortieren und abgelaufene Datensätze/Termine aus der Liste entfernen");
        System.out.println("[17] Stylisten anzeigen ");
        System.out.println("[18] Klienten anzeigen ");
        System.out.println("[19] Alle Personen anzeigen ");

        System.out.println("[20] Alle Termine sortieren ");

        System.out.println("[99] Programm beenden");

        Scanner in = new Scanner(System.in);

        switch(in.nextInt()) {
            case 1:
                System.out.println();
                System.out.println("[1] Terminliste speichern:");
                adb.saveAppointments("Termine.dat");
                menu = 1;
                //Menu();
                return menu;
                //break;
            case 2:
                System.out.println();
                System.out.println("[2] Terminliste auslesen lassen: ");
                adb.display();
                menu = 2;
                //Menu();
                return menu;
                //break;
            case 3:
                System.out.println();
                System.out.println("[3] Stylisten- und Klientenliste speichern: ");
                pdb.saveAccounts("Konten.dat");
                menu = 3;
                //Menu();
                return menu;
                //break;
            case 4:
                System.out.println();
                System.out.println("[4] Nur die Klientenliste speichern: ");
                pdb.saveCAccounts("CKonten.dat");
                menu = 4;
                //Menu();
                return menu;
                //break;
            case 5:
                System.out.println();
                System.out.println("[5] Nur die Stylistenliste speichern: ");
                pdb.saveSAccounts("SKonten.dat");
                menu = 5;
                return menu;
            case 6:
                System.out.println();
                System.out.println("[6] Termine aus dem Speicher laden und anzeigen: ");
                pdb.loadingAccounts("Konten.dat");
                pdb.display();
                menu = 6;
                return menu;
            case 7:
                System.out.println();
                System.out.println("[7] Alle Konten (Stylist + Kunden) aus dem Speicher laden: ");
                pdb.loadingAccounts("Konten.dat");
                pdb.display();
                menu = 7;
                return menu;
            case 8:
                System.out.println();
                System.out.println("[8] Nur die Klientenliste aus dem Speicher laden: ");
                pdb.loadingCAccounts("CKonten.dat");
                pdb.display();
                menu = 8;
                return menu;
            case 9:
                System.out.println();
                System.out.println("[9] Nur die Stylistenliste aus dem Speicher laden: ");
                pdb.loadingSAccounts("SKonten.dat");
                pdb.display();
                menu = 9;
                return menu;
            case 10:
                System.out.println();
                System.out.println("[10] Termin eintragen und anzeigen ");
                System.out.println();
                System.out.println("Hier sehen Sie unsere Stylisten. Suchen Sie die StylistenID ihres Stylisten und fügen Sie diese ein: ");
                System.out.println();
                pdb.displayStylists();
                int f = in.nextInt();

                System.out.println("Geben Sie ihren gewünschten Termin an. (day, month, year, hour, min, Kundennummer, service(s))");
                //Scanner in = new Scanner(System.in);
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();

                int d = in.nextInt();
                int e = in.nextInt();

                int g;
                try{
                     g = in.nextInt();
                }catch (Exception e1){
                    System.out.println("Bitte geben Sie eine Telefonnummer ohne Buchstaben ein!");
                     g = in.nextInt();
                }


                //String[] s = new String[3];
                //s = h.split(",",0);
                //for(String kp : s) System.out.println(kp);

                //String[] s = null;
                //String[] s = stringsInArray(in.nextLine());

                int count = 0;
                String[] s = new String[4];
                String h = in.next();

                if(h.contains("cut") == true) {
                    s[count] = "cut";
                    //System.out.println(s[count]);
                    count++;

                }
                if(h.contains("color")== true) {
                    s[count] = "color";
                    //System.out.println(s[count]);
                    count++;

                }
                if(h.contains("wash")==true) {
                    s[count] = "wash";
                    //System.out.println(s[count]);
                    count++;

                }
                if(h.contains("dry")==true){
                    s[count] = "dry";
                    //System.out.println(s[count]);
                    count++;

                }

                //System.out.println();
                //for(int i = 0; i < s.length; i++){
                //    System.out.println(s[i]);
                //}
                //System.out.println(s.length);

                int number = s.length - nullCounter(s);
                //System.out.println(number);
                String[] z = new String[number];

                for(int i = 0; i < number; i++){
                    z[i] = s[i];
                }

                adb.insertCheckAppointment(a,b,c,d, e, f, g, z);

                System.out.println();

                menu = 10;
                //Menu();
                return menu;
                //break;
            case 11:
                System.out.println();
                System.out.println("[11] Stylistenen eintragen und anzeigen: ");

                //pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");

                System.out.println("Geben Sie alle Stylistendaten ein. (Vorname, Nachname, E-Mail, Telefonnummer, Service(s)");
                String a3 = in.next();
                String b3 = in.next();
                String c3 = in.next();
                int d3 = in.nextInt();

                int count3 = 0;
                String[] s3 = new String[4];
                String h3 = in.next();

                if(h3.contains("cut") == true) {
                    s3[count3] = "cut";
                    //System.out.println(s3[count3]);
                    count3++;

                }
                if(h3.contains("color")== true) {
                    s3[count3] = "color";
                    //System.out.println(s3[count3]);
                    count3++;

                }
                if(h3.contains("wash")==true) {
                    s3[count3] = "wash";
                    //System.out.println(s3[count3]);
                    count3++;

                }
                if(h3.contains("dry")==true){
                    s3[count3] = "dry";
                    //System.out.println(s3[count3]);
                    count3++;

                }

                int number3 = s3.length - nullCounter(s3);
                String[] z3 = new String[number3];

                for(int i = 0; i < number3; i++){
                    z3[i] = s3[i];
                }

                pdb.insertStylist(a3, b3, c3, d3, z3);

                pdb.displayLastS();
                System.out.println();

                menu = 11;
                return menu;
            case 12:

                System.out.println("[12] Klienten in die Liste eintragen und anzeigen lassen: ");

                System.out.println("Geben Sie alle Kundendaten ein. (Vorname, Nachname, E-Mail, Telefonnummer");
                //Scanner in = new Scanner(System.in);
                String a2 = in.next();
                String b2 = in.next();
                String c2 = in.next();
                int d2 = in.nextInt();

                pdb.insertClient(a2, b2, c2, d2);

                pdb.displayLastC();
                System.out.println();

                menu = 12;
                return menu;
            case 13:
                System.out.println();
                adb.display();
                System.out.println("[13] Termin löschen. Geben Sie die passende Terminnummer ein: ");

                int index1 = in.nextInt() - 1;
                adb.delete(index1);
                System.out.println("Termin "+(index1+1)+" wurde gelöscht.");

                adb.bubbleSort();
                System.out.println("Terminliste ist sortiert.");

                menu = 13;
                return menu;
            case 14:
                System.out.println();
                pdb.displayStylists();
                System.out.println("[14] Stylisten-Konto löschen. Geben Sie die passende Stylistennummer an: ");

                int index2 = in.nextInt() -1;
                pdb.deleteStylist(index2);

                System.out.println("Stylisten-Konto "+(index2+1)+" wurde gelöscht.");

                menu = 14;
                return menu;
            case 15:
                System.out.println();
                pdb.displayClients();
                System.out.println("[15] Klienten-Konto löschen. Geben Sie die passende Kundennummer an: ");

                int index3 = in.nextInt() -1;
                pdb.deleteClient(index3);

                System.out.println("Klienten-Konto "+(index3+1)+" wurde gelöscht.");

                menu = 15;
                return menu;
            case 16:
                System.out.println();
                System.out.println("[16] Datenliste sortieren und abgelaufene Datensätze aus der Liste entfernen: ");
                String dat1 = in.next();
                adb.organizeAndDeleteExpiredData();

                menu = 16;
                return menu;
            case 17:
                System.out.println();
                System.out.println("[17] Stylisten anzeigen: ");
                pdb.displayStylists();

                menu = 17;
                return menu;
            case 18:
                System.out.println();
                System.out.println("[18] Klienten anzeigen: ");
                pdb.displayClients();

                menu = 18;
                return menu;
            case 19:
                System.out.println();
                System.out.println("[19] Alle Personen anzeigen: ");
                pdb.display();

                menu = 19;
                return menu;
            case 20:
                System.out.println();
                System.out.println("[20] Alle Termine nach Datum und Zeit sortieren: ");
                adb.bubbleSort();
                adb.display();

                menu = 20;
                return menu;
            case 101:
                System.out.println();
                System.out.println("[21] Termin für heute eintragen und anzeigen lassen: ");
                System.out.println("Hier sehen Sie unsere Stylisten. Suchen Sie die StylistenID ihres Stylisten und fügen Sie diese ein: ");
                System.out.println();
                pdb.displayStylists();
                int f1 = in.nextInt();

                System.out.println("Geben Sie ihren gewünschten Termin an. (hour, min, Kundennummer, service(s))");
                int d1 = in.nextInt();
                int e1 = in.nextInt();

                int g1 = in.nextInt();

                int count1 = 0;
                String[] s1 = new String[4];
                String h1 = in.next();

                if(h1.contains("cut") == true) {
                    s1[count1] = "cut";
                    //System.out.println(s1[count1]);
                    count1++;

                }
                if(h1.contains("color")== true) {
                    s1[count1] = "color";
                    //System.out.println(s1[count1]);
                    count1++;

                }
                if(h1.contains("wash")==true) {
                    s1[count1] = "wash";
                    //System.out.println(s1[count1]);
                    count1++;

                }
                if(h1.contains("dry")==true){
                    s1[count1] = "dry";
                    //System.out.println(s1[count1]);
                    count1++;

                }

                int number1 = s1.length - nullCounter(s1);
                String[] z1 = new String[number1];

                for(int i = 0; i < number1; i++){
                    z1[i] = s1[i];
                }

                System.out.println();
                adb.insertCheckToday(d1, e1, f1, g1, z1);

                System.out.println();

                menu = 21;
                return menu;
            case 22:
                System.out.println();
                System.out.println("[] empty ");
                menu = 22;
                return menu;
            case 23:
                System.out.println();
                System.out.println("[] empty ");
                menu = 23;
                return menu;
            case 24:
                System.out.println();
                System.out.println("[] empty ");
                menu = 24;
                return menu;
            case 99:
                System.out.println();
                System.out.println("[99] Planer wird geschlossen.");
                System.exit(0);
                menu = 99;
                //break;
            default:
                System.err.println("Falsche Eingabe");
                Menu();
                break;
        }



        return menu;
    }

        //unnötig
    public static void Menu2(){

        while(menu != 99) {

            if (menu == 0) Menu();

            else if (menu == 1) {
                System.out.println("1");
                System.out.println();
                Menu();
            }
            else if (menu == 2) {
                //printMap(list); //Apointment get all Entries

                System.out.println();
                Menu();
            }
            else if (menu == 3){
                System.out.println("Geben Sie ihre gewünschte Maximalmenge an Terminen an. (abhängig von Ihren Speicherkapazitäten)");
                Scanner in = new Scanner(System.in);
                //int a = in.nextInt();
                pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");
                System.out.println("Ihre Datensätze können bis zu "+in.nextInt()+" Einträge enthalten.");
                System.out.println();
                Menu();
            }
            else if (menu == 4){

                Menu();
            }
            else if (menu == 5){
                System.out.println("Geben Sie Ihren gewünschten Termin an. (day, month, year, hour, min, service(s))");
                Scanner in = new Scanner(System.in);
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();
                int e = in.nextInt();
/*
                String[] s = null;
                int count = 0;

                String f = in.nextLine();
                adb.insertA(a,b,c,d, e, s);
                if(f.contains("cut")) s[count] = "cut";
                if(f.contains("color")) s[count] = "color";
                if(f.contains("wash")) s[count] = "wash";
                if(f.contains("dry")) s[count] = "dry";

                System.out.println("Ein Termin wurde hinzugfügt.");
                adb.displayOne(adb.getCount());
                System.out.println();
                Menu();

                 */
            }
            else if (menu == 6){
                Menu();
            }

        }
    }

    public static String[] stringsInArray(String... s){
        return s;
    }

    //zählt die null-Werte in einem Array
    public static int nullCounter(String[] s){
        int count = 0;
        for(int i = 0; i < s.length; i++){
            if (s[i] == null){
                count++;
            }
        }
        return count;
    }

}
