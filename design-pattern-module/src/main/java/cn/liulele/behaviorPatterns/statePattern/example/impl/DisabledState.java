package cn.liulele.behaviorPatterns.statePattern.example.impl;

import cn.liulele.behaviorPatterns.statePattern.example.StateManager;
import cn.liulele.behaviorPatterns.statePattern.example.entity.Machine;
import cn.liulele.behaviorPatterns.statePattern.example.entity.User;
import cn.liulele.behaviorPatterns.statePattern.example.impl.AbstractState;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuele
 * @description 已禁用状态
 * @date 2022/9/19 21:37:37
 */
@Slf4j
public class DisabledState extends AbstractState {

    public DisabledState(StateManager manager) {
        super(manager);
    }


    @Override
    public boolean enableMachine(User user, Machine machine) {
        machine.setEnable(true);
        log.info("用户找回了机器");
        manager.setNextState(manager.registeredState());
        return true;
    }

    @Override
    public boolean removeUser(User user) {
        user =null;
        log.info("删除用户信息成功");
        manager.setNextState(manager.removedState());
        return true;
    }
}
