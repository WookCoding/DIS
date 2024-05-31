package com.app.dis.mapper;

import com.app.dis.domain.vo.DistributorVO;
import com.app.dis.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DistributorMapper {

    // 회원 가입
    public void insertDistributor(DistributorVO distributorVO);
}
