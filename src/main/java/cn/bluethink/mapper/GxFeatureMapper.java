package cn.bluethink.mapper;

import cn.bluethink.entity.GxFeatureEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GxFeatureMapper extends Mapper<GxFeatureEntity> {

    boolean createFeature(@Param("tableName") String tableName,@Param("indexId") String id);

    List<GxFeatureEntity> getFeatures(@Param("tableName") String tableName);
}
