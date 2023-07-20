package Services;


import BaseClasses.HtmlAttribute;
import BaseClasses.HtmlTag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HtmlConfigParser {
    private final List<HtmlTag> tags;
    private final List<HtmlAttribute> attributes;

    public HtmlConfigParser() {
        tags = new ArrayList<>();
        attributes = new ArrayList<>();
        parseConfigFile();
    }

    private void parseConfigFile() {


        try (BufferedReader reader = new BufferedReader(new FileReader("config.txt"))) {
            String line;
            boolean isTagSection = false;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    if (line.startsWith("# Uncomment the elements you want to include")) {
                        isTagSection = true;
                        continue;
                    } else if (line.startsWith("# Uncomment the attributes you want to include")) {
                        isTagSection = false;
                        continue;
                    }
                    if (isTagSection) {
                        try {
                            HtmlTag tag = HtmlTag.valueOf(line);
                            tags.add(tag);
                        } catch (IllegalArgumentException e) {
                        }
                    } else {
                        try {
                            HtmlAttribute attribute = HtmlAttribute.valueOf(line);
                            attributes.add(attribute);
                        } catch (IllegalArgumentException e) {
                        }
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public List<HtmlTag> getTags() {
        return tags;
    }

    public List<HtmlAttribute> getAttributes() {
        return attributes;
    }


}

