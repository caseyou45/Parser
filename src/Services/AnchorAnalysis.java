package Services;

import BaseClasses.Element;
import BaseClasses.HtmlAttribute;
import Classes.Anchor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnchorAnalysis {


    private final List<Element> anchorElements;
    private final Set<String> anchorHrefs;

    private final String baseURL;

    public AnchorAnalysis(String baseURL, List<Element> anchorElements) {
        this.anchorHrefs = new HashSet<>();
        this.anchorElements = anchorElements;
        this.baseURL = baseURL;


        findAnchorTagsAndCleanUp();

    }


    public Set<String> getAnchorHrefs() {
        return anchorHrefs;
    }

    private void findAnchorTagsAndCleanUp() {
        if (anchorElements.size() == 0 || anchorElements == null)
            return;

        for (Element el : anchorElements) {
            Anchor anchor = (Anchor) el;

            anchorHrefs.add(URLTransform.cleanUpURL(baseURL, anchor.getAttributes().get(HtmlAttribute.HREF)));
        }
    }


}
