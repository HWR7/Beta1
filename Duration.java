package com.company;

public class Duration {

    private static int cut = 30;
    private static int color = 30;
    private static int dry = 30;
    private static int wash = 30;

    public static void change(String service, int price){
        switch(service){
            case "cut":
                Duration.cut = price;
                break;
            case "color":
                Duration.color = price;
                break;
            case "dry":
                Duration.dry = price;
                break;
            case "wash":
                Duration.wash = price;
                break;
            default:
                System.out.print("Error 03");
        }
    }

    public static int getCut() {
        return cut;
    }

    public static int getColor() {
        return color;
    }

    public static int getDry() {
        return dry;
    }

    public static int getWash() {
        return wash;
    }

    public void setCut(int cut) {
        this.cut = cut;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setDry(int dry) {
        this.dry = dry;
    }

    public void setWash(int wash) {
        this.wash = wash;
    }

}
