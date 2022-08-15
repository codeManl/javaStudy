package cn.liulele.structualpatterns.compositePattern.example.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TreeNode {
    /**
     * 树节点id
     */
    private Long treeNodeId;
    /**
     * 树id
     */
    private Long treeId;
    /**
     * 节点类型
     */
    private TreeNodeType treeNodeType;

    /**
     * 节点的值
     * 仅在节点类型为子节点时使用
     */
    private String treeNodeValue;

    /**
     * 规则key
     */
    private String ruleKey;
    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 节点链路 （一个节点要通过不同的节点链路来前往不同的下级节点）
     */
    private List<TreeNodeLink> treeNodeLinkList;

}


