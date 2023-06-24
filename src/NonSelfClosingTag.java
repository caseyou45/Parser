import java.util.HashMap;
import java.util.Map;

abstract class NonSelfClosingTag implements Element {

    private final Map<String, String> attributes;
    private int startOfElement;
    private int endOfElement;
    private int indexOfEndOfStartingTag;
    private String innerHTML;

    public NonSelfClosingTag() {
        this.attributes = new HashMap<>();
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

    public abstract int getStartingTagLength();

    public abstract int getEndingTagLength();

    public abstract String getStartingTag();

    public abstract String getEndingTag();


    public abstract boolean isSelfClosing();


    public Map<String, String> getAttributes() {
        return attributes;
    }


    abstract public void setAttributes(String unparsedAttributes);

    public void unparsedAttributesToAttributeHashMap(String unparsedAttributes) {
        unparsedAttributes = unparsedAttributes.trim();

        String[] splitOnSpace = unparsedAttributes.split(" ");
        for (String singleAttribute : splitOnSpace) {
            String[] kvPairFromAttribute = singleAttribute.trim().split("=");
            if (kvPairFromAttribute.length == 2) {
                attributes.put(kvPairFromAttribute[0].trim(), kvPairFromAttribute[1].trim());
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

    public abstract Elements getType();

}
