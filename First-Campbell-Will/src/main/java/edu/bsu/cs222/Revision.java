package edu.bsu.cs222;

public class Revision {
    public String username = "";
    public String timestamp = "";

    public static String printBoth(Revision r) {
        return r.timestamp+ ", "+ r.username;
    }

    public static void command(String format){
        System.out.println(format);
    }

}
