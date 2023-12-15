package Services;

import BaseClasses.Element;

import java.util.*;
import java.util.function.Supplier;

import BaseClasses.HtmlTag;
import Classes.*;

public class ElementFactory {
    private static final Map<String, Supplier<Element>> factoryMap = new HashMap<>();
    private static final Set<String> wantedElementsSet = new HashSet<>();

    public ElementFactory(List<HtmlTag> wantedElements) {

        for (HtmlTag tag : wantedElements) {
            wantedElementsSet.add(tag.getOpeningTag());
        }

        if (wantedElementsSet.contains("<p")) {
            factoryMap.put("<p", Paragraph::new);
        }
        if (wantedElementsSet.contains("<a")) {
            factoryMap.put("<a", A::new);
        }
        if (wantedElementsSet.contains("<head")) {
            factoryMap.put("<head", Head::new);
        }
        if (wantedElementsSet.contains("<meta")) {
            factoryMap.put("<meta", Meta::new);
        }
        if (wantedElementsSet.contains("<title")) {
            factoryMap.put("<title", Title::new);
        }
        if (wantedElementsSet.contains("<body")) {
            factoryMap.put("<body", Body::new);
        }
        if (wantedElementsSet.contains("<img")) {
            factoryMap.put("<img", Image::new);
        }
        if (wantedElementsSet.contains("<div")) {
            factoryMap.put("<div", Div::new);
        }
        if (wantedElementsSet.contains("<html")) {
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
