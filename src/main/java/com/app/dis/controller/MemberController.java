package com.app.dis.controller;

import com.app.dis.domain.vo.MemberVO;
import com.app.dis.service.MemberService;
import com.app.dis.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("member-join")
    public void join(Model model, HttpSession session){
        MemberVO memberVO = MemberVO.builder().build();
        session.invalidate();
        model.addAttribute(memberVO);
    }

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        log.info(memberVO.getMemberIdentification());

        memberService.join(memberVO);
        return new RedirectView("/main/login");
    }

}
