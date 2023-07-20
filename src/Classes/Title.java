package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.NonSelfClosingTag;

public class Title extends NonSelfClosingTag {

    public Title() {
        super(HtmlTag.TITLE.getOpeningTag(), HtmlTag.TITLE.getClosingTag(), HtmlTag.TITLE);
    }


}
