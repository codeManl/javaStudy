package cn.liulele.behaviorPatterns.statePattern.example.impl;

import cn.liulele.behaviorPatterns.statePattern.example.StateManager;
import cn.liulele.behaviorPatterns.statePattern.example.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuele
 * @description 未注册状态
 * @date 2022/9/19 21:37:37
 */
@Slf4j
public class UnRegisteredState extends AbstractState {


    public UnRegisteredState(StateManager manager) {
        super(manager);
    }

    @Override
    public boolean register(User user) {
        if (user.getUid() >= 10) {
            log.info("注册用户成功,用户信息为: " + user);
            manager.setNextState(manager.registeredState());
            return true;
        }
        log.info("注册用户失败");
        manager.setNextState(manager.unRegisteredState());
        return false;
    }

    @Override
    public boolean removeUser(User user) {
        log.info("该用户不存在");
        manager.setNextState(manager.removedState());
        return true;
    }
}
