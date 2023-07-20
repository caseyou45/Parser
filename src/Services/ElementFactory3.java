package Services;

import BaseClasses.Element;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import Classes.*;

public class ElementFactory3 {
    private static final Map<String, Supplier<Element>> factoryMap = new HashMap<>();
    private static final Set<String> unwantedElements = new HashSet<>();

    static {
        unwantedElements.addAll(Set.of("p", "div", "body", "head", "html", "meta", "title"));

        if (!unwantedElements.contains("p")) {
            factoryMap.put("<p", Paragraph::new);
        }
        if (!unwantedElements.contains("a")) {
            factoryMap.put("<a", Anchor::new);
        }
        if (!unwantedElements.contains("head")) {
            factoryMap.put("<head", Head::new);
        }
        if (!unwantedElements.contains("meta")) {
            factoryMap.put("<meta", Meta::new);
        }
        if (!unwantedElements.contains("title")) {
            factoryMap.put("<title", Title::new);
        }
        if (!unwantedElements.contains("body")) {
            factoryMap.put("<body", Body::new);
        }
        if (!unwantedElements.contains("img")) {
            factoryMap.put("<img", Image::new);
        }
        if (!unwantedElements.contains("div")) {
            factoryMap.put("<div", Div::new);
        }
        if (!unwantedElements.contains("html")) {
            factoryMap.put("<html", HTML::new);
        }
    }

    public Element getElement(String html, int i) {

        int base = i;
        if (html.charAt(i + 1) == '/')
            return null;


        while (i < html.length() && html.charAt(i) != '>' && html.charAt(i) != ' ') i++;


        String tag = html.substring(base, i);
        Supplier<Element> factory = factoryMap.get(tag.toLowerCase());
        if (factory != null) {
            return factory.get();
        }
        return null;
    }
}
