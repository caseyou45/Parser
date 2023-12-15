package Services;

import BaseClasses.Element;
import BaseClasses.HtmlAttribute;
import BaseClasses.HtmlTag;
import File.FileHandler;

import java.io.File;
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

        FileHandler.createFile("result.txt");

        StringBuilder stringBuilder = new StringBuilder();

        for (HtmlTag htmlTag : tags) {
            stringBuilder.append("Element: " + htmlTag.getOpeningTag());
            stringBuilder.append("\n\n");
            for (Element element : parentElementMap.get(htmlTag)) {
                for (HtmlAttribute htmlAttribute : attributes) {
                    if (element.getAttributes().get(htmlAttribute) != null) {
                        stringBuilder.append("\t\t" + element.getPageURL());
                        stringBuilder.append("\n");
                        stringBuilder.append("\t\t" + htmlAttribute + ": " + element.getAttributes().get(htmlAttribute));
                        stringBuilder.append("\n\n");
                    }
                }
            }

        }

        FileHandler.appendToFile("result.txt", stringBuilder.toString());


    }


}
