package com.springBootPetProject.model;

import java.util.List;

/**
 * Created by nolik on 22.03.17.
 */

public class SitesDTO {
    private List<SiteDTO> items;

    public SitesDTO() {
    }

    public SitesDTO(List<SiteDTO> items) {
        this.items = items;
    }

    public List<SiteDTO> getItems() {
        return items;
    }

    public void setItems(List<SiteDTO> items) {
        this.items = items;
    }
}
