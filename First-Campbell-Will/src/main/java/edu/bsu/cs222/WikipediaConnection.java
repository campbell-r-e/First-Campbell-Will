package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class WikipediaConnection {
    public static String dataPuller (String userQuery) throws IOException {
        URLConnection connection = connectToWikipedia(userQuery);
        return readJsonAsStringFrom(connection);
    }

    public static URLConnection connectToWikipedia(String input) throws IOException {
            String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                    URLEncoder.encode(input, Charset.defaultCharset()) +
                    "&rvprop=timestamp|user&rvlimit=13&redirects";
            URL url = new URL(encodedUrlString);
             URLConnection connection = url.openConnection();
             connection.setRequestProperty("Will-Pancake", "CS222FirstProject/Group F v0.1.0 (wgpancake@bsu.edu)");
             connection.connect();
             return connection;
    }

    public static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }
}
