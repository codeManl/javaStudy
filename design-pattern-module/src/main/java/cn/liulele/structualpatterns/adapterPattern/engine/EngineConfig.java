package cn.liulele.structualpatterns.adapterPattern.engine;

import cn.liulele.structualpatterns.compositePattern.example.service.logic.LogicFilter;
import cn.liulele.structualpatterns.compositePattern.example.service.logic.impl.UserAgeFilter;
import cn.liulele.structualpatterns.compositePattern.example.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EngineConfig {
    /**
     * 可提供服务的决策节点
     */
    private static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userGender", new UserGenderFilter());
        logicFilterMap.put("useAge", new UserAgeFilter());
    }

    public static Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public static void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }
}
