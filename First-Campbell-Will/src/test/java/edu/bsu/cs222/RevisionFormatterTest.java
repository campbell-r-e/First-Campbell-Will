package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class RevisionFormatterTest {
    @Test
    public void Revison_formatter_test() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        List<Revision> listRevisions =  WikipediaParser.revisionParser(testDataStream,0);
        Assertions.assertEquals("2023-09-17T21:08:19Z, GreenC bot", Revision.printBoth(listRevisions.get(0)));
    }

}