import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Parser {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/files/ou.html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }

        String content = contentBuilder.toString();
        long endTime = System.currentTimeMillis();

        System.out.println("Read in file time: " + (endTime - startTime));

        Map<Elements, List<Element>> elementMap = new HashMap<>();


        startTime = System.currentTimeMillis();

        elementFinder(content, elementMap);

        endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime));


    }


    private static void elementFinder(String html, Map<Elements, List<Element>> elementMap) {
        Deque<Element> deque = new LinkedList<>();

        int index = 0;

        int end = html.length();

        ElementFactory elementFactory = new ElementFactory();
        Element el = null;
        while (index < end) {

            if ((el = elementFactory.getElement(html.substring(index))) != null) {
                el.setStartOfElement(index);

                deque.addFirst(el);

                int indexOfEndOfStartingTag;

                if (el.isSelfClosing()) {
                    indexOfEndOfStartingTag = html.indexOf(el.getEndingTag(), index);
                } else {
                    indexOfEndOfStartingTag = html.indexOf(">", index);

                }

                if ((indexOfEndOfStartingTag - index) > el.getStartingTagLength()) {
                    el.setAttributes(html.substring(index, indexOfEndOfStartingTag));
                }

                el.setIndexOfEndOfStartingTag(indexOfEndOfStartingTag);


            } else if (deque.size() > 0) {
                Element top = deque.getFirst();
                
                if (html.substring(index).startsWith(top.getEndingTag())) {

                    top.setEndOfElement(index);

                    if (!top.isSelfClosing()) {
                        top.setInnerHTML(html.substring(top.getIndexOfEndOfStartingTag(), top.getEndOfElement()));
                    }


                    elementMap.putIfAbsent(top.getType(), new ArrayList<>());
                    List<Element> e = elementMap.get(top.getType());
                    e.add(top);
                    elementMap.put(top.getType(), e);

                    deque.pop();

                }


            }


            index++;

        }


    }

}


class ElementFactory {
    public Element getElement(String html) {
        if (html.startsWith("<html")) {
            return new HTML();

        } else if (html.startsWith("<head")) {
            return new Head();

        } else if (html.startsWith("<meta")) {
            return new Meta();

        } else if (html.startsWith("<title")) {
            return new Title();

        } else if (html.startsWith("<body")) {
            return new Body();

        } else if (html.startsWith("<p")) {
            return new P();

        } else if (html.startsWith("<img")) {
            return new Img();
        }

        return null;
    }

}


