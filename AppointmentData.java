package com.company;

import java.io.*;

public class AppointmentData {

    private int count = 0;
    private int max;
    private Appointment[] appointmentList;

    public AppointmentData(int i){
        max = i;
        appointmentList = new Appointment[max];
    }

    //insert Appointment mit Sort
    public boolean insertAppointment(int day, int month, int year, int h,int min, int stylistID, int clientID,String... s){
        if(count >= max) return false;
        appointmentList[count] = new Appointment(day, month, year, h, min,stylistID, clientID, s);
        count++;
        displayOne(count);
        System.out.println("Ein Termin wurde hinzugefügt.");
        bubbleSort();
        return true;
    }

    //insert Appointment heute mit Sort
    public boolean insertToday(int h,int min, int stylistID, int clientID, String... s){
        if(count >= max) return false;
        appointmentList[count] = new Appointment(h, min, stylistID, clientID, s);
        count++;
        displayOne(count);
        System.out.println("Ein Termin wurde hinzugfügt.");
        bubbleSort();
        return true;
    }

    //insert Appointment with overlap check and sort
    public boolean insertCheckAppointment(int day, int month, int year, int h,int min, int stylistID, int clientID, String... s){

        //System.out.println(count);
        if(count >= max) return false;

        if(count == 0) {
            insertAppointment(day, month, year, h, min, stylistID, clientID, s);
            return true;
        }

        Appointment a = new Appointment(day, month, year, h, min, stylistID, clientID, s);

        if(linearSearchYMDHM(a) == true){

            //System.out.println(count);
            //appointmentList[count-1].display();
            //appointmentList[linearSearchYMDIndex(a)].display();

            boolean checkOverlap = checkOverlap(a, appointmentList[linearSearchYMDHMIndex(a)]);

            if(checkOverlap == true) {
                System.out.println("Dieser Termin überschneidet sich mit einem anderen Termin und wird gelöscht.");
                System.out.println("Wählen Sie bitte einen neuen Termin.");
                //delete(count);
                return false;
            }
        }
        appointmentList[count] = new Appointment(day, month, year, h, min, stylistID, clientID, s);
        count++;
        displayOne(count);
        System.out.println("Ein Termin wurde hinzugfügt.");
        bubbleSort();
        return true;


    }

    //insert Appointment for today with overlap check and sort
    public boolean insertCheckToday(int h,int min, int stylistID, int clientID, String... s){

        //System.out.println(count);
        if(count >= max) return false;

        if(count == 0) {
            insertToday( h, min,  stylistID,  clientID, s);
            return true;
        }

        Appointment a = new Appointment(h, min, stylistID, clientID, s);

        if(linearSearchYMDHM(a) == true){

            //System.out.println(count);
            //appointmentList[count-1].display();
            //appointmentList[linearSearchYMDIndex(a)].display();

            boolean checkOverlap = checkOverlap(a, appointmentList[linearSearchYMDHMIndex(a)]);

            if(checkOverlap == true) {
                System.out.println("Dieser Termin überschneidet sich mit einem anderen Termin und wird gelöscht.");
                System.out.println("Wählen Sie bitte einen neuen Termin.");
                //delete(count);
                return false;
            }
        }
        appointmentList[count] = new Appointment(h, min, stylistID, clientID, s);
        count++;
        displayOne(count);
        System.out.println("Ein Termin wurde hinzugfügt.");
        bubbleSort();
        return true;


    }

    //Ueberschneidungen zwischen 2 Temrinen werden als true ausgegeben
    public boolean checkOverlap(Appointment a1, Appointment a2){
        boolean checkOverlap = false;

        int nr1 = a1.getTime() + a1.getMin() + (a1.getHour() * 60);         //Vergangene Zeit des Tages+des Termins in Minuten (Endzeit)
        int nr2 = a1.getMin() + (a1.getHour() * 60);                        //Vergangene Zeit des Tages in Minuten (Startzeit des Termins)
        int nr3 = a2.getTime() + a2.getMin() + (a2.getHour() * 60);
        int nr4 = a2.getMin() + (a2.getHour() * 60);

        if(a1.getYear() == a2.getYear()
                && a1.getMonth() == a2.getMonth()
                && a1.getDay() == a2.getDay()
        ){
            if(a1.getHour()==a2.getHour() && a1.getMin() == a2.getMin()){
                checkOverlap = true;
                //System.out.println("1");
            }
            else if( nr4<nr2 && nr2<nr3){
                checkOverlap = true;
                //System.out.println("2");
            }
            else if( nr4<nr1 && nr1<nr3){
                checkOverlap = true;
                //System.out.println("3");
            }
        }

        return checkOverlap;
    }

