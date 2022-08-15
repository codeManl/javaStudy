package cn.liulele.structualpatterns.adapterPattern.engine;

import cn.liulele.structualpatterns.compositePattern.example.model.aggregates.TreeRich;
import cn.liulele.structualpatterns.compositePattern.example.model.vo.EngineResult;
import cn.liulele.structualpatterns.compositePattern.example.model.vo.TreeNode;
import cn.liulele.structualpatterns.compositePattern.example.model.vo.TreeNodeType;
import cn.liulele.structualpatterns.compositePattern.example.model.vo.TreeRoot;
import cn.liulele.structualpatterns.compositePattern.example.service.logic.LogicFilter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public abstract class BaseEngine extends EngineConfig implements IEngine {

    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {

        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        Long treeRootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNodeInfo = treeNodeMap.get(treeRootNodeId);
        // 如果不是果实节点，则继续往下找，直到找到果实节点然后返回
        while (treeNodeInfo.getTreeNodeType() == TreeNodeType.LEAF) {
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = EngineConfig.getLogicFilterMap().get(ruleKey);
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            Long nextNodeId = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            treeNodeInfo = treeNodeMap.get(nextNodeId);
            log.info("决策树引擎=>{} userId：{} treeId：{} treeNodeInfo：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), userId, treeId, treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNodeInfo;

    }


    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);


}
