package BaseClasses;

public enum HtmlAttribute {
    ALT("alt"),
    CHECKED("checked"),
    CLASS("class"),
    DISABLED("disabled"),
    HEIGHT("height"),
    HREF("href"),
    ID("id"),
    MAXLENGTH("maxlength"),
    NAME("name"),
    ONCHANGE("onchange"),
    ONCLICK("onclick"),
    ONMOUSEOUT("onmouseout"),
    ONMOUSEOVER("onmouseover"),
    READONLY("readonly"),
    SELECTED("selected"),
    SRC("src"),
    STYLE("style"),
    TITLE("title"),
    TYPE("type"),
    VALUE("value"),
    WIDTH("width");


    private final String attribute;

    HtmlAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
