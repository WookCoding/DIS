package com.app.dis.domain.dao;

import com.app.dis.domain.vo.DistributorVO;
import com.app.dis.mapper.DistributorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DistributorDAO {

    private final DistributorMapper distributorMapper;

//    회원가입
    public void insertDistributor(DistributorVO distributorVO){
        distributorMapper.insertDistributor(distributorVO);
    }
}
