package cn.liulele.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liulele
 * @description
 * @date 2022/11/8 10:04:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupSmall {
    private Long id;

    private String groupName;

    private String mname;

    private String address;

    private boolean isProvide;
}
