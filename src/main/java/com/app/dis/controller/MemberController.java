package com.app.dis.controller;

import com.app.dis.domain.vo.MemberVO;
import com.app.dis.service.MemberService;
import com.app.dis.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

    private final MemberService memberService;

//    회원 가입
    @GetMapping("member-join")
    public void join(Model model, HttpSession session){
        MemberVO memberVO = MemberVO.builder().build();
        session.invalidate();
        model.addAttribute(memberVO);
    }

//    회원 가입
    @PostMapping("join")
    public RedirectView join(MemberVO memberVO) {
        memberService.join(memberVO);
        return new RedirectView("/main/login?memberJoinSuccess=true");
    }

//    로그인
    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, HttpSession session) {
        Long memberId = memberService.login(memberVO);
        boolean check = false;

        if(memberId != null){
            check = true;
            session.setAttribute("memberId", memberId);
        }

        return new RedirectView("/main/login?memberLoginSuccess=" + check);
    }

}
