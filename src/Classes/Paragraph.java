package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class Paragraph extends NonSelfClosingTag {

    public Paragraph() {
        super(HtmlTag.P.getOpeningTag(), HtmlTag.P.getClosingTag(), HtmlTag.P);
    }


}
