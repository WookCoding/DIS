package com.app.dis.service;

import com.app.dis.domain.dao.MemberDAO;
import com.app.dis.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    public void join(MemberVO memberVO) {
        MemberVO member = MemberVO.builder()
                .memberIdentification(memberVO.getMemberIdentification())
                .memberPhoneNumber(memberVO.getMemberPhoneNumber())
                .memberNickname(memberVO.getMemberNickname())
                .memberPassword(new String(Base64.getEncoder().encode(memberVO.getMemberPassword().getBytes())))
                .memberName(memberVO.getMemberName())
                .build();

        memberDAO.insertMember(member);
    }

    @Override
    public Long checkId(String memberIdentification) {
        return memberDAO.findByMemberIdentification(memberIdentification);
    }


}
