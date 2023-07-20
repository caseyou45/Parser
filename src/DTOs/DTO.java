package DTOs;

import BaseClasses.HtmlTag;

public interface DTO {
    String getBaseURL();

    void setBaseURL(String url);

    HtmlTag getElement();

    String getPageURL();

    void setPageURL(String pageURL);

    String getDateAccessed();

    void setDateAccessed(String dateAccessed);

    String getDateCreated();

    void setDateCreated(String dateCreated);
}
