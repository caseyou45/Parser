package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class Body extends NonSelfClosingTag {


    public Body() {
        super(HtmlTag.BODY.getOpeningTag(), HtmlTag.BODY.getClosingTag(), HtmlTag.BODY);
    }


}
