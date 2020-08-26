package com.zhumj.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    int updateName(@Param("name") String name, @Param("id") Integer id);
}
