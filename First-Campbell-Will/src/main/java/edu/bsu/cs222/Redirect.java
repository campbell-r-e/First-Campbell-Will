package edu.bsu.cs222;

public class Redirect {
    public String to = "";
    public String from = "";

    public static String printTo(Redirect redirectFormatter) {
        return redirectFormatter.to;
    }
    public static void printer_command(String redirectValue){
        System.out.println("Redirected to " + redirectValue);
    }

    public static String printerGUI(String redirectValue){
        String redirected = "Redirected to " + redirectValue;
        return redirected;
    }
}
