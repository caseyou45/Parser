import java.util.HashMap;
import java.util.Map;

class Img implements Element {

    private final String startingTag = "<img";
    private final String endingTag = ">";
    private final boolean selfClosing = true;
    private final Map<String, String> attributes;
    private final Elements type = Elements.IMG;

    private int startOfElement;
    private int endOfElement;
    private int indexOfEndOfStartingTag;
    private String innerHTML;
    private String src;
    private String alt;

    public Img() {
        this.attributes = new HashMap<>();
    }

    public String getInnerHTML() {
        return innerHTML;
    }

    public void setInnerHTML(String innerHTML) {
        this.innerHTML = innerHTML;
    }

    @Override
    public Elements getType() {
        return type;
    }

    public int getIndexOfEndOfStartingTag() {
        return indexOfEndOfStartingTag;
    }

    public void setIndexOfEndOfStartingTag(int indexOfEndOfStartingTag) {
        this.indexOfEndOfStartingTag = indexOfEndOfStartingTag;
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


    public boolean isSelfClosing() {
        return selfClosing;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(String unparsedAttributes) {
        unparsedAttributes = unparsedAttributes.trim();

        String[] splitOnSpace = unparsedAttributes.split(" ");
        for (String singleAttribute : splitOnSpace) {
            String[] kvPairFromAttribute = singleAttribute.trim().split("=");
            if (kvPairFromAttribute.length == 2) {
                attributes.put(kvPairFromAttribute[0].trim(), kvPairFromAttribute[1].trim());
            }

        }

        if (attributes.containsKey("src")) {
            setSrc(attributes.get("src"));
        }

        if (attributes.containsKey("alt")) {
            setAlt(attributes.get("alt"));
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

    @Override
    public String toString() {
        return "Element{" +
                "startingTag='" + startingTag + '\'' +
                ", endingTag='" + endingTag + '\'' +
                ", attributes=" + attributes +
                ", selfClosing=" + selfClosing +
                ", startOfElement=" + startOfElement +
                ", endOfElement=" + endOfElement +
                '}';
    }

    
}

