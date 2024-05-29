package com.app.dis.mapper;

import com.app.dis.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@Slf4j
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;
    
//    회원가입 테스트
    @Test
    public void insertMemberTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("a12351145")
                .memberName("이름")
                .memberNickname("닉네임")
                .memberPassword(new String(Base64.getEncoder().encode(("hello").getBytes())))
                .memberPhoneNumber("01012341234")
                .build();

        memberMapper.insertMember(memberVO);
    }

//    아이디 중복 체크
    @Test
    public void idCheckTest(){
//        아이디 존재 O
        log.info(memberMapper.findByMemberIdentification("12312312") + "");
//        아이디 존재 X
        log.info(memberMapper.findByMemberIdentification("123123") + "");
    }

}
