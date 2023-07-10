package com.bitsmart.demo1.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="category")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category_name")
	private @NotBlank String categoryName;
	
	@Column(name = "category_desc")
	private @NotBlank String desc;
    
	@Column(name="image_url")
	private @NotBlank String imageUrl;
	


	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDesc() {
		return desc;
	}

	
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "User {category id=" + id + ", category name='" + categoryName + "', desc='" + desc + "'}";
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
