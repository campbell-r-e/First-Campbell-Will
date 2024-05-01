package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class PrinterTest {
    @Test
    public void returns_revisions_test() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        List<Revision> listRevisions =  WikipediaParser.revisionParser(testDataStream,0);
        Printer print = new Printer();
        Assertions.assertEquals("""

                2023-09-17T21:08:19Z, GreenC bot
                2023-09-04T06:50:19Z, Kbrose
                2023-09-04T06:49:43Z, Kbrose
                2023-09-01T21:01:24Z, Justlettersandnumbers""", print.returnsRevisions(listRevisions));
    }
    @Test
    public void  returns_redierects_test() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");

        Printer print = new Printer();
        List<Redirect> listrederict =  WikipediaParser.redirectParser(testDataStream);
        Assertions.assertEquals("Redirected to Verizon Communications", print.returnsRedirects(listrederict));


    }


}