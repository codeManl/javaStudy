package cn.liulele.structualpatterns.compositePattern.example.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeRoot {
    /**
     * 规则树id
     */
    private Long treeId;
    /**
     * 规则树名称
     */
    private String treeName;
    /**
     * 根节点id
     */
    private Long treeRootNodeId;


}
