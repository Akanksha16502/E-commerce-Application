package com.handloomstore.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductCategory")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column
    private String categoryName;

    
    
    //Mappings
    @OneToMany(fetch = FetchType.EAGER)//one category contains many subcategoies
    @JoinColumn(name = "pc_id")
    private Set<SubCategory> subCategories = new HashSet<>();
	public Set<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


}