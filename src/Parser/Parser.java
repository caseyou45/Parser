package Parser;

import BaseClasses.Element;
import BaseClasses.Elements;
import Services.ElementFactory;
import Services.ElementFactory2;

import java.util.*;

public class Parser {
    private final String baseURL;
    private final String pageURL;
    private final String html;
    private final Map<Elements, List<Element>> elementMap;


    public Parser(String html, String baseURL, String pageURL) {
        this.baseURL = baseURL;
        this.pageURL = pageURL;
        this.html = html;
        this.elementMap = new HashMap<>();

        go();
    }


    private void go() {
        elementFinder(html, elementMap);
    }


    public Map<Elements, List<Element>> getElementMap() {
        return elementMap;
    }

    private void elementFinder(String html, Map<Elements, List<Element>> elementMap) {
        Deque<Element> deque = new LinkedList<>();

        int index = 0;

        int end = html.length();


        ElementFactory elementFactory = new ElementFactory();
        ElementFactory2 elementFactory2 = new ElementFactory2();

        Element el = null;

        long startTime = System.currentTimeMillis();

        while (index < end) {


            if (html.charAt(index) == '<' && (el = elementFactory2.getElement(html.substring(index))) != null) {
                el.setStartOfElement(index);

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
                        top.setInnerHTML(html.substring(top.getIndexOfEndOfStartingTag(), top.getEndOfElement()));
                    }


                    elementMap.computeIfAbsent(top.getType(), key -> new ArrayList<>()).add(top);

                    deque.pop();

                }


            }


            index++;

        }

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");

    }

}


