package com.aldeng.service;

import com.aldeng.entity.TypeEntity;
import com.aldeng.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 题目-题目类型表
 *
 * @author 公众号：悟空聊架构
 * @site www.passjava.cn
 * @date 2020-04-25 22:34:04
 */
public interface ITypeService extends IService<TypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<TypeEntity> getTypeEntityList();
//
    List<TypeEntity> getTypeEntityListByLock();
//
    List<TypeEntity> getTypeEntityListByRedisDistributedLock() throws InterruptedException;

    List<TypeEntity> getTypeEntityListByRedissonDistributedLock();

//    void testRedisMutil();

//    @Transactional
//    Long testTransactionAnnotations();

//    void enableTransactionSupport(Boolean flag);

//    Long testWithOutTransactionAnnotations();
}

