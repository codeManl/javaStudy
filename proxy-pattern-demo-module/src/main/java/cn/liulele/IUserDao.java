package cn.liulele;

/**
 * @author liulele
 * @description
 * @date 2022/8/22 19:55:55
 */
public interface IUserDao {

    @Select("select * from sys_user where id = #{uid}")
    String getUser(String uid);
}
