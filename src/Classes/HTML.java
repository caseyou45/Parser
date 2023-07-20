package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class HTML extends NonSelfClosingTag {

    public HTML() {
        super(HtmlTag.HTML.getOpeningTag(), HtmlTag.HTML.getClosingTag(), HtmlTag.HTML);
    }


}