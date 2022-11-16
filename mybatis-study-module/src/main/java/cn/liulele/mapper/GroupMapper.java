package cn.liulele.mapper;

import cn.liulele.entity.GroupOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liulele
 * @description
 * @date 2022/11/7 17:19:19
 */
@Mapper
public interface GroupMapper {
    void truncateGroupOrder();

    void generateGroupOrderBefore();

    void truncateGroupSmall();

    void generateGroupSmall();

    void updateIsProvide();

    List<GroupOrder> getOrderBefore();

    void insertAllOrderAfter(GroupOrder groupOrder);

    void truncateGroupOrderAfter();
}
