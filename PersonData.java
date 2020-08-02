package com.company;

import java.io.*;

public class PersonData {

    private int maxS;
    private int maxC;
    private Stylist[] stylistList;  //Zeiger auf Stylistarray
    private int countS = 0;
    private Client[] clientList;    //Zeiger auf Clientarray
    private int countC = 0;
    //private int count = countC + countS;

    public PersonData(int i1, int i2){
        maxS = i1;
        stylistList= new Stylist[maxS];
        maxC = i2;
        clientList= new Client[maxC];
    }

    public boolean insertStylist(String s1, String s2, String s3, long i, String... s4){
        if(getCountS() >= maxS) return false;
        stylistList[countS] = new Stylist(s1, s2, s3, i, s4);
        countS++;
        return true;
    }

    public boolean insertClient(String s1, String s2, String s3, long i){
        if(countC >= maxC) return false;
        clientList[countC] = new Client(s1, s2, s3, i);
        countC++;
        return true;
    }

    //nur einen Stylisten ausgeben per stylistID (index)
    public void display1S(int stylistID){
        System.out.println("Stylisten-Account "+(stylistID+1)+": ");
        stylistList[stylistID].shortDisplay();
        System.out.println();
        System.out.println();
    }

    //Ausgabe des letzten Stylisten
    public void displayLastS(){
        System.out.println("Stylisten-Account "+(countS)+": ");
        stylistList[countS-1].shortDisplay();
        System.out.println();
        System.out.println();
    }

    //Ausgabe des gesuchten Klientens mit seiner ID (Index aus dem Array)
    public void display1C(int clientID){
        System.out.println("Kunden-Account "+(clientID+1)+":");
        clientList[clientID].shortDisplay();
        System.out.println();
        System.out.println();
    }

    //Ausgabe des letzten Klientens
    public void displayLastC(){
        System.out.println("Kunden-Account "+(countC)+":");
        clientList[countC-1].shortDisplay();
        System.out.println();
        System.out.println();
    }

    //Ausgabe aller Stylisten
    public void displayStylists() {
        for(int i = 0; i < countS; i++){
            System.out.println("Stylisten-Account "+(i+1)+": ");
            stylistList[i].shortDisplay();
            System.out.println();
            System.out.println();
        }
    }

    //Ausgabe aller Klienten
    public void displayClients() {
        for(int j = 0; j < countC; j++){
            System.out.println("Client-Account "+(j+1)+":");
            clientList[j].shortDisplay();
            System.out.println();
        }
    }

    //Ausgabe aller Benutzerkonten (Stylisten+Klienten)
    public void display() {
        for(int i = 0; i < countS; i++){
            System.out.println("Stylisten-Account "+(i+1)+": ");
            stylistList[i].shortDisplay();
            System.out.println();
            System.out.println();
        }
        for(int j = 0; j < countC; j++){
            System.out.println("Client-Account "+(j+1)+":");
            clientList[j].shortDisplay();
            System.out.println();
        }
    }

    //Sicherung aller Accounts/Benutzerkonten
    public void saveAccounts(String s) {
        OutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ((ObjectOutputStream) out).writeObject(stylistList);
            ((ObjectOutputStream) out).writeObject(new Integer(countS));
            ((ObjectOutputStream) out).writeObject(clientList);
            ((ObjectOutputStream) out).writeObject(new Integer(countC));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Sicherung aller Klienten-Accounts auf einen extra angegebenen Speicherort
    public void saveCAccounts(String s) {
        OutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ((ObjectOutputStream) out).writeObject(clientList);
            ((ObjectOutputStream) out).writeObject(new Integer(countC));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Speicherung aller Stylisten-Accounts auf einen extra angegebenen Speicherort
    public void saveSAccounts(String s) {
        OutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ((ObjectOutputStream) out).writeObject(stylistList);
            ((ObjectOutputStream) out).writeObject(new Integer(countS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Laden aller Stylisten Accounts (Achutng: Es dürfen nur Stylisten im Array vorhanden sein)
    public void loadingSAccounts(String s) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            stylistList = (Stylist[]) in.readObject();
            countS = ((Integer) in.readObject()).intValue();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Laden aller Klienten Accounts (Achutng: Es dürfen nur Klienten im Array vorhanden sein)
    public void loadingCAccounts(String s) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            clientList = (Client[]) in.readObject();
            countC = ((Integer) in.readObject()).intValue();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Laden aller Accounts aus dem Array
    public void loadingAccounts(String s) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            stylistList = (Stylist[]) in.readObject();
            countS = ((Integer) in.readObject()).intValue();
            clientList = (Client[]) in.readObject();
            countC = ((Integer) in.readObject()).intValue();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Klient wird gelöscht mithilfe seiner Kundennummer (index+1)
    public void deleteClient(int nr) {
        for (int i = 0; i < clientList.length; i++) {
            if (clientList[i] == clientList[nr]) {
                // Daten verschieben
                for (int j = i; j < clientList.length - 1; j++) {
                    clientList[j] = clientList[j + 1];
                }
                countC--;
                break;
            }
        }
    }

    //Stylist wird gelöscht mithilfe seiner StylistenID (index+1)
    public void deleteStylist(int nr) {
        for (int i = 0; i < stylistList.length; i++) {
            if (stylistList[i] == stylistList[nr]) {
                // Daten verschieben
                for (int j = i; j < stylistList.length - 1; j++) {
                    stylistList[j] = stylistList[j + 1];
                }
                countS--;
                break;
            }
        }
    }

    //Klient wird gesucht mithilfe seiner Kundennummer (index+1)
    public Client getClient(int number){
        Client client = new Client();
        client = clientList[number-1];
        return client;
    }

    //Stylist wird gesucht mithilfe seiner StylistenID (index+1)
    public Stylist getStylist(int number){
        Stylist stylist = new Stylist();
        stylist = stylistList[number-1];
        return stylist;
    }

    public int getMaxS() {
        return maxS;
    }

    public int getMaxC() {
        return maxC;
    }

    public Stylist[] getStylistList() {
        return stylistList;
    }

    public int getCountS() {
        return countS;
    }

    public Client[] getClientList() {
        return clientList;
    }

    public int getCountC() {
        return countC;
    }

    public void setMaxS(int maxS) {
        this.maxS = maxS;
    }

    public void setMaxC(int maxC) {
        this.maxC = maxC;
    }

    public void setStylistList(Stylist[] stylistList) {
        this.stylistList = stylistList;
    }

    public void setCountS(int countS) {
        this.countS = countS;
    }

    public void setClientList(Client[] clientList) {
        this.clientList = clientList;
    }

    public void setCountC(int countC) {
        this.countC = countC;
    }
}


