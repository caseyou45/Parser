package Classes;

import BaseClasses.Elements;
import BaseClasses.SelfClosingTag;

import java.util.Map;

public class Image extends SelfClosingTag {


    private String src;
    private String alt;

    public Image() {
        super("<img", ">", Elements.IMAGE);
    }


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


    @Override
    public void setAttributes(String unparsedAttributes) {
        super.unparsedAttributesToAttributeHashMap(unparsedAttributes);

        Map<String, String> att = super.getAttributes();

        if (att.containsKey("src")) {
            setSrc(att.get("src"));
        }

        if (att.containsKey("alt")) {
            setAlt(att.get("alt"));
        }

    }


}

