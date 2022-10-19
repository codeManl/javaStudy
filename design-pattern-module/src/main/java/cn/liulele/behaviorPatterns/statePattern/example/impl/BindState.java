package cn.liulele.behaviorPatterns.statePattern.example.impl;

import cn.liulele.behaviorPatterns.statePattern.example.entity.Machine;
import cn.liulele.behaviorPatterns.statePattern.example.StateManager;
import cn.liulele.behaviorPatterns.statePattern.example.entity.Phone;
import cn.liulele.behaviorPatterns.statePattern.example.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuele
 * @description 已绑定状态
 * @date 2022/9/19 21:37:37
 */
@Slf4j
public class BindState extends AbstractState {

    public BindState(StateManager manager) {
        super(manager);
    }

    @Override
    public boolean changeMachine(User user, Machine machine) {
        user.getPhone().setMachine(machine);
        log.info("用户进行更换机器操作,更换后用户的信息为: " + user);
        manager.setNextState(manager.bindState());
        return true;
    }

    @Override
    public boolean changeTel(User user, String newTel) {
        Phone phone = new Phone();
        phone.setPhoneNumber(newTel);
        user.setPhone(phone);
        log.info("用户进行更换手机号操作,更换后用户的信息为: " + user);
        manager.setNextState(manager.registeredState());
        return true;
    }

    @Override
    public boolean disableMachine(User user, Machine machine) {
        machine.setEnable(false);
        log.info("用户进行挂失操作,挂失后机器无法使用");
        manager.setNextState(manager.disabledState());
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
