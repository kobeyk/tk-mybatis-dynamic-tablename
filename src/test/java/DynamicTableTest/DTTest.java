package DynamicTableTest;

import cn.bluethink.App;
import cn.bluethink.entity.GxFeatureEntity;
import cn.bluethink.mapper.GxFeatureMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>动态表操作单元测试</p>
 *
 * @author yukun24@126.com
 * @version V.1.0.1
 * @company 苏州中科蓝迪
 * @date created on 下午 6:16 2019-10-29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class DTTest {

    @Autowired
    protected GxFeatureMapper featureMapper;


    /**
     * <p>动态创表+创索引+创主键</p>
     */
    @Test
    public void createTable() {
        long groupId = System.currentTimeMillis();
        featureMapper.createFeature(groupId);
    }

    /**
     * <p>动态指定查询表查询数据</p>
     */
    @Test
    public void query() {
        long groupId = System.currentTimeMillis();
        featureMapper.createFeature(groupId);
        List<GxFeatureEntity> features = featureMapper.getFeatures(groupId);
        System.out.println("查询结果：" + features);
    }


    /**
     * <p>通过Example查询对象指定TableName查询结果集</p>
     */
    @Test
    public void find(){
        Example example = new Example(GxFeatureEntity.class);
        example.setTableName("gx_feature_1572360438542");
        List<GxFeatureEntity> featureEntities = featureMapper.selectByExample(example);
        System.out.println("结果SIZE："+featureEntities.size());
    }


    /**
     * <p>构建要素数据实体类，指定表名，并通过mapper插入一条记录</p>
     */
    @Test
    public void save(){
        GxFeatureEntity entity = new GxFeatureEntity("gx_feature_1572360438542");
        entity.setId(System.currentTimeMillis());
        entity.setMetaId(System.currentTimeMillis());
        int insert = featureMapper.insert(entity);
        System.out.println("插入影响行数："+insert);
    }

    /**
     * <p>构建动态索引名+主键ID名</p>
     */
    List<String> getTableParams(long id) {
        List<String> params = new ArrayList<>();
        params.add("INDEX_GEOM_" + id);
        params.add("INDEX_META_ID_" + id);
        params.add("PK_ID_"+id);
        return params;
    }

}
