package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class Div extends NonSelfClosingTag {


    public Div() {
        super(HtmlTag.DIV.getOpeningTag(), HtmlTag.DIV.getClosingTag(), HtmlTag.DIV);
    }


}
