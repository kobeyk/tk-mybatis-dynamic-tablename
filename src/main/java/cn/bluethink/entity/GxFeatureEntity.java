package cn.bluethink.entity;
import cn.bluethink.model.GxFeatureAttribute;
import cn.bluethink.model.GxFeatureModel;
import cn.bluethink.utils.GxGeneralUtils;
import cn.bluethink.utils.GxJsonUtils;
import com.vividsolutions.jts.io.ParseException;
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
public class GxFeatureEntity implements IDynamicTableName {


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


    public GxFeatureEntity() {
    }

    public GxFeatureEntity(String tableName) {
        this.tableName = tableName;
    }

    private GxFeatureEntity(GxFeatureModel model) {
        this.id = model.getId();
        if (GxGeneralUtils.isNotEmpty(model.getAttributes())) {
            List<GxFeatureAttribute> attributes = model.getAttributes();
            Map<String, Object> attributesMap = new HashMap<>();
            attributes.stream().forEach(a -> attributesMap.put(a.getKey(), a.getValue()));
            this.attributes = GxJsonUtils.objectToJson(attributesMap);
        }
        this.metaId = model.getMetaId();
    }

    public static GxFeatureEntity createEntity(GxFeatureModel model) {
        return new GxFeatureEntity(model);
    }

    public static GxFeatureModel createModel(GxFeatureEntity entity) throws IOException, ParseException{
        GxFeatureModel model = new GxFeatureModel();
        model.setId(entity.getId());
        if (GxGeneralUtils.isNotEmpty(entity.getAttributes())) {
            Map<String, Object> attributesMap = GxJsonUtils.parseMap(entity.getAttributes());
            List<GxFeatureAttribute> attributes = attributesMap.entrySet().stream().map(e -> new GxFeatureAttribute(e.getKey(), e.getValue())).collect(Collectors.toList());
            model.setAttributes(attributes);
        }
        model.setMetaId(entity.getMetaId());
        return model;
    }

    public static List<GxFeatureModel> createModelList(List<GxFeatureEntity> featureEntities) throws IOException, ParseException {
        List<GxFeatureModel> featureModels = new ArrayList<>();
        if (GxGeneralUtils.isEmpty(featureEntities)) {
            return featureModels;
        }
        for (GxFeatureEntity featureEntity : featureEntities) {
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
