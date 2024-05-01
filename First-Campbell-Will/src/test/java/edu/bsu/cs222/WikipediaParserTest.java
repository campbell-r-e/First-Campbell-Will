package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WikipediaParserTest {
    @Test
    public void testParse_user() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        List<Revision> listRevisions =  WikipediaParser.revisionParser(testDataStream,0);
        Assertions.assertEquals("GreenC bot", listRevisions.get(0).username);
    }
    @Test
    public void testParse_Timestamp() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        List<Revision> listRevisions =  WikipediaParser.revisionParser(testDataStream,0);
        Assertions.assertEquals("2023-09-17T21:08:19Z", listRevisions.get(0).timestamp);
    }
    @Test
    public void testParse_redirect_From() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        List<Redirect> listRevisions =  WikipediaParser.redirectParser(testDataStream);
        Assertions.assertEquals("Verizon", listRevisions.get(0).from);

    }
    @Test
    public void testParse_redirect_to() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        List<Redirect> listRevisions =  WikipediaParser.redirectParser(testDataStream);
        Assertions.assertEquals("Verizon Communications", listRevisions.get(0).to);


    }




}
