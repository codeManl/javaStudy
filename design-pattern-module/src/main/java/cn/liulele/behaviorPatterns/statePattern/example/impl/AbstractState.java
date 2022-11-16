package cn.liulele.behaviorPatterns.statePattern.example.impl;

import cn.liulele.behaviorPatterns.statePattern.example.entity.Machine;
import cn.liulele.behaviorPatterns.statePattern.example.State;
import cn.liulele.behaviorPatterns.statePattern.example.StateManager;
import cn.liulele.behaviorPatterns.statePattern.example.entity.User;

/**
 * @author liulele
 * @description
 * @date 2022/9/19 19:51:51
 */
public abstract class AbstractState implements State {

    protected StateManager manager;

    public AbstractState(StateManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean register(User user) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public boolean changeTel(User user, String newTel) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public boolean bindMachine(User user, Machine machine) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public boolean changeMachine(User user, Machine machine) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public boolean disableMachine(User user, Machine machine) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public boolean enableMachine(User user, Machine machine) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public boolean removeUser(User user) {
        throw new UnsupportedOperationException("不支持的操作");
    }

}
