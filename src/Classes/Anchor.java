package Classes;

import BaseClasses.Elements;
import BaseClasses.NonSelfClosingTag;

import java.util.Map;

public class Anchor extends NonSelfClosingTag {

    private String href;

    public Anchor() {
        super("<a", "</a>", Elements.ANCHOR);
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    @Override
    public void setAttributes(String unparsedAttributes) {
        super.unparsedAttributesToAttributeHashMap(unparsedAttributes);

        Map<String, String> att = super.getAttributes();

        if (att.containsKey("href")) {
            setHref(att.get("href"));
        }

    }

}
