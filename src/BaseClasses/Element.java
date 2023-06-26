package BaseClasses;

import java.util.Map;

public interface Element {

    int getStartingTagLength();

    int getEndingTagLength();

    String getStartingTag();

    String getEndingTag();

    boolean isSelfClosing();

    Map<String, String> getAttributes();

    void setAttributes(String text);

    int getStartOfElement();

    void setStartOfElement(int startOfElement);

    int getEndOfElement();

    void setEndOfElement(int endOfElement);

    int getIndexOfEndOfStartingTag();

    void setIndexOfEndOfStartingTag(int indexOfEndOfStartingTag);

    String getInnerHTML();

    void setInnerHTML(String innerHTML);

    Elements getType();


}
