package Classes;

import BaseClasses.Elements;
import BaseClasses.NonSelfClosingTag;

import java.util.Map;

public class Body extends NonSelfClosingTag {
    
    private String lang;


    public Body() {
        super("<body", "</body>", Elements.BODY);
    }


    @Override
    public void setAttributes(String unparsedAttributes) {
        super.unparsedAttributesToAttributeHashMap(unparsedAttributes);

        Map<String, String> att = super.getAttributes();

    }

}
