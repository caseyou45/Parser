package Classes;

import BaseClasses.HtmlTag;
import BaseClasses.SelfClosingTag;

public class Meta extends SelfClosingTag {

    public Meta() {
        super(HtmlTag.META.getOpeningTag(), HtmlTag.META.getClosingTag(), HtmlTag.META);
    }


}
