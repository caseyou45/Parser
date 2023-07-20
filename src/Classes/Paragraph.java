package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class Paragraph extends NonSelfClosingTag {

    public Paragraph() {
        super(HtmlTag.PARAGRAPH.getOpeningTag(), HtmlTag.PARAGRAPH.getClosingTag(), HtmlTag.PARAGRAPH);
    }


}
