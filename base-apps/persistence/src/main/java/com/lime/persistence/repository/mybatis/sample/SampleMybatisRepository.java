package com.lime.persistence.repository.mybatis.sample;

import com.lime.persistence.domain.response.SampleResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMybatisRepository {
    SampleResponse getNow();

    String getSample();
}
