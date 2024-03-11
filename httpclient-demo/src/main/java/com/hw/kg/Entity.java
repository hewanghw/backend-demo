package com.hw.kg;


public class Entity {
    private String entityId;
    private String searchId;
    private String name;

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "entityId='" + entityId + '\'' +
                ", searchId='" + searchId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
