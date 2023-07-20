package Services;

import BaseClasses.HtmlAttribute;

import java.util.HashMap;
import java.util.Map;

public class HTMLAttributeProcessor {
    private static final Map<String, HtmlAttribute> attributeStringToEnum = new HashMap<>();

    private static void loadHashMap() {
        for (HtmlAttribute htmlAttr : HtmlAttribute.values()) {
            attributeStringToEnum.put(htmlAttr.getAttribute(), htmlAttr);
        }

    }

    public static Map<HtmlAttribute, String> parseStringToAttributeHashMap(String unparsedAttributes) {

        if (attributeStringToEnum.isEmpty()) {
            loadHashMap();
        }

        Map<HtmlAttribute, String> attributes = new HashMap<>();

        unparsedAttributes = unparsedAttributes.trim();


        int start = 0;
        int index = 1;
        while (index < unparsedAttributes.length()) {
            if (unparsedAttributes.charAt(index) == ' ' && unparsedAttributes.charAt(index - 1) == '\"') {

                String sub = unparsedAttributes.substring(start, index);
                if (sub.contains("=")) {
                    String[] split = sub.split("=");
                    attributes.put(attributeStringToEnum.get(split[0]), split[1]);

                }
                start = index + 1;
            }
            index++;
        }

        if (unparsedAttributes.substring(start).contains("=")) {
            String[] split = unparsedAttributes.substring(start).split("=");
            attributes.put(attributeStringToEnum.get(split[0]), split[1]);

        }

        System.out.println(attributes);

        return attributes;

    }
}
