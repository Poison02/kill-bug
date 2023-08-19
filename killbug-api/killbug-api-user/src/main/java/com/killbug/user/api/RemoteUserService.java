package com.killbug.user.api;

import com.killbug.user.api.domain.User;
import com.killbug.user.api.model.LoginUser;

/**
 * @author Zch
 * @date 2023/8/19
 **/
public interface RemoteUserService {

    LoginUser getUserInfo(String username);

    void updateUserBalance(Integer fromUserId, Integer toUserId, int balance);

    User getUserById(Long id);

    void incrBalanceById(Long userId, Integer reward);

    void decrBalanceById(Long userId, Integer reward);

    void testRemote();

    void createUser(User user);
}
