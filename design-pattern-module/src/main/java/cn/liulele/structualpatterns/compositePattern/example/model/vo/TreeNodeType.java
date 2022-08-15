package cn.liulele.structualpatterns.compositePattern.example.model.vo;

public enum TreeNodeType {
    /**
     * 子节点
     */
    CHILD(0),
    /**
     * 叶节点
     */
    LEAF(1);

    TreeNodeType(Integer value) {
    }

}