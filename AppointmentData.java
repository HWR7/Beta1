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

    //insert Appointment
    public boolean insertAppointment(int day, int month, int year, int h,int min, int stylistID, int clientID,String... s){
        if(count >= max) return false;
        appointmentList[count] = new Appointment(day, month, year, h, min,stylistID, clientID, s);
        count++;
        return true;
    }

    public boolean insertToday(int h,int min, int stylistID, int clientID, String... s){
        if(count >= max) return false;
        appointmentList[count] = new Appointment(h, min, stylistID, clientID, s);
        count++;
        return true;
    }

    //insert Appointment with overlap check
    public boolean insertCheck(String dat, int day, int month, int year, int h,int min, int stylistID, int clientID, String... s){
        if(count >= max) return false;
        bubbleSort(dat);
        appointmentList[count] = new Appointment(day, month, year, h, min, stylistID, clientID, s);

        //insert code here
        boolean checkOverlap = checkOverlap(appointmentList[count], appointmentList[linearSearchYMD(appointmentList[count])]);
        if(checkOverlap == true){
            System.out.println("Dieser Termin überschneidet sich mit einem anderen Termin und wird gelöscht.");
            System.out.println("Wählen Sie bitte einen neuen Termin.");
            delete(count);
            return true;
        }

        count++;
        return true;
    }

    //Ueberschneidungen zwischen 2 Temrinen werden als true ausgegeben
    public boolean checkOverlap(Appointment a1, Appointment a2){
        boolean checkOverlap = false;

        int nr1 = a1.getTime() + a1.getMin() + (a1.getHour() * 60);         //Vergangene Zeit des Tages+des Termins in Minuten (Endzeit)
        int nr2 = a1.getMin() + (a1.getHour() * 60);                        //Vergangene Zeit des Tages in Minuten (Startzeit des Termins)
        int nr3 = a2.getTime() + a2.getMin() + (a2.getHour() * 60);
        int nr4 = a2.getMin() + (a2.getHour() * 60);


        if(a1.getDate() == a2.getDate()){
            if(a1.getHour()==a2.getHour() && a1.getMin() == a2.getMin()){
                checkOverlap = true;
            }
            else if( nr4<nr2 && nr2<nr3){
                checkOverlap = true;
            }
            else if( nr4<nr1 && nr1<nr3){
                checkOverlap = true;
            }
        }

        return checkOverlap;
    }

    public int linearSearchYMD(Appointment a){
        int index = -1;
        for(int i = 0; i < appointmentList.length; i++){
            if(appointmentList[i].getYear() == a.getYear()
                    && appointmentList[i].getMonth() == a.getMonth()
                    && appointmentList[i].getDay() == a.getDay()){
                index = i;
                return index;
            }
        }
        return index;
    }

    public void displayOne(int nr) {
            System.out.println("Termin "+(nr+1)+":");
            appointmentList[nr].display();
    }

    public void display() {
        for(int i = 0; i < count; i++){
            System.out.println("Termin "+(i+1)+":");
            appointmentList[i].display();
        }
    }

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

    //Sortiert die Datensätze und löscht bereits ausgelaufene
    public void organizeAndDeleteExpiredData(){

        AppointmentData adb = new AppointmentData(100);
        //adb.loadingAppointments("Termine.dat");
        adb.insertAppointment(1,2,3,15, 30, 1, 1,"wash");
        adb.insertToday(13,15, 1, 1,"wash");


        for(int i = 0; i <= appointmentList.length; i++){
            for(int j = 0; j <= appointmentList.length; j++){
                //Appointment a1 = appointmentList[j];
                //Appointment a2 = appointmentList[j+1];

                if(appointmentList[j].getYear() <= appointmentList[j+1].getYear()
                        && appointmentList[j].getMonth() <= appointmentList[j+1].getYear()
                        && appointmentList[j].getDay() <= appointmentList[j+1].getDay()
                        && appointmentList[j].getHour() <= appointmentList[j+1].getHour()
                        && appointmentList[j].getMin() < appointmentList[j+1].getMin()
                ){
                    if(checkExpired(appointmentList[j]) == true){
                        System.out.println("Datensatz "+j+" wurde gelöscht: ");
                        appointmentList[j].display();
                        delete(j);
                    }else {
                        Appointment a = appointmentList[j];
                        appointmentList[j] = appointmentList[j + 1];
                        appointmentList[j + 1] = a;
                    }
                }
                /*
                if(a1.getYear() <= a2.getYear()
                        && a1.getMonth() <= a2.getYear()
                        && a1.getDay() <= a2.getDay()
                        && a1.getHour() <= a2.getHour()
                        && a1.getMin() < a2.getMin()
                ){
                    if(checkExpired(appointmentList[j]) == true){
                        System.out.println("Datensatz "+j+" wurde gelöscht: ");
                        appointmentList[j].display();
                        delete(j);
                    }else {
                        Appointment a = appointmentList[j];
                        appointmentList[j] = appointmentList[j + 1];
                        appointmentList[j + 1] = a;
                    }
                }

                 */
            }
        }
    }

    //einfacher Suchalgorithmus, da einfachere Implementierung und keine großen Datenmengen zu erwarten
    public void bubbleSort(String dat){

        AppointmentData adb = new AppointmentData(100);
        adb.loadingAppointments(dat);

        for(int i = 0; i <= appointmentList.length; i++){
            for(int j = 0; j <= appointmentList.length; j++){

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
