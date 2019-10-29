package cn.bluethink.model;

import java.util.List;

/**
 * @author: tunan
 * @version: v.1.0.1
 * @date: created on 14:13 2019-06-28
 */
public class GxFeatureModel {

    private Long id;

    private Long metaId;

    private List<GxFeatureAttribute> attributes;

    private String geometry;

    public GxFeatureModel() {
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

    public List<GxFeatureAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GxFeatureAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
}
