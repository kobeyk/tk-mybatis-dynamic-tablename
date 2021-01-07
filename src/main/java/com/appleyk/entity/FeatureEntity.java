package com.appleyk.entity;
import com.appleyk.model.FeatureAttribute;
import com.appleyk.model.FeatureModel;
import com.appleyk.utils.GeneralUtils;
import com.appleyk.utils.JsonUtils;
import org.locationtech.jts.io.ParseException;
import tk.mybatis.mapper.entity.IDynamicTableName;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 不要固定表名，实现IDynamicTableName接口，即可动态控制实体映射的Table
 */
public class FeatureEntity implements IDynamicTableName {


    /**
     * 要素Id
     */
    @Id
    private Long id;

    /**
     * 地理要素
     */
    private byte[] geom;

    /**
     * 所关联的元信息Id
     */
    private Long metaId;

    /**
     * 地理要素属性
     */
    private String attributes;

    @Transient
    private String tableName;


    public FeatureEntity() {
    }

    public FeatureEntity(String tableName) {
        this.tableName = tableName;
    }

    private FeatureEntity(FeatureModel model) {
        this.id = model.getId();
        if (GeneralUtils.isNotEmpty(model.getAttributes())) {
            List<FeatureAttribute> attributes = model.getAttributes();
            Map<String, Object> attributesMap = new HashMap<>();
            attributes.stream().forEach(a -> attributesMap.put(a.getKey(), a.getValue()));
            this.attributes = JsonUtils.objectToJson(attributesMap);
        }
        this.metaId = model.getMetaId();
    }

    public static FeatureEntity createEntity(FeatureModel model) {
        return new FeatureEntity(model);
    }

    public static FeatureModel createModel(FeatureEntity entity) throws IOException, ParseException {
        FeatureModel model = new FeatureModel();
        model.setId(entity.getId());
        if (GeneralUtils.isNotEmpty(entity.getAttributes())) {
            Map<String, Object> attributesMap = JsonUtils.parseMap(entity.getAttributes());
            List<FeatureAttribute> attributes = attributesMap.entrySet().stream().map(e -> new FeatureAttribute(e.getKey(), e.getValue())).collect(Collectors.toList());
            model.setAttributes(attributes);
        }
        model.setMetaId(entity.getMetaId());
        return model;
    }

    public static List<FeatureModel> createModelList(List<FeatureEntity> featureEntities) throws IOException, ParseException {
        List<FeatureModel> featureModels = new ArrayList<>();
        if (GeneralUtils.isEmpty(featureEntities)) {
            return featureModels;
        }
        for (FeatureEntity featureEntity : featureEntities) {
            featureModels.add(createModel(featureEntity));
        }
        return featureModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getGeom() {
        return geom;
    }

    public void setGeom(byte[] geom) {
        this.geom = geom;
    }

    public Long getMetaId() {
        return metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getDynamicTableName() {
        return tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


}
