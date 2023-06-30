package Services;

import java.util.HashMap;
import java.util.Map;

import BaseClasses.Element;
import Classes.*;

public class ElementFactory2 {
//    private static final Map<String, Element> tagMap = new HashMap<>();
//
//    static {
//        tagMap.put("<p", new Paragraph());
//        tagMap.put("<a", new Anchor());
//        tagMap.put("<img", new Image());
//        tagMap.put("<html", new HTML());
//        tagMap.put("<head", new Head());
//        tagMap.put("<meta", new Meta());
//        tagMap.put("<body", new Body());
//        tagMap.put("<title", new Title());
//
//    }
//

    public Element getElement(String html) {
        if (html.charAt(0) != '<' || html.charAt(1) == '/') {
            return null;
        }

        int i = 0;


        while (html.charAt(++i) != '>' && html.charAt(i) != ' ') ;


//        if (tagMap.containsKey(html.substring(0, i)))
//            return tagMap.get(html.substring(0, i));
//
//        return null;

        switch (html.substring(0, i)) {
            case "<a":
                return new Anchor();
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
            default:
                return null;
        }

    }
}
