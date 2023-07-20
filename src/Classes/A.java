package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class A extends NonSelfClosingTag {


    public A() {
        super(HtmlTag.A.getOpeningTag(), HtmlTag.A.getClosingTag(), HtmlTag.A);
    }


}
