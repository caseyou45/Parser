package Services;

import BaseClasses.Element;
import BaseClasses.Elements;
import Classes.Anchor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnchorAnalysis {


    private final List<Element> anchorElements;
    private final Set<String> anchorHrefs;
    private final String[] tlds = {".com", ".net", ".org", ".gov", ".edu", ".mil", ".int", ".arpa", ".aero", ".biz", ".coop", ".museum", ".name", ".pro", ".travel", ".jobs", ".mobi", ".cat", ".asia", ".tel", ".xxx"};

    private final String baseURL;

    public AnchorAnalysis(String baseURL, List<Element> anchorElements) {
        this.anchorHrefs = new HashSet<>();
        this.anchorElements = anchorElements;
        this.baseURL = baseURL;

        findAnchorTagsAndCleanUp();

    }


    private static String removeSlashAndQuotes(String url) {
        int i = 0;
        int j = url.length() - 1;

        while (url.charAt(i) == '/' || url.charAt(i) == '\"' || url.charAt(i) == '\"') {
            i++;
        }
        while (url.charAt(j) == '/' || url.charAt(j) == '\"' || url.charAt(j) == '\"') {
            j--;
        }

        return url.substring(i, j + 1);

    }

    private String cleanUpURL(String baseURL, String newURL) {
        if (newURL == null || newURL.isEmpty()) {
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

    private boolean isAnExternalSite(String url) {
        int locationOfDot = url.indexOf('.');

        if (locationOfDot == -1) {
            return false;
        }

        String theFrontFellOff = url.substring(locationOfDot + 1);

        return !theFrontFellOff.startsWith("html");


    }

    private boolean isAtLeastHTTP(String url) {
        return url.startsWith("http");
    }

    private String getOnlyDomain(String url) {
        int www = url.indexOf("www");

        if (www == -1) {
            throw new IllegalArgumentException("Malformed Base URL");
        }

        return url.substring(www + 4);


    }

    public Set<String> getAnchorHrefs() {
        return anchorHrefs;
    }

    private void findAnchorTagsAndCleanUp() {
        for (Element el : anchorElements) {
            Anchor anchor = (Anchor) el;
            anchorHrefs.add(cleanUpURL(baseURL, anchor.getHref()));
        }
    }


}
