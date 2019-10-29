package cn.bluethink.model;

/**
 * @author: tunan
 * @version: v.1.0.1
 * @date: created on 16:01 2019-06-28
 */
public class GxFeatureAttribute {
    private String key;
    private Object value;

    public GxFeatureAttribute() {
    }

    public GxFeatureAttribute(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
