package com.app.dis.mapper;

import com.app.dis.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    // 회원 가입
    public void insertMember(MemberVO memberVO);
}
