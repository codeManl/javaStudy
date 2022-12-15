package cn.liulele.mapper;

import cn.liulele.entity.GAV;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liulele
 * @description
 * @date 2022/11/7 17:19:19
 */
@Mapper
public interface UserMapper {
    Integer selectOne(Integer id);

    void saveGAV(GAV gav);
}
