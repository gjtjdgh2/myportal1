package com.bitacademy.myportal1.repository;

import com.bitacademy.myportal1.vo.MemberVo;

public interface MemberDao {
public int insert(MemberVo vo);
public MemberVo selectUser(String email,String password);
public MemberVo selectUser(String email);

}
