package cn.liulele.structualpatterns.adapterPattern.engine;

import cn.liulele.structualpatterns.compositePattern.example.model.aggregates.TreeRich;
import cn.liulele.structualpatterns.compositePattern.example.model.vo.EngineResult;
import cn.liulele.structualpatterns.compositePattern.example.model.vo.TreeNode;

import java.util.Map;

public class TreeEngineHandle extends BaseEngine {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);

        return new EngineResult(userId, treeId, treeNode.getTreeId(), treeNode.getTreeNodeValue());
    }
}
