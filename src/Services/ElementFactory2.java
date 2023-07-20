package Services;

import java.util.*;

import BaseClasses.Element;
import Classes.*;

public class ElementFactory2 {
    private static final Set<String> unwantedElements = new HashSet<>();

    static {
        unwantedElements.addAll(List.of("<p", "<div", "<body", "<head", "<html", "<img", "<meta"));
    }


    public Element getElement(String html, int i) {

        int base = i;
        if (html.charAt(i + 1) == '/')
            return null;


        while (i < html.length() && html.charAt(i) != '>' && html.charAt(i) != ' ') i++;


        String tag = html.substring(base, i);

        if (unwantedElements.contains(tag)) {
            return null;
        }


        switch (tag) {
            case "<a":
                return new A();
            case "<p":
                return new Paragraph();
            case "<head":
                return new Head();
            case "<meta":
                return new Meta();
            case "<title":
                return new Title();
            case "<body":
                return new Body();
            case "<img":
                return new Image();
            case "<div":
                return new Div();
            case "<html":
                return new HTML();
            default:
                return null;
        }

    }
}
