package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class WikipediaParser {

    public static List<Revision> getRevisions(String articleData, int exitCode) throws IOException {
        InputStream revisionsStream = new ByteArrayInputStream(articleData.getBytes(StandardCharsets.UTF_8));
        List<Revision> revisionsList = revisionParser(revisionsStream, exitCode);
        return revisionsList;
    }

    public static List<Redirect> getRedirects(String articleData) throws IOException {
        InputStream redirectStream = new ByteArrayInputStream(articleData.getBytes(StandardCharsets.UTF_8));
        List<Redirect> redirectsList = redirectParser(redirectStream);
        return redirectsList;
    }

    public static List<Revision> revisionParser(InputStream testDataStream, int exitCode) throws IOException {
        JSONArray result = JsonPath.read(testDataStream, "$..revisions");
        if (result.isEmpty()) {
            noArticleError(exitCode);

        }
        List<Revision> listRevisions = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) result.get(0);
            for(Object rev : jsonArray){
                Revision revision = new Revision();
                revision.username = ((LinkedHashMap<?, ?>) rev).get("user").toString();
                revision.timestamp = ((LinkedHashMap<?, ?>) rev).get("timestamp").toString();
                listRevisions.add(revision);
            }
        return listRevisions;
    }

    public static List<Redirect> redirectParser(InputStream testDataStream) throws IOException {
        JSONArray result = JsonPath.read(testDataStream, "$..redirects");
        List<Redirect> listRedirect = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) result.get(0);
        for(Object rev : jsonArray){
            Redirect redirect = new Redirect();
            redirect.to = ((LinkedHashMap<?, ?>) rev).get("to").toString();
            redirect.from = ((LinkedHashMap<?, ?>) rev).get("from").toString();
            listRedirect.add(redirect);
        }
        return listRedirect;
    }

    public static void noArticleError(int exitCode) {
            if (exitCode == 0) {
                System.err.println("Mo article exists with that name");
                System.exit(0);
            } else if (exitCode == 1) {
                GUI.showNoArticleError();
        }
    }
}
