package Classes;

import BaseClasses.Elements;
import BaseClasses.NonSelfClosingTag;

public class Head extends NonSelfClosingTag {


    public Head() {
        super("<head", "</head>", Elements.HEAD);
    }


    @Override
    public void setAttributes(String unparsedAttributes) {

    }


}