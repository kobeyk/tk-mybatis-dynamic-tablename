package com.appleyk.model;

import java.util.List;

public class FeatureModel {

    private Long id;

    private Long metaId;

    private List<FeatureAttribute> attributes;

    private String geometry;

    public FeatureModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMetaId() {
        return metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    public List<FeatureAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<FeatureAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
}
