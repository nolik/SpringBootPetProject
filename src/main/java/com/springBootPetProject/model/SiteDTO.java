package com.springBootPetProject.model;

/**
 * Created by nolik on 22.03.17.
 */

public class SiteDTO {
//    {
//        "favicon_url": "https://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
//            "audience": "professional and enthusiast programmers",
//            "site_url": "http://stackoverflow.com",
//            "name": "Stack Overflow"
//    }

    private String favicon_url;
    private String audience;
    private String site_url;
    private String name;

    public SiteDTO(String favicon_url, String audience, String site_url, String name) {
        this.favicon_url = favicon_url;
        this.audience = audience;
        this.site_url = site_url;
        this.name = name;
    }

    public SiteDTO() {
    }

    public String getFavicon_url() {
        return favicon_url;
    }

    public void setFavicon_url(String favicon_url) {
        this.favicon_url = favicon_url;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
