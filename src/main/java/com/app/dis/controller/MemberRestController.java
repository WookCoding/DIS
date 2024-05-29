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
    @GetMapping("check-id")
    public Long checkId(@RequestParam("memberIdentification") String memberIdentification){
        return memberService.checkId(memberIdentification);
    }
}
