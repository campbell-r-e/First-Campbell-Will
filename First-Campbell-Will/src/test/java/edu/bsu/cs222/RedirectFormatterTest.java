package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class RedirectFormatterTest {
@Test
public void RedirectFormatter_test() throws IOException {
    InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
    List<Redirect> listRevisions =  WikipediaParser.redirectParser(testDataStream);
    Assertions.assertEquals("Verizon Communications", Redirect.printTo(listRevisions.get(0)));
}
}