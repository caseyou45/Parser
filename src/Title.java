public class Title extends NonSelfClosingTag {

    private final String startingTag = "<title";
    private final String endingTag = "</title>";
    private final boolean isSelfClosing = false;
    private final Elements type = Elements.TITLE;


    public Title() {
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
