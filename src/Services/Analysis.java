package Services;

import BaseClasses.Element;
import BaseClasses.HtmlTag;
import Classes.Image;

import java.util.*;

public class Analysis {

    private final Map<HtmlTag, List<Element>> parentElementMap;
    private final List<String> terms;


    public Analysis(Map<HtmlTag, List<Element>> parentElementMap, String terms) {
        this.parentElementMap = parentElementMap;
        this.terms = convertTermsStringToList(terms);

        analysis();
    }

    private List<String> convertTermsStringToList(String words) {
        List<String> terms = new ArrayList<>();
        for (String element : words.toLowerCase().split(" ")) {
            terms.add(element);
        }
        return terms;
    }


    private void analysis() {


    }


}
