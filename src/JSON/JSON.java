package JSON;

import Classes.ImageDTO;

import java.util.Collection;


public class JSON {

    Collection<ImageDTO> collection;
    StringBuilder stringBuilder;

    public JSON(Collection<ImageDTO> collection) {
        this.collection = collection;
        stringBuilder = new StringBuilder();
        run();
    }

    private void run() {


        stringBuilder.append("[");


        int i = 0;
        for (ImageDTO element : collection) {


            stringBuilder
                    .append("{\"src\":\"").append(getValueOfQuotesIfNull(element.getSrc())).append("\",\n")
                    .append("\"alt\":").append(getValueOfQuotesIfNull(element.getAlt())).append(",\n")
                    .append("\"baseURL\":\"").append(getValueOfQuotesIfNull(element.getBaseURL())).append("\",\n")
                    .append("\"pageURL\":\"").append(getValueOfQuotesIfNull(element.getPageURL())).append("\"\n")
                    .append("}");

            if (i++ < collection.size() - 1)
                stringBuilder.append(",\n");

        }

        stringBuilder.append("]");
    }


    private String getValueOfQuotesIfNull(String val) {
        if (val == null) return "";
        return val;
    }

    public String getString() {
        return stringBuilder.toString();
    }
}
