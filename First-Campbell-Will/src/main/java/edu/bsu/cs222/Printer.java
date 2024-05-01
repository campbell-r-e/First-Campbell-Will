package edu.bsu.cs222;

import java.util.List;

public class Printer {
    public void printsRevisions(List<Revision> listRevisions) {
        for (Revision listRevision : listRevisions) {
            Revision.command(Revision.printBoth(listRevision));
        }
    }

    public String returnsRevisions(List<Revision> listRevisions) {
        StringBuilder sb = new StringBuilder();
        for (Revision listRevision : listRevisions) {
            sb.append("\n" + Revision.printBoth(listRevision));
        }
        String result = sb.toString();
        return result;
    }

    public void printsRedirects(List<Redirect> listRedirects) {
        Redirect.printer_command(Redirect.printTo(listRedirects.get(0)));
    }

    public String returnsRedirects(List<Redirect> listRedirects) {
        return Redirect.printerGUI(Redirect.printTo(listRedirects.get(0)));
    }
}
