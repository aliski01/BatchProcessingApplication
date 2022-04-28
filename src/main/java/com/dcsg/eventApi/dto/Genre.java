package com.dcsg.eventApi.dto;

public class Genre {
	
    public int id;
    public String name;
    public String slug;
    public boolean primary;
    public Images images;
    public String image;
    public DocumentSource document_source;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public Images getImages() {
		return images;
	}
	public void setImages(Images images) {
		this.images = images;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public DocumentSource getDocument_source() {
		return document_source;
	}
	public void setDocument_source(DocumentSource document_source) {
		this.document_source = document_source;
	}
    
    

}
