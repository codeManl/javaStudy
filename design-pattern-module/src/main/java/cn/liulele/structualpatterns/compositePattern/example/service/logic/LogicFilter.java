package cn.liulele.structualpatterns.compositePattern.example.service.logic;

import cn.liulele.structualpatterns.compositePattern.example.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 树节点逻辑过滤器接口，定义了通用接口，逻辑决策器、获取决策值，每一个提供决策能力的类都需要实现此接口
 */
public interface LogicFilter {
    /**
     * 逻辑决策器
     *
     * @param matterValue      决策值
     * @param treeNodeLinkList 决策链路
     * @return 下一个树节点的id
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    /**
     * 获取决策值
     * @param treeId 决策树id
     * @param userId 用户id
     * @param decisionMatter 决策物料
     * @return 决策值
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

}
