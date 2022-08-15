package cn.liulele.structualpatterns.compositePattern.example.service.logic;

import cn.liulele.structualpatterns.compositePattern.example.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 *  定义了基本的决策方法
 */
public abstract class BaseLogic implements LogicFilter {

    /**
     * 交由子类实现
     * 每一个实现接口的类必须按规则提供决策值,用这个决策值进行逻辑比对
     * @param treeId         决策树id
     * @param userId         用户id
     * @param decisionMatter 决策物料
     * @return 获取决策值
     */
    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        for (TreeNodeLink treeNodeLink : treeNodeLinkList) {
            if (decisionLogic(matterValue, treeNodeLink)) {
                return treeNodeLink.getNodeIdTo();
            }
        }
        return 0L;
    }


    private boolean decisionLogic(String matterValue, TreeNodeLink treeNodeLink) {
        return switch (treeNodeLink.getRuleLimitType()) {
            case EQ -> matterValue.equals(treeNodeLink.getRuleLimitValue());
            case GT -> Double.parseDouble(matterValue) > Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case GTE -> Double.parseDouble(matterValue) >= Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case LT -> Double.parseDouble(matterValue) < Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case LTE -> Double.parseDouble(matterValue) <= Double.parseDouble(treeNodeLink.getRuleLimitValue());
            default -> false;
        };
    }
}
