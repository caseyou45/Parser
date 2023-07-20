package Services;

import BaseClasses.Element;
import BaseClasses.HtmlAttribute;
import BaseClasses.HtmlTag;

import java.util.*;

public class Analysis {

    private final Map<HtmlTag, List<Element>> parentElementMap;
    private final HtmlConfigParser htmlConfigParser;

    public Analysis(Map<HtmlTag, List<Element>> parentElementMap, HtmlConfigParser htmlConfigParser, String terms) {
        this.parentElementMap = parentElementMap;
        this.htmlConfigParser = htmlConfigParser;


        analysis();
    }


    private void analysis() {
        List<HtmlTag> tags = htmlConfigParser.getTags();
        List<HtmlAttribute> attributes = htmlConfigParser.getAttributes();

        for (HtmlTag htmlTag : tags) {
            for (Element element : parentElementMap.get(htmlTag)) {
                for (HtmlAttribute htmlAttribute : attributes) {
                    System.out.println(element.getAttributes().get(htmlAttribute));

                }
            }

        }


    }


}
