package com.company;

public class Price {

    private static double cut = 10.00;
    private static double color = 10.00;
    private static double dry = 10.00;
    private static double wash = 10.00;
    /*
    //Alternative Möglichkeit
    private static double cutncolor = cut + color;
    private static double washndry = wash + dry;
    private static double washncut = wash + cut;
    private static double colornwash = wash + color;
    usw...
     */

    //Ändern des Preises für den jeweiligen Service
    public static void change(String service, double price){
        switch(service){
            case "cut":
                Price.cut = price;
                break;
            case "color":
                Price.color = price;
                break;
            case "dry":
                Price.dry = price;
                break;
            case "wash":
                Price.wash = price;
                break;
            default:
                System.out.print("Error 03");
        }
    }

    public static double getCut() {
        return cut;
    }

    public static double getColor() {
        return color;
    }

    public static double getDry() {
        return dry;
    }

    public static double getWash() {
        return wash;
    }

    public void setCut(double cut) {
        this.cut = cut;
    }

    public void setColor(double color) {
        this.color = color;
    }

    public void setDry(double dry) {
        this.dry = dry;
    }

    public void setWash(double wash) {
        this.wash = wash;
    }
}