    //Suche nach Termin durch Datum
    public boolean linearSearchYMD(Appointment a) {
        //boolean found = false;
        for (int i = 0; i < count; i++) {
            if (appointmentList[i].getYear() == a.getYear()
                    && appointmentList[i].getMonth() == a.getMonth()
                    && appointmentList[i].getDay() == a.getDay()
                    && appointmentList[i].getHour() == a.getHour()
                    && appointmentList[i].getMin() == a.getMin()
            ) {
                //found = true;
                //System.out.println("found");
                return true;
            }
        }
        return false;
    }

    //Suche nach Termin durch gleiches Datum und Zeit
    public boolean linearSearchYMDHM(Appointment a) {
        //boolean found = false;
        for (int i = 0; i < count; i++) {
            if (appointmentList[i].getYear() == a.getYear()
                    && appointmentList[i].getMonth() == a.getMonth()
                    && appointmentList[i].getDay() == a.getDay()
                    && appointmentList[i].getHour() == a.getHour()
                    && appointmentList[i].getMin() == a.getMin()
            ) {
                //found = true;
                //System.out.println("found");
                return true;
            }
        }
        return false;
    }
/*
    public boolean linearSearchEmail(Appointment a) {
        //boolean found = false;
        for (int i = 0; i < count; i++) {
            Client client = appointmentList[i].getClient();
            if (
            ) {
                //found = true;
                //System.out.println("found");
                return true;
            }
        }
        return false;
    }

 */

    public int linearSearchYMDIndex(Appointment a){
        int index = 0;
        for(int i = 0; i < count; i++){
            if(appointmentList[i].getYear() == a.getYear()
                    && appointmentList[i].getMonth() == a.getMonth()
                    && appointmentList[i].getDay() == a.getDay()){
                index = i;
                //System.out.println("found");
                return index;
            }
        }
        return index;
    }

    //Suche nach dem Index des gesuchten Termins
    public int linearSearchYMDHMIndex(Appointment a){
        int index = 0;
        for(int i = 0; i < count; i++){
            if(appointmentList[i].getYear() == a.getYear()
                    && appointmentList[i].getMonth() == a.getMonth()
                    && appointmentList[i].getDay() == a.getDay()
                    && appointmentList[i].getHour() == a.getHour()
                    && appointmentList[i].getMin() == a.getMin()
            ){
                index = i;
                //System.out.println("found");
                return index;
            }
        }
        return index;
    }

    //Ausgabe eines Termins
    public void displayOne(int nr) {
            System.out.println("Termin "+(nr)+":");
            appointmentList[nr-1].display();
    }

    //Ausgabe aller Termine
    public void display() {
        for(int i = 0; i < count; i++){
            System.out.println("Termin "+(i+1)+":");
            appointmentList[i].display();
        }
    }

