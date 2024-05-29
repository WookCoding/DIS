package com.app.dis.service;

import com.app.dis.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@Slf4j
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;


    @Test
    public void joinTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("a1145")
                .memberName("이름45")
                .memberNickname("닉네임4")
                .memberPassword(new String(Base64.getEncoder().encode(("hello").getBytes())))
                .memberPhoneNumber("010123416")
                .build();

        memberService.join(memberVO);
    }
}
