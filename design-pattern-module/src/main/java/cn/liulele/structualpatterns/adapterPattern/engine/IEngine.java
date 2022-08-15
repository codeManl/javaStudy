package cn.liulele.structualpatterns.adapterPattern.engine;

import cn.liulele.structualpatterns.compositePattern.example.model.aggregates.TreeRich;
import cn.liulele.structualpatterns.compositePattern.example.model.vo.EngineResult;

import java.util.Map;

/**
 * 决策引擎顶层接口，定义了处理方法，可以方便后续扩展出不同类型的决策引擎，也就是可以建立不同类型的决策工厂
 */
public interface IEngine {
    /**
     *
     * @param treeId 规则树id
     * @param userId 用户id
     * @param treeRich 树的整个结构
     * @param decisionMatter 决策物料
     * @return 决策结果
     */
    EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);
}
