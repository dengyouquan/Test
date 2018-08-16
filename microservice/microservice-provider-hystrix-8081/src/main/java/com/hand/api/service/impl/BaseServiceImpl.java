package com.hand.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.api.service.BaseService;
import com.hand.domain.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Transactional
public abstract class BaseServiceImpl<K extends BaseEntity, T extends Mapper> implements BaseService<K> {

    @Autowired
    protected T mapper;

    @Override
    public K create(K k) {
        mapper.insert(k);
        return (K) mapper.selectByPrimaryKey(k);
    }

    @Override
    public K update(K k) {
        mapper.updateByPrimaryKey(k);
        return (K) mapper.selectByPrimaryKey(k);
    }

    @Override
    public void delete(Short id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public K get(Short id) {
        return (K) mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<K> list(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        return mapper.selectAll();
    }
}
