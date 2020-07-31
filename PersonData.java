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

    public void display1S(){
        System.out.println("Stylisten-Account "+(countS+1)+": ");
        stylistList[countS].display();
        System.out.println();
        System.out.println();
    }

    public void display1C(){
        System.out.println("Stylisten-Account "+(countC+1)+":");
        clientList[countC].display();
        System.out.println();
        System.out.println();
    }

    public void displayStylists() {
        for(int i = 0; i < countS; i++){
            System.out.println("Stylisten-Account "+(i+1)+": ");
            stylistList[i].display();
            System.out.println();
            System.out.println();
        }
    }

    public void displayClients() {
        for(int j = 0; j < countC; j++){
            System.out.println("Client-Account "+(j+1)+":");
            clientList[j].display();
            System.out.println();
        }
    }

    public void display() {
        for(int i = 0; i < countS; i++){
            System.out.println("Stylisten-Account "+(i+1)+": ");
            stylistList[i].display();
            System.out.println();
            System.out.println();
        }
        for(int j = 0; j < countC; j++){
            System.out.println("Client-Account "+(j+1)+":");
            clientList[j].display();
            System.out.println();
        }
    }

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

    public Client getClient(int number){
        Client client = new Client();
        client = clientList[number-1];
        return client;
    }

    public Stylist getStylist(int number){
        Stylist stylist = new Stylist();
        stylist = stylistList[number-1];
        return stylist;
    }

    public Client findClient(String fname){
        Client client = new Client();

        for(int i = 0; i < clientList.length; i++){
            if(clientList[i].getLname() == fname){
                client = clientList[i];
                return client;
            }
        }

        return client;
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


