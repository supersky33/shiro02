package com.pc.service;

import com.pc.vo.TUser;


public interface UserService {

    TUser queryUserByUsername(String username);
}