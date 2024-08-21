package com.example.autoframework.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentsResponse {

	private List<Department> departments;
    private List<Landing> landings;
    private MoreCategories more_categories;
    private List<HighPriority> high_priority;

    // Getters and Setters
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Landing> getLandings() {
        return landings;
    }

    public void setLandings(List<Landing> landings) {
        this.landings = landings;
    }

    public MoreCategories getMoreCategories() {
        return more_categories;
    }

    public void setMoreCategories(MoreCategories more_categories) {
        this.more_categories = more_categories;
    }

    public List<HighPriority> getHighPriority() {
        return high_priority;
    }

    public void setHighPriority(List<HighPriority> high_priority) {
        this.high_priority = high_priority;
    }
}

