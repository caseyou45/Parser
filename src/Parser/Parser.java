package Parser;

import BaseClasses.Element;
import BaseClasses.HtmlTag;
import Services.ElementFactory;

import java.util.*;

public class Parser {

    private final String html;
    private final Map<HtmlTag, List<Element>> elementMap;
    private final List<HtmlTag> wantedElements;


    public Parser(String html, List<HtmlTag> wantedElements) {
        this.html = html;
        this.elementMap = new HashMap<>();
        this.wantedElements = wantedElements;
        go();
    }


    private void go() {
        elementFinder(html, elementMap);
    }


    public Map<HtmlTag, List<Element>> getElementMap() {
        return elementMap;
    }


    private void elementFinder(String html, Map<HtmlTag, List<Element>> elementMap) {
        Deque<Element> deque = new LinkedList<>();

        int index = 0;

        int end = html.length();

        ElementFactory elementFactory = new ElementFactory(wantedElements);

        Element el;


        while (index < end) {

            if (html.charAt(index) == '<' && (el = elementFactory.getElement(html, index)) != null) {
                deque.addFirst(el);

                int indexOfEndOfStartingTag;

                if (el.isSelfClosing()) {
                    indexOfEndOfStartingTag = html.indexOf(el.getEndingTag(), index);
                } else {
                    indexOfEndOfStartingTag = html.indexOf(">", index);
                }

                if ((indexOfEndOfStartingTag - index) > el.getStartingTagLength()) {

                    el.setAttributes(html.substring(index + el.getStartingTagLength(), indexOfEndOfStartingTag));
                }

                el.setIndexOfEndOfStartingTag(indexOfEndOfStartingTag);


            } else if (deque.size() > 0) {

                Element top = deque.getFirst();

                String endingTagForTopElement = top.getEndingTag();
                int endingTagForTopElementLength = endingTagForTopElement.length();

                if (html.regionMatches(index, endingTagForTopElement, 0, endingTagForTopElementLength)) {

                    top.setEndOfElement(index);

                    if (!top.isSelfClosing()) {
                        top.setInnerHTML(html.substring(top.getIndexOfEndOfStartingTag(), index));
                    }


                    elementMap.computeIfAbsent(top.getType(), key -> new ArrayList<>()).add(top);

                    deque.pop();

                }


            }


            index++;

        }


    }

}


