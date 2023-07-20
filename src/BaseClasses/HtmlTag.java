package BaseClasses;


public enum HtmlTag {
    A("<a", "</a>"),
    BODY("<body", "</body>"),
    BR("<br>", ">"),
    BUTTON("<button", "</button>"),
    DIV("<div", "</div>"),
    DOCTYPE("<!DOCTYPE>"),
    FORM("<form", "</form>"),
    H1("<h1", "</h1>"),
    H2("<h2", "</h2>"),
    H3("<h3", "</h3>"),
    H4("<h4", "</h4>"),
    H5("<h5", "</h5>"),
    H6("<h6", "</h6>"),
    HEAD("<head", "</head>"),
    HR("<hr", ">"),
    HTML("<html", "</html>"),
    IMAGE("<img", ">"),
    INPUT("<input", ">"),
    LABEL("<label", "</label>"),
    LI("<li", "</li>"),
    LINK("<link", ">"),
    META("<meta", ">"),
    OL("<ol", "</ol>"),
    OPTION("<option", "</option>"),
    P("<p", "</p>"),
    SCRIPT("<script", "</script>"),
    SELECT("<select", "</select>"),
    SPAN("<span", "</span>"),
    STYLE("<style", "</style>"),
    TABLE("<table", "</table>"),
    TD("<td", "</td>"),
    TEXTAREA("<textarea", "</textarea>"),
    TH("<th", "</th>"),
    TITLE("<title", "</title>"),
    TR("<tr", "</tr>"),
    UL("<ul", "</ul>");

    private final String openingTag;
    private final String closingTag;

    HtmlTag(String openingTag) {
        this(openingTag, null);
    }

    HtmlTag(String openingTag, String closingTag) {
        this.openingTag = openingTag;
        this.closingTag = closingTag;
    }

    public String getOpeningTag() {
        return openingTag;
    }

    public String getClosingTag() {
        return closingTag;
    }
}
