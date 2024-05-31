package com.app.dis.controller;

import com.app.dis.service.CheckService;
import com.app.dis.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-member/*")
public class MemberRestController {

    private final MemberService memberService;
    private final CheckService checkService;

//    아이디 중복 확인
    @GetMapping("check-identification")
    public Long checkMemberIdentification(@RequestParam("memberIdentification") String memberIdentification){
        return nullTo0(memberService.checkMemberIdentification(memberIdentification));
    }

//    닉네임 중복 확인
    @GetMapping("check-nickname")
    public Long checkMemberNickName(@RequestParam("memberNickname") String memberNickname){
        return nullTo0(memberService.checkMemberNickname(memberNickname));
    }

//    핸드폰 중복 확인
    @GetMapping("check-phonenumber")
    public Long checkMemberPhoneNumber(@RequestParam("memberPhoneNumber") String memberPhoneNumbrer){
        return nullTo0(memberService.checkMemberPhoneNumber(memberPhoneNumbrer));
    }

//  sms 발송 인증번호
    @GetMapping("send-code")
    public String sendCode(@RequestParam("memberPhoneNumber") String memberPhoneNumber){
        return checkService.sendCertificationNumber(memberPhoneNumber);
    }

    private Long nullTo0(Long nullOrLong){
        if(nullOrLong != null){
            return 1L;
        }
        return 0L;
    }
}
