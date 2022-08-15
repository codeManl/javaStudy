package cn.liulele.structualpatterns.compositePattern.example.model.aggregates;

import cn.liulele.structualpatterns.compositePattern.example.model.vo.TreeNode;
import cn.liulele.structualpatterns.compositePattern.example.model.vo.TreeRoot;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * 整个规则树
 */
@Data
@AllArgsConstructor
public class TreeRich {
    /**
     * 根节点
     */
    private TreeRoot treeRoot;

    /**
     * 树节点 key: 树节点id  value: 树节点
     */
    private Map<Long, TreeNode> treeNodeMap;
}
