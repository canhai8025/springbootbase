package com.aldeng.dao;

import com.aldeng.entity.UserInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息DAO
 *
 * @author Yujiaqi
 * @date 2020/12/2 19:16
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {

}
