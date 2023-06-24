public class P extends NonSelfClosingTag {
    private final String startingTag = "<p";
    private final String endingTag = "</p>";
    private final boolean isSelfClosing = false;
    private final Elements type = Elements.P;

    public P() {
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

    }

    @Override
    public Elements getType() {
        return type;
    }

}
