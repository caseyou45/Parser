package Classes;

import BaseClasses.Elements;
import BaseClasses.NonSelfClosingTag;

public class Title extends NonSelfClosingTag {


    public Title() {
        super("<title", "</title>", Elements.TITLE);
    }


    @Override
    public void setAttributes(String unparsedAttributes) {

    }


}
