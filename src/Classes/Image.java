package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.SelfClosingTag;

public class Image extends SelfClosingTag {

    public Image() {
        super(HtmlTag.IMAGE.getOpeningTag(), HtmlTag.IMAGE.getClosingTag(), HtmlTag.IMAGE);
    }

}

