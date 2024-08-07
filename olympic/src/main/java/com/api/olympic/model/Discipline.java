package com.api.olympic.model;
 import java.util.List;
import java.util.Map;

public class Discipline {
    private String name;
    private List<Map<String, Object>> competitors;

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Map<String, Object>> competitors) {
        this.competitors = competitors;
    }
}

