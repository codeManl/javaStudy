package cn.liulele.shardingsphere.mapper;

import cn.liulele.shardingsphere.entity.Order;
import cn.liulele.shardingsphere.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liulele
 * @description
 * @date 2022/11/7 22:51:51
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
