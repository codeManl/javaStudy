package cn.liulele.jwt.mapper;

import cn.liulele.jwt.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liulele
 * @description
 * @date 2022/12/5 20:20:20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectUserInfoByName(@Param("username") String username);

}
