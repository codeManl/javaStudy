package cn.liulele.behaviorPatterns.statePattern.example;

import cn.liulele.behaviorPatterns.statePattern.example.entity.Machine;
import cn.liulele.behaviorPatterns.statePattern.example.entity.User;
import cn.liulele.behaviorPatterns.statePattern.example.impl.*;

/**
 * @author liulele
 * @description 状态管理器 负责状态的转换及初始化状态的设置
 * @date 2022/9/19 21:54:54
 */
public class StateManager implements State {

    /**
     * 当前状态
     */
    private State state;



    private final State unRegisteredState = new UnRegisteredState(this);
    private final State registeredState = new RegisteredState(this);
    private final State bindState = new BindState(this);
    private final State disabledState = new DisabledState(this);
    private final State removedState = new RemovedState(this);

    public State unRegisteredState() {
        return unRegisteredState;
    }

    public State registeredState() {
        return registeredState;
    }

    public State bindState() {
        return bindState;
    }

    public State disabledState() {
        return disabledState;
    }

    public State removedState() {
        return removedState;
    }

    public StateManager() {
        state = unRegisteredState;
    }


    public void setNextState(State nextState) {
        this.state = nextState;
    }








    @Override
    public boolean register(User user) {
        return state.register(user);
    }

    @Override
    public boolean changeTel(User user, String newTel) {
        return state.changeTel(user,newTel);
    }

    @Override
    public boolean bindMachine(User user, Machine machine) {
        return state.bindMachine(user,machine);
    }

    @Override
    public boolean changeMachine(User user, Machine machine) {
        return state.changeMachine(user,machine);
    }

    @Override
    public boolean disableMachine(User user, Machine machine) {
        return state.disableMachine(user,machine);
    }

    @Override
    public boolean enableMachine(User user, Machine machine) {
        return state.enableMachine(user,machine);
    }

    @Override
    public boolean removeUser(User user) {
        return state.removeUser(user);
    }
}
