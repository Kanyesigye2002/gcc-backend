package com.thecodeveal.app.gcc.dto;

import com.thecodeveal.app.gcc.Models.GalleryCategory;

public class GalleryRequest {

    private GalleryCategory galleryCategory;

    public GalleryRequest() {
    }

    public GalleryRequest(GalleryCategory galleryCategory) {
        this.galleryCategory = galleryCategory;
    }

    public GalleryCategory getGalleryCategory() {
        return galleryCategory;
    }

    public void setGalleryCategory(GalleryCategory galleryCategory) {
        this.galleryCategory = galleryCategory;
    }

    @Override
    public String toString() {
        return "GalleryRequest{" +
                "galleryCategory=" + galleryCategory +
                '}';
    }
}
