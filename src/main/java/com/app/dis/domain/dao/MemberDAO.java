package com.app.dis.domain.dao;

import com.app.dis.domain.vo.MemberVO;
import com.app.dis.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    //    회원 가입
    public void insertMember(MemberVO memberVO) {
        memberMapper.insertMember(memberVO);
    }

    //  아이디 중복 찾기
    public Long findByMemberIdentification(String memberIdentification){
        return memberMapper.findByMemberIdentification(memberIdentification);
    }
}
