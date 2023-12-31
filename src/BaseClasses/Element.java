package BaseClasses;

import java.util.Map;

public interface Element {

    int getStartingTagLength();

    void setPageURL(String url);

    String getPageURL();

    int getEndingTagLength();

    String getStartingTag();

    String getEndingTag();

    boolean isSelfClosing();

    Map<HtmlAttribute, String> getAttributes();

    void setAttributes(String text);

    int getStartOfElement();

    void setStartOfElement(int startOfElement);

    int getEndOfElement();

    void setEndOfElement(int endOfElement);

    int getIndexOfEndOfStartingTag();

    void setIndexOfEndOfStartingTag(int indexOfEndOfStartingTag);

    String getInnerHTML();

    void setInnerHTML(String innerHTML);

    HtmlTag getType();


}
