package com.hand.api.service;

import com.hand.domain.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T create(T t);

    T update(T t);

    void delete(Short id);

    T get(Short id);

    List<T> list(Integer pageNum, Integer pageSize);
}
