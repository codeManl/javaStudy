package cn.liulele.behaviorPatterns.statePattern.example;

import cn.liulele.behaviorPatterns.statePattern.example.entity.Machine;
import cn.liulele.behaviorPatterns.statePattern.example.entity.User;

/**
 * @author liulele
 * @description 状态接口，在这里定义各种状态下可以进行的操作
 * @date 2022/9/19 19:44:44
 */
public interface State {

    /**
     * 注册操作
     * @param user 用户信息
     * @return 注册结果
     */
    boolean register(User user);

    /**
     * 更新手机号
     * @param user 用户信息
     * @param newTel 新手机号
     * @return 更新结果
     */
    boolean changeTel(User user,String newTel);

    /**
     * 绑定机器
     * @param user 用户
     * @param machine 机器
     * @return 绑定结果
     */
    boolean bindMachine(User user, Machine machine);

    /**
     * 更新机器
     * @param user 用户信息
     * @param machine 新设备名称
     * @return 更新结果
     */
    boolean changeMachine(User user,Machine machine);

    /**
     * 禁用机器
     * @param user 用户
     * @param machine 机器
     * @return 禁用结果
     */
    boolean disableMachine(User user,Machine machine);

    /**
     * 启用机器
     * @param user 用户
     * @param machine 机器
     * @return 启用结果
     */
    boolean enableMachine(User user, Machine machine);

    /**
     * 移除用户信息
     * @param user 用户
     * @return 移除结果
     */
    boolean removeUser(User user);
}
