package com.example.demo.dao;
import com.example.demo.domain.SysUser;
public interface UserDao {
    public SysUser findByUserName(String username);
}
