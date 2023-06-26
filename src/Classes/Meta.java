package Classes;

import BaseClasses.Elements;
import BaseClasses.SelfClosingTag;

import java.util.Map;

public class Meta extends SelfClosingTag {


    public Meta() {
        super("<meta", ">", Elements.META);
    }


    @Override
    public void setAttributes(String unparsedAttributes) {
        super.unparsedAttributesToAttributeHashMap(unparsedAttributes);

        Map<String, String> att = super.getAttributes();

    }


}
