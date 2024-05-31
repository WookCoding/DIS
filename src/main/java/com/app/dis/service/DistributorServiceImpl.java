package com.app.dis.service;

import com.app.dis.domain.dao.DistributorDAO;
import com.app.dis.domain.vo.DistributorVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DistributorServiceImpl implements DistributorService {

    private final DistributorDAO distributorDAO;

//    회원 가입
    @Override
    @Transactional  // 회원가입 시에 오류 발생 시 롤백 위함
    public void join(DistributorVO distributorVO) {
        DistributorVO distributor = DistributorVO.builder()
                .distributorEmail(distributorVO.getDistributorEmail())
                .distributorName(distributorVO.getDistributorName())
                .distributorPassword(distributorVO.getDistributorPassword())
                .distributorPhoneNumber(distributorVO.getDistributorPhoneNumber())
                .build();

        distributorDAO.insertDistributor(distributor);
    }

}
