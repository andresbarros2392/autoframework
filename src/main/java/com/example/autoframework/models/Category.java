package com.example.autoframework.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private String id;
    private String name;
    private String permalink;
    private List<ChildCategory> children_categories;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public List<ChildCategory> getChildrenCategories() {
        return children_categories;
    }

    public void setChildrenCategories(List<ChildCategory> children_categories) {
        this.children_categories = children_categories;
    }
}
