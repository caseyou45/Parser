package Services;

import BaseClasses.Element;
import Classes.Image;
import Classes.ImageDTO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImageAnalysis {

    private final List<Element> images;
    private final List<String> terms;
    private final String baseURL;
    private final String pageURL;
    private final Set<ImageDTO> imageDTOS;

    public ImageAnalysis(List<Element> images, String termsAsString, String baseURL, String pageURL) {
        this.images = images;
        this.terms = convertTermsStringToArrayList(termsAsString);
        this.baseURL = baseURL;
        this.pageURL = pageURL;
        this.imageDTOS = new HashSet<>();

        findImagesThatFitTerms();
    }

    private void findImagesThatFitTerms() {
        for (Element el : images) {
            Image im = (Image) el;
            for (String val : el.getAttributes().values()) {
                for (String term : terms) {
                    if (val.toLowerCase().contains(term.toLowerCase())) {
                        ImageDTO imageDTO = new ImageDTO();
                        imageDTO.setBaseURL(baseURL);
                        imageDTO.setPageURL(baseURL);
                        imageDTO.setPageURL(pageURL);
                        imageDTO.setSrc(cleanUpURL(im.getSrc(), baseURL));
                        imageDTO.setAlt(im.getAlt());
                        imageDTOS.add(imageDTO);


                    }
                }

            }
        }
    }

    private List<String> convertTermsStringToArrayList(String words) {
        return Arrays.asList(words.toLowerCase().split(" "));
    }

    public Set<ImageDTO> getImageDTOS() {
        return imageDTOS;
    }

    private String cleanUpURL(String baseURL, String newURL) {
        newURL = newURL.replace("\"", "");

        boolean baseEnd = baseURL.endsWith("/");
        boolean newStart = newURL.startsWith("/");


        if (newURL.startsWith(baseURL)) {
            return newURL;
        }

        if (baseEnd && newStart) {
            return baseURL.substring(0, baseURL.length() - 1) + newURL;
        }

        if (baseEnd || newStart) {
            return baseURL + newURL;
        }

        return baseURL + "/" + newURL;


    }


}
