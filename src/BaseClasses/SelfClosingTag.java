package BaseClasses;

import java.util.*;

public abstract class SelfClosingTag implements Element {

    private final Map<String, String> attributes;
    private final boolean isSelfClosing = true;
    private final String startingTag;
    private final String endingTag;
    private final Elements type;
    private int startOfElement;
    private int endOfElement;
    private int indexOfEndOfStartingTag;
    private String innerHTML;

    public SelfClosingTag(String startingTag, String endingTag, Elements type) {
        this.attributes = new HashMap<>();
        this.startingTag = startingTag;
        this.endingTag = endingTag;
        this.type = type;
    }

    public Elements getType() {
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

    public Map<String, String> getAttributes() {
        return attributes;
    }

    abstract public void setAttributes(String unparsedAttributes);

    public void unparsedAttributesToAttributeHashMap(String unparsedAttributes) {
        unparsedAttributes = unparsedAttributes.trim();


        int start = 0;
        int index = 1;
        while (index < unparsedAttributes.length()) {
            if (unparsedAttributes.charAt(index) == ' ' && unparsedAttributes.charAt(index - 1) == '\"') {

                String sub = unparsedAttributes.substring(start, index);
                if (sub.contains("=")) {
                    String[] split = sub.split("=");
                    attributes.put(split[0], split[1]);
                }
                start = index + 1;
            }
            index++;
        }

        if (unparsedAttributes.substring(start).contains("=")) {
            String[] split = unparsedAttributes.substring(start).split("=");
            String k = split[0];
            String v = split[1];

            attributes.put(k, v);
        }


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


}
