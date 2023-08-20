package com.killbug.user.service.impl;

import com.killbug.user.api.domain.User;
import com.killbug.user.dto.AccountSettingDTO;
import com.killbug.user.dto.UserProfileDTO;
import com.killbug.user.mapper.UserMapper;
import com.killbug.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    @Override
    public User selectUserByUsername(String username) {
        return null;
    }

    @Override
    public void updateUserBalance(Integer userId, int balance, int type) {

    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void incrBalanceById(Long userId, Integer reward) {

    }

    @Override
    public void decrBalanceById(Long userId, Integer reward) {

    }

    @Override
    public Map<String, Object> renderUserSpace(Long id) {
        return null;
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public void updateUserProfile(UserProfileDTO userProfileDTO) {

    }

    @Override
    public void recharge(Integer dollar) {

    }

    @Override
    public String changeAccountSetting(AccountSettingDTO accountSettingDTO) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }
}
