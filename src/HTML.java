import java.util.Map;

public class HTML extends NonSelfClosingTag {

    private final boolean isSelfClosing = false;
    private final String startingTag = "<html";
    private final String endingTag = "</html>";
    private final Elements type = Elements.HTML;

    public HTML() {
        super();
    }

    @Override
    public int getStartingTagLength() {
        return startingTag.length();
    }

    @Override
    public int getEndingTagLength() {
        return endingTag.length();
    }

    @Override
    public String getStartingTag() {
        return startingTag;
    }

    @Override
    public String getEndingTag() {
        return endingTag;
    }

    @Override
    public boolean isSelfClosing() {
        return isSelfClosing;
    }

    @Override
    public void setAttributes(String unparsedAttributes) {
        super.unparsedAttributesToAttributeHashMap(unparsedAttributes);

        Map<String, String> att = super.getAttributes();

    }

    @Override
    public Elements getType() {
        return type;
    }


}