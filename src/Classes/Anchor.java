package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class Anchor extends NonSelfClosingTag {


    public Anchor() {
        super(HtmlTag.ANCHOR.getOpeningTag(), HtmlTag.ANCHOR.getClosingTag(), HtmlTag.ANCHOR);
    }


}
