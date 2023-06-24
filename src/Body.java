import java.util.Map;

class Body extends NonSelfClosingTag {

    private final String startingTag = "<body";
    private final String endingTag = "</body>";
    private final boolean isSelfClosing = false;
    private final Elements type = Elements.BODY;
    private String lang;


    public Body() {
        super();
    }

    @Override
    public Elements getType() {
        return type;
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

}
