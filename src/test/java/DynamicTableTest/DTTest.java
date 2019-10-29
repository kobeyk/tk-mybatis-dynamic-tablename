package DynamicTableTest;

import cn.bluethink.App;
import cn.bluethink.entity.GxFeatureEntity;
import cn.bluethink.mapper.GxFeatureMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * <p></p>
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
    private GxFeatureMapper featureMapper;

    @Test
    public void createTable(){
        long id = System.currentTimeMillis() ;
        featureMapper.createFeature("gx_feature_"+id,Long.toString(id));
    }

    @Test
    public void query(){
        long id = System.currentTimeMillis();
        String tableName = "gx_feature"+id;
        featureMapper.createFeature(tableName,Long.toString(id));
        List<GxFeatureEntity> features = featureMapper.getFeatures(tableName);
        System.out.println("查询结果："+features);
    }

}
