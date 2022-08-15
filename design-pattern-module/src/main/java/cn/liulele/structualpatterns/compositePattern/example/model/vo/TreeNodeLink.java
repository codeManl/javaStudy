package cn.liulele.structualpatterns.compositePattern.example.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 树节点链路
 */
@Data
@NoArgsConstructor
public class TreeNodeLink {
    /**
     *链路源节点id
     */
    private Long nodeIdFrom;

    /**
     * 链路目标节点id
     */
    private Long nodeIdTo;

    /**
     * 限定类型
     */
    private RuleLimitType ruleLimitType;

    /**
     * 限定值
     */
    private String ruleLimitValue;


}

