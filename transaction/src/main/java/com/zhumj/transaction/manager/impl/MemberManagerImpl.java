package com.zhumj.transaction.manager.impl;

import com.zhumj.transaction.manager.MemberManager;
import com.zhumj.mybatis.mapper.MemberMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class MemberManagerImpl implements MemberManager {

    @Resource
    private MemberMapper memberMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateName(String name, Integer id) {

        int i = memberMapper.updateName(name, id);

        return 0;
    }
}
