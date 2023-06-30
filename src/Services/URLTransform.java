package Services;

public class URLTransform {
    private static final String[] tlds = {".com", ".net", ".org", ".gov", ".edu", ".mil", ".int", ".arpa", ".aero", ".biz", ".coop", ".museum", ".name", ".pro", ".travel", ".jobs", ".mobi", ".cat", ".asia", ".tel", ".xxx"};

    private static String removeSlashAndQuotes(String url) {
        if (url.isEmpty()) {
            return "";
        }

        int i = 0;
        int j = url.length() - 1;

        while (i < url.length() && (url.charAt(i) == '/' || url.charAt(i) == '\"' || url.charAt(i) == '\"')) {
            i++;
        }
        while (j > 0 && (url.charAt(j) == '/' || url.charAt(j) == '\"' || url.charAt(j) == '\"')) {
            j--;
        }

        if (j >= 0 && i < url.length() - 1) {
            return url.substring(i, j + 1);
        }
        return url;

    }

    public static String cleanUpURL(String baseURL, String newURL) {
        if (newURL == null || baseURL.isEmpty() || newURL.isEmpty() || newURL.contains("mailto")) {
            return "";
        }


        if (!isAtLeastHTTP(baseURL)) {
            throw new IllegalArgumentException("Malformed Base URL (Domain)");
        }

        baseURL = removeSlashAndQuotes(baseURL);
        newURL = removeSlashAndQuotes(newURL);

        String domain = getOnlyDomain(baseURL);

        if (newURL.contains(domain)) {
            return newURL;
        }


        if (isAnExternalSite(newURL)) {
            return "";
        }


        return baseURL + "/" + newURL;
    }

    private static boolean isAnExternalSite(String url) {

        for (String tld : tlds) {
            if (url.contains(tld)) {
                return true;
            }
        }

        return false;


    }

    private static boolean isAtLeastHTTP(String url) {
        return url.startsWith("http");
    }

    private static String getOnlyDomain(String url) {
        int www = url.indexOf("www");

        if (www == -1) {
            throw new IllegalArgumentException("Malformed Base URL");
        }

        return url.substring(www + 4);


    }

}
