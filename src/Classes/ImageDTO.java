package Classes;

import java.util.Objects;

public class ImageDTO {

    private String src;
    private String alt;
    private String baseURL;
    private String pageURL;
    private String dateAccessed;
    private String dateCreated;


    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getDateAccessed() {
        return dateAccessed;
    }

    public void setDateAccessed(String dateAccessed) {
        this.dateAccessed = dateAccessed;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageDTO imageDTO = (ImageDTO) o;
        return Objects.equals(src, imageDTO.src) && Objects.equals(alt, imageDTO.alt) && Objects.equals(baseURL, imageDTO.baseURL) && Objects.equals(pageURL, imageDTO.pageURL) && Objects.equals(dateAccessed, imageDTO.dateAccessed) && Objects.equals(dateCreated, imageDTO.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, alt, baseURL, pageURL, dateAccessed, dateCreated);
    }
}
