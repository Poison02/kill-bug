package com.killbug.user.mapper;

import com.killbug.common.mybatis.core.mapper.BaseMapperPlus;
import com.killbug.user.api.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface UserMapper extends BaseMapperPlus<UserMapper, User, User> {

    void incrBalanceById(@Param("userId") Long userId, @Param("reward") Integer reward);

    void decrBalanceById(@Param("userId") Long userId, @Param("reward") Integer reward);

}
