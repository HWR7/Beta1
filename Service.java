package com.company;

public class Service {



    //Addieren der Zeit

    public static int sumDuration(String[] s){

        int length = s.length;
        int sumD = -1;

        switch(length){
            case 1:
                sumD = sumDuration1(s[0]);
                break;
            case 2:
                sumD = sumDuration2(s[0], s[1]);
                break;
            case 3:
                sumD = sumDuration3(s[0], s[1], s[2]);
                break;
            case 4:
                sumD = sumDuration4(s[0], s[1], s[2], s[3]);
                break;
            default:
                System.out.println("Zu viele Eingaben -> unzulässig");
                break;
        }
        return sumD;
    }

    public static int sumDuration1(String s) {
        int sumD = searchDuration(s);
        return sumD;
    }

    public static int sumDuration2(String s1, String s2) {
        int p1 = searchDuration(s1);
        int p2 = searchDuration(s2);
        int sumP = p1 +p2;
        return sumP;
    }

    public static int sumDuration3(String s1, String s2, String s3) {
        int p1 = searchDuration(s1);
        int p2 = searchDuration(s2);
        int p3 = searchDuration(s3);
        int sumP = p1 +p2 +p3;
        return sumP;
    }

    public static int sumDuration4(String s1, String s2, String s3, String s4) {
        int p1 = searchDuration(s1);
        int p2 = searchDuration(s2);
        int p3 = searchDuration(s3);
        int p4 = searchDuration(s4);
        int sumP = p1 +p2 +p3 +p4;
        return sumP;
    }

    public static int searchDuration(String s){
        int d = -1;
        switch(s){
            case "cut":
                d = Duration.getCut();
                break;
            case "color":
                d = Duration.getColor();
                break;
            case "dry":
                d = Duration.getDry();
                break;
            case "wash":
                d = Duration.getWash();
                break;
            default:
                System.out.print("Error 03");
                d = 0;
                break;
        }
        return d;
    }

    //Addieren der Preise

    public static double sumPrice(String[] s){

        int length = s.length;
        double sumP = -1;

        switch(length){
            case 1:
                sumP = sumPrice1(s[0]);
                break;
            case 2:
                sumP = sumPrice2(s[0], s[1]);
                break;
            case 3:
                sumP = sumPrice3(s[0], s[1], s[2]);
                break;
            case 4:
                sumP = sumPrice4(s[0], s[1], s[2], s[3]);
                break;
            default:
                System.out.println("Zu viele Eingaben -> unzulässig");
                break;
        }
        return sumP;
    }

    public static double sumPrice1(String s) {
        double sumP = searchPrice(s);
        return sumP;
    }

    public static double sumPrice2(String s1, String s2) {
        double p1 = searchPrice(s1);
        double p2 = searchPrice(s2);
        double sumP = p1 +p2;
        return sumP;
    }

    public static double sumPrice3(String s1, String s2, String s3) {
        double p1 = searchPrice(s1);
        double p2 = searchPrice(s2);
        double p3 = searchPrice(s3);
        double sumP = p1 +p2 +p3;
        return sumP;
    }

    public static double sumPrice4(String s1, String s2, String s3, String s4) {
        double p1 = searchPrice(s1);
        double p2 = searchPrice(s2);
        double p3 = searchPrice(s3);
        double p4 = searchPrice(s4);
        double sumP = p1 +p2 +p3 +p4;
        return sumP;
    }

    public static double searchPrice(String s){
        double p = -1;
        switch(s){
            case "cut":
                 p = Price.getCut();
                break;
            case "color":
                 p = Price.getColor();
                break;
            case "dry":
                 p = Price.getDry();
                break;
            case "wash":
                 p = Price.getWash();
                break;
            default:
                System.out.print("Error 03");
                p = 0;
                break;
        }
        return p;
    }


    //macht eine unbekannte Anzahl an Strings in ein Array rein
    // use case in der Auszuführenden Testklasse
    public static String[] stringsInArray(String... s){
        return s;
    }

    //macht eine unbekannte Anzahl an Strings in ein Array rein
    //not in use
    public static void array(String... s){
        String[] a = new String[s.length];
        for(int i = 0; i < s.length; i++){
            a[i] = s[i];
        }
    }

    //not in use
    public static void display(String... s){
        for(int i=0; i<s.length; i++){
            System.out.println(s[i]);
        }
    }
/*
    public static int length(String[] s){
        int length = s.length;
        return length;
    }

     */



}
