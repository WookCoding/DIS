package com.app.dis.controller;

import com.app.dis.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-member/*")
public class MemberRestController {

    private final MemberService memberService;

//    아이디 중복 확인
    @GetMapping("check-identification")
    public Long checkMemberIdentification(@RequestParam("memberIdentification") String memberIdentification){
        return memberService.checkMemberIdentification(memberIdentification);
    }

//    닉네임 중복 확인
    @GetMapping("check-nickname")
    public Long checkMemberNickName(@RequestParam("memberNickname") String memberNickname){
        return memberService.checkMemberNickname(memberNickname);
    }
}
