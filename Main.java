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



        System.out.println("Geben Sie ihre gewünschte Maximalmenge an Stylisten und Klienten an. (1.Stylist; 2.Client)");
        Scanner in1 = new Scanner(System.in);
        int z1 = in1.nextInt();
        int z2 = in1.nextInt();
        pdb = new PersonData(z1, z2);
        System.out.println("Ihre Datensätze können bis zu "+z1+" Stylisten und "+z2+" Klienten enthalten.");
        System.out.println();

        System.out.println("Geben Sie ihre gewünschte Maximalmenge Terminen. (abhängig von ihren Speicherkapazitäten)"); //Tippfehler
        Scanner in2 = new Scanner(System.in);
        int z3 = in2.nextInt();
        adb = new AppointmentData(z3);
        System.out.println("Ihre Datensätze können bis zu "+z3+" Einträge enthalten.");
        System.out.println();

        while(menu != 99){
            Menu();
        }


        //System.exit(0);
    }


    public static int Menu(){ //Menü mit Auswahlmöglichkeiten

        int menu = 0;

        System.out.println();
        System.out.println("Terminplaner (gewünschte Option per Zahl auswaehlen)");
        System.out.println();
        System.out.println("[1]  Terminliste speichern");
        System.out.println("[2]  Terminliste auslesen lassen");

        System.out.println("[3]  Stylist- und Klientenliste speichern");
        System.out.println("[4]  Nur die Klientenliste speichern");
        System.out.println("[5]  Nur die Stylistenliste speichern");

        System.out.println("[6]  Termine aus dem Speicher laden");
        System.out.println("[7]  Alle Konten (Stylist + Kunden) aus dem Speicher laden und anzeigen");
        System.out.println("[8]  Nur die Klientenliste aus dem Speicher laden und anzeigen");
        System.out.println("[9]  Nur die Stylistenliste aus dem Speicher laden und anzeigen");

        System.out.println("[10] Termin in die Liste eintragen und anzeigen lassen");
        System.out.println("[11] Stylisten in die Liste eintragen und anzeigen lassen");
        System.out.println("[12] Klienten in die Liste eintragen und anzeigen lassen");

        System.out.println("[13] Termin löschen");
        System.out.println("[14] Stylisten-Konto löschen");
        System.out.println("[15] Clienten-Konto löschen");

        System.out.println("[16] Datenliste sortieren und abgelaufene Datensätze aus der Liste entfernen");
        System.out.println("[17] Stylisten anzeigen lassen");               //not rdy
        System.out.println("[18] Klineten anzeigen lassen");                //not rdy
        System.out.println("[19] Alle Personen anzeigen lassen");           //not rdy

        System.out.println("[20] empty");
        System.out.println("[21] empty");
        System.out.println("[22] empty");

        System.out.println("[99] Programm beenden");

        Scanner in = new Scanner(System.in);

        switch(in.nextInt()) {
            case 1:
                System.out.println("Terminliste speichern:");
                adb.saveAppointments("termin.dat");
                menu = 1;
                //Menu();
                return menu;
                //break;
            case 2:
                System.out.println("Terminliste auslesen lassen: ");
                adb.display();
                menu = 2;
                //Menu();
                return menu;
                //break;
            case 3:
                System.out.println("Stylist- und Klientenliste speichern: ");
                pdb.saveAccounts("Konten.dat");
                menu = 3;
                //Menu();
                return menu;
                //break;
            case 4:
                System.out.println("Nur die Klientenliste speichern: ");
                pdb.saveCAccounts("Konten.dat");
                menu = 4;
                //Menu();
                return menu;
                //break;
            case 5:
                System.out.println("Nur die Stylistenliste speichern: ");
                pdb.saveSAccounts("Konten.dat");
                menu = 5;
                return menu;
            case 6:
                System.out.println("Termine aus dem Speicher laden: ");
                pdb.loadingAccounts("Konten.dat");
                pdb.display();
                menu = 6;
                return menu;
            case 7:
                System.out.println("Alle Konten (Stylist + Kunden) aus dem Speicher laden: ");
                pdb.loadingAccounts("Konten.dat");
                pdb.display();
                menu = 7;
                return menu;
            case 8:
                System.out.println("Nur die Klientenliste aus dem Speicher laden: ");
                pdb.loadingCAccounts("Konten.dat");
                pdb.display();
                menu = 8;
                return menu;
            case 9:
                System.out.println("Nur die Stylistenliste aus dem Speicher laden: ");
                pdb.loadingSAccounts("Konten.dat");
                pdb.display();
                menu = 9;
                return menu;
            case 10:
                System.out.println("Termin in die Liste eintragen und anzeigen lassen");
                System.out.println("Hier sehen Sie unsere Stylisten. Suchen Sie die StylistenID ihres Stylisten und fügen Sie diese ein: ");
                pdb.displayStylists();
                int f = in.nextInt();

                System.out.println("Geben Sie ihren gewünschten Termin an. (day, month, year, hour, min, Kundennummer, service(s))");
                //Scanner in = new Scanner(System.in);
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();
                int e = in.nextInt();

                int g = in.nextInt();
                String h = in.nextLine();

                //String[] s = null;
                String[] s = stringsInArray(in.nextLine());
                //int count = 0;

                s = h.split(",",0);
                for(String kp : s) System.out.println(s);System.out.println(s);

                /*
                h = in.nextLine();
                for(int count = 0; count <= 3;){
                    if(h.contains("cut")) s[count] = "cut";
                    count++;
                    if(h.contains("color")) s[count] = "color";
                    count++;
                    if(h.contains("wash")) s[count] = "wash";
                    count++;
                    if(h.contains("dry")) s[count] = "dry";
                    count++;
                }
                 */

                adb.insertAppointment(a,b,c,d, e, f, g, s);

                System.out.println("Ein Termin wurde hinzugfügt.");
                adb.displayOne(adb.getCount());
                System.out.println();

                menu = 10;
                //Menu();
                return menu;
                //break;
            case 11:
                System.out.println("Stylisten in die Liste eintragen und anzeigen lassen: ");

                pdb.insertStylist("Chanti", "Mueller", "c.mueller@mail.de", 123123, "cut", "wash");

                pdb.displayLastS();

                menu = 11;
                return menu;
            case 12:
                System.out.println("Klienten in die Liste eintragen und anzeigen lassen: ");

                pdb.insertClient("Chanto", "Mueller", "c.mueller@mail.de", 123123);

                pdb.displayLastC();

                menu = 12;
                return menu;
            case 13:
                adb.display();
                System.out.println("Termin löschen. Geben Sie die passende Terminnummer ein: ");

                int index1 = in.nextInt() - 1;
                adb.delete(index1);

                System.out.println("Termin "+(index1+1)+" wurde gelöscht.");

                menu = 13;
                return menu;
            case 14:
                pdb.displayStylists();
                System.out.println("Stylisten-Konto löschen. Geben Sie die passende Stylistennummer an: ");

                int index2 = in.nextInt() -1;
                pdb.deleteStylist(index2);

                System.out.println("Stylisten-Konto "+(index2+1)+" wurde gelöscht.");

                menu = 14;
                return menu;
            case 15:
                pdb.displayClients();
                System.out.println("Klienten-Konto löschen. Geben Sie die passende Kundennummer an: ");

                int index3 = in.nextInt() -1;
                pdb.deleteClient(index3);

                System.out.println("Klienten-Konto "+(index3+1)+" wurde gelöscht.");

                menu = 15;
                return menu;
            case 16:
                adb.organizeAndDeleteExpiredData();
                menu = 16;
                return menu;
            case 17:
                System.out.println("Stylisten anzeigen lassen: ");
                pdb.displayStylists();
                menu = 17;
                return menu;
            case 18:
                System.out.println("[18] Klineten anzeigen lassen");
                pdb.displayClients();
                menu = 18;
                return menu;
            case 19:
                System.out.println("[19] Alle Personen anzeigen lassen");
                pdb.displayClients();
                menu = 19;
                return menu;
            case 20:

                menu = 20;
                return menu;
            case 99:
                System.out.println("Planer wird geschlossen");
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
                System.out.println("Geben Sie ihre gewünschte Maximalmenge Terminen. (abhängig von ihren Speicherkapazitäten)");
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
                System.out.println("Geben Sie ihren gewünschten Termin an. (day, month, year, hour, min, service(s))");
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

}
