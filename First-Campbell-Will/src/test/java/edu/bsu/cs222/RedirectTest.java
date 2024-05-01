package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RedirectTest {
    @Test
    public void Printer_gui_test(){
        Assertions.assertEquals("Redirected to test", Redirect.printerGUI("test"));

    }

}