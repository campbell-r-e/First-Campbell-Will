package edu.bsu.cs222;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CommandController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a wikipedia article");
        String userQuery = scanner.nextLine();
        if (userQuery.isEmpty()) {
            System.err.println("No article name provided, please try again");
            return;
        }
        try {
            String articleData = WikipediaConnection.dataPuller(userQuery);
            List<Revision> listRevisions = WikipediaParser.getRevisions(articleData, 0);
            List<Redirect> listRedirect = WikipediaParser.getRedirects(articleData);
            Printer printData = new Printer();
            printData.printsRedirects(listRedirect);
            printData.printsRevisions(listRevisions);
        } catch (IOException e) {
            System.err.println("Connection error");
        }
    }
}
