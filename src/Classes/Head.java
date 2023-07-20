package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class Head extends NonSelfClosingTag {


    public Head() {
        super(HtmlTag.HEAD.getOpeningTag(), HtmlTag.HEAD.getClosingTag(), HtmlTag.HEAD);
    }

}