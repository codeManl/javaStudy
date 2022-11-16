package cn.liulele.behaviorPatterns.statePattern.example.impl;

import cn.liulele.behaviorPatterns.statePattern.example.entity.Machine;
import cn.liulele.behaviorPatterns.statePattern.example.StateManager;
import cn.liulele.behaviorPatterns.statePattern.example.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liulele
 * @description 已删除状态
 * @date 2022/9/19 21:37:37
 */
@Slf4j
public class RemovedState extends AbstractState {

    public RemovedState(StateManager manager) {
        super(manager);
    }

    @Override
    public boolean removeUser(User user) {
        manager.setNextState(manager.unRegisteredState());
        return true;
    }
}
