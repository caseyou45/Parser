class Head extends NonSelfClosingTag {

    private final String startingTag = "<head";
    private final String endingTag = "</head>";
    private final boolean selfClosing = false;
    private final Elements type = Elements.HEAD;

    public Head() {
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
        return selfClosing;
    }

    @Override
    public void setAttributes(String unparsedAttributes) {

    }

    @Override
    public Elements getType() {
        return type;
    }


}