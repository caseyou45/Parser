package Services;

import BaseClasses.Element;
import Classes.*;

public class ElementFactory {


    public Element getElement(String html) {

        if (html.charAt(0) != '<') {
            return null;
        }

        if (html.length() >= 2) {
            if (html.charAt(1) == 'p') {
                return new Paragraph();
            }
            if (html.charAt(1) == 'a') {
                return new A();
            }

        }

        String tag = html.substring(0, 4);
        switch (tag) {
            case "<htm":
                return new HTML();
            case "<hea":
                return new Head();
            case "<met":
                return new Meta();
            case "<tit":
                return new Title();
            case "<bod":
                return new Body();
            case "<img":
                return new Image();
            default:
                return null;
        }


    }

}
