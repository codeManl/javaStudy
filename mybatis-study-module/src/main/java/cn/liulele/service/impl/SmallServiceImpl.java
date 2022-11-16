package cn.liulele.service.impl;

import cn.liulele.mapper.GroupMapper;
import cn.liulele.service.SmallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liulele
 * @description
 * @date 2022/11/8 10:07:07
 */
@Service
public class SmallServiceImpl implements SmallService {
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public void generate() {
        // 根据提供的成员名称获取其所在的集团(排序前)
        groupMapper.truncateGroupOrder();
        groupMapper.generateGroupOrderBefore();

        // 根据上面的集团名称获取到这些集团下的成员公司列表及所在地址
        groupMapper.truncateGroupSmall();
        groupMapper.generateGroupSmall();

        // 判断排序前表中的数据是否在小表中存在,如果存在，则将小表中的is_provide字段置为1
        groupMapper.updateIsProvide();
    }
}
