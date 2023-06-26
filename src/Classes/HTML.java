package Classes;

import BaseClasses.Elements;
import BaseClasses.NonSelfClosingTag;

import java.util.Map;

public class HTML extends NonSelfClosingTag {
    

    public HTML() {
        super("<html", "</html>", Elements.HTML);
    }


    @Override
    public void setAttributes(String unparsedAttributes) {
        super.unparsedAttributesToAttributeHashMap(unparsedAttributes);

        Map<String, String> att = super.getAttributes();

    }


}