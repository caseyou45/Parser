package Classes;

import BaseClasses.Elements;
import BaseClasses.NonSelfClosingTag;

public class Paragraph extends NonSelfClosingTag {


    public Paragraph() {
        super("<p", "</p>", Elements.PARAGRAPH);
    }


    @Override
    public void setAttributes(String unparsedAttributes) {

    }


}
