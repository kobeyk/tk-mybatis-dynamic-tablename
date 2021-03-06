package com.appleyk.mapper;

import com.appleyk.entity.FeatureEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FeatureMapper extends Mapper<FeatureEntity> {

    /**
     * <p>创建要素表&创建索引&创建主键ID</p>
     * @param groupId 数据组ID
     * @return true or false
     */
    boolean createFeature(@Param("groupId") Long groupId);

    /**
     * <p>根据数据组ID获取要素集</p>
     * @param groupId 数据组ID
     * @return List<GxFeatureEntity>
     */
    List<FeatureEntity> getFeatures(@Param("groupId") Long groupId);

    /**
     * <p>保存要素实体</p>
     * @param groupId 数据组ID
     * @param featureEntity 矢量要素数据实体对象
     * @return Integer
     */
    Integer saveFeature(Long groupId, FeatureEntity featureEntity);

}
