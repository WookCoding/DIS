package com.app.dis.mapper;

import com.app.dis.domain.vo.DistributorVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@Slf4j
public class DistributorMapperTest {

    @Autowired
    private DistributorMapper distributorMapper;

//    회원가입 테스트
    @Test
    public void insertDistributorTest() {
        DistributorVO distributorVO = DistributorVO.builder()
                .distributorEmail("test1234@naver.com")
                .distributorName("탕탕이")
                .distributorPassword(new String(Base64.getEncoder().encode("hello".getBytes())))
                .distributorPhoneNumber("01012341234")
                .build();

        distributorMapper.insertDistributor(distributorVO);
    }
}