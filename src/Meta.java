import java.util.HashMap;
import java.util.Map;

class Meta implements Element {

    private final String startingTag = "<meta";
    private final String endingTag = "/>";
    private final boolean selfClosing = true;
    private final Map<String, String> attributes;
    private final Elements type = Elements.META;
    private int startOfElement;
    private int endOfElement;
    private int indexOfEndOfStartingTag;
    private String innerHTML;

    public Meta() {
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


    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(String unparsedAttributes) {
        unparsedAttributes = unparsedAttributes.trim();

        String[] splitOnSpace = unparsedAttributes.split(" ");
        for (String singleAttribute : splitOnSpace) {
            String[] kvPairFromAttrb = singleAttribute.trim().split("=");
            if (kvPairFromAttrb.length == 2) {
                attributes.put(kvPairFromAttrb[0].trim(), kvPairFromAttrb[1].trim());
            }

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