    //Sicherung des Termins durch anzugebenen Dateinamen in dieser danach benannten Datei
    public void saveAppointments(String dat) {
        OutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(dat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ((ObjectOutputStream) out).writeObject(appointmentList);
            ((ObjectOutputStream) out).writeObject(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Laden der genannten Datei
    public void loadingAppointments(String dat) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(dat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            appointmentList = (Appointment[]) in.readObject();
            count = ((Integer) in.readObject()).intValue();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Termine die vor dem aktuellen Datum waren werden als true ausgegeben
    public boolean checkExpired(Appointment a){
        boolean checkExpired = false;
        Date d = new Date();

        if(a.getYear() < d.getYear()) checkExpired = true;
        if(a.getYear() == d.getYear() && a.getMonth() < d.getYear()) checkExpired = true;
        if(a.getYear() == d.getYear() && a.getMonth() == d.getYear() && a.getDay()<d.getDay()) checkExpired = true;

        return checkExpired;
    }

    //Löschen eines Termins mit der Nummer des Termins(index +1)
    public void delete(int nr) {
        for (int i = 0; i < appointmentList.length; i++) {
            if (appointmentList[i] == appointmentList[nr]) {
                // Daten verschieben
                for (int j = i; j < appointmentList.length - 1; j++) {
                    appointmentList[j] = appointmentList[j + 1];
                }
                count--;
                break;
            }
        }
    }

    //Sortiert die Datensätze und löscht bereits ausgelaufene durch Eingabe der TerminDatei
    public void organizeAndDeleteExpiredData() {

        bubbleSort();
        for (int i = 0; i < count; i++) {
            if (checkExpired(appointmentList[i]) == true) {
                System.out.println("Datensatz " + i +1 + " wurde gelöscht: ");
                appointmentList[i].display();
                delete(i);
            }

            System.out.println("Vorgang beendet und die Terminliste ist nun aktualisiert.");
            System.out.println();

        }
    }

    //einfacher Suchalgorithmus, da einfachere Implementierung und keine großen Datenmengen zu erwarten (vllt. durch bspw. QuickSort auswechselbar)
    public void bubbleSort(){

        //System.out.println(appointmentList.length);
        //System.out.println(count);


        for(int i = 0; i < (count-1); i++){
            for(int j = 0; j < (count-1); j++){

                //Appointment a1 = appointmentList[j];
                //int k = j+1;
                //Appointment a2 = appointmentList[k];
                //a1.display();
                //a2.display();

                /*
                int year1 = a1.getYear();
                int year2 = a2.getYear();
                int month1 = a1.getMonth();
                int month2 = a2.getMonth();
                int day1 = a1.getDay();
                int day2 = a2.getDay();
                int h1 = a1.getHour();
                int h2 = a2.getHour();
                int min1 = a1.getMin();
                int min2 = a2.getMin();

                if(year1 <= year2
                        && a1.getMonth() <= a2.getYear()
                        && a1.getDay() <= a2.getDay()
                        && a1.getHour() <= a2.getHour()
                        && a1.getMin() < a2.getMin()
                ){
                    Appointment a = appointmentList[j];
                    appointmentList[j] = appointmentList[j + 1];
                    appointmentList[j + 1] = a;
                }

                 */
/*
                ObjectInputStream in = null;
                try {
                    in = new ObjectInputStream(new FileInputStream(dat));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    appointmentList = (Appointment[]) in.readObject();
                    count = ((Integer) in.readObject()).intValue();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

 */
                //appointmentList[j].display();

                int year1 = appointmentList[j].getYear();
                int year2 = appointmentList[j+1].getYear();
                int month1 = appointmentList[j].getMonth();
                int month2 = appointmentList[j+1].getMonth();
                int day1 = appointmentList[j].getDay();
                int day2 = appointmentList[j+1].getDay();
                int h1 = appointmentList[j].getHour();
                int h2 = appointmentList[j+1].getHour();
                int min1 = appointmentList[j].getMin();
                int min2 = appointmentList[j+1].getMin();

                if(year1 <= year2
                        && month1 <= month2
                        && day1 <= day2
                        && h1 <= h2
                        && min1 < min2
                ){
                    Appointment a = appointmentList[j];
                    appointmentList[j] = appointmentList[j + 1];
                    appointmentList[j + 1] = a;
                }

/*

 */

            }
        }
    }


/*
    public boolean insertA(int day, int month, int year, int h,int min, String... s){
        if(count >= max) return false;
        appointmentList[count] = new Appointment(day, month, year, h, min, s);
        count++;
        return true;
    }

 */


    public Appointment getAppointment(int nr){
        Appointment a = appointmentList[nr];
        return a;
    }

    public int getCount(){
        return count;
    }

}
