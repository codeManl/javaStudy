package cn.liulele.service.impl;

import cn.liulele.entity.GroupOrder;
import cn.liulele.mapper.GroupMapper;
import cn.liulele.service.OrderService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author liulele
 * @description
 * @date 2022/11/8 10:07:07
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private SqlSessionFactory factory;

    @Override
    public void generate() {
        groupMapper.truncateGroupOrderAfter();
        // 获取所有的group_order信息
        // 按照mname排序
        List<GroupOrder> orderList = groupMapper.getOrderBefore();

        String lastMname = null;
        // 将这些group_name组合成一个新的group_name,赋值给这些group_name
        // 遍历下一个mname
        for (GroupOrder groupOrder : orderList) {
            if (groupOrder.getMname().equals(lastMname) || groupOrder.getGroupname() == null) {
                continue;
            }
            lastMname = groupOrder.getMname();
            // 根据mname获取到所有包含该mname的group_name(set集合)
            HashSet<String> set = new HashSet<>();
            for (GroupOrder order : orderList) {
                if (order.getMname().equals(groupOrder.getMname())) {
                    set.add(order.getGroupname());
                }
            }
            if (set.size()==1) {
                continue;
            }
            // 将这些group_name组合成一个新的group_name,赋值给这些group_name
            StringBuilder newGroupName = new StringBuilder();
            for (String s : set) {
                newGroupName.append(s).append(",");
            }
            newGroupName.deleteCharAt(newGroupName.length()-1);
            // 赋值给这些group_name
            for (GroupOrder order : orderList) {
                if (set.contains(order.getGroupname())) {
                    order.setGroupname(newGroupName.toString());
                }
            }


        }
        SqlSession sqlSession = factory.openSession(ExecutorType.BATCH, false);
        GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
        orderList.forEach(mapper::insertAllOrderAfter);

        sqlSession.commit();
        sqlSession.close();

    }
}
