package com.app.dis.service;

import com.app.dis.domain.vo.DistributorVO;

public interface DistributorService {
    
//    회원가입
    public void join(DistributorVO distributorVO);

//    이메일 중복 확인
    public Long emailCheck(String distributorEmail);
}
