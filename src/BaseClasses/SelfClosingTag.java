package BaseClasses;

import Services.HTMLAttributeProcessor;

import java.util.HashMap;
import java.util.Map;

public abstract class SelfClosingTag implements Element {

    private final boolean isSelfClosing = true;
    private final String startingTag;
    private final String endingTag;
    private final HtmlTag type;
    protected Map<HtmlAttribute, String> attributes;
    private int startOfElement;
    private int endOfElement;
    private int indexOfEndOfStartingTag;
    private String innerHTML;


    public SelfClosingTag(String startingTag, String endingTag, HtmlTag type) {
        this.attributes = new HashMap<>();
        this.startingTag = startingTag;
        this.endingTag = endingTag;
        this.type = type;
    }

    public HtmlTag getType() {
        return type;
    }

    public int getStartingTagLength() {
        return startingTag.length();
    }

    public int getEndingTagLength() {
        return endingTag.length();
    }

    public String getStartingTag() {
        return startingTag;
    }

    public String getEndingTag() {
        return endingTag;
    }

    public String getInnerHTML() {
        return innerHTML;
    }

    public void setInnerHTML(String innerHTML) {
        this.innerHTML = innerHTML;
    }

    public int getIndexOfEndOfStartingTag() {
        return indexOfEndOfStartingTag;
    }

    public void setIndexOfEndOfStartingTag(int indexOfEndOfStartingTag) {
        this.indexOfEndOfStartingTag = indexOfEndOfStartingTag;
    }

    public boolean isSelfClosing() {
        return isSelfClosing;
    }

    public int getStartOfElement() {
        return startOfElement;
    }

    public void setStartOfElement(int startOfElement) {
        this.startOfElement = startOfElement;
    }

    public int getEndOfElement() {
        return endOfElement;
    }

    public void setEndOfElement(int endOfElement) {
        this.endOfElement = endOfElement;
    }


    public Map<HtmlAttribute, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(String unparsedAttributes) {
        this.attributes = HTMLAttributeProcessor.parseStringToAttributeHashMap(unparsedAttributes);
    }


}
