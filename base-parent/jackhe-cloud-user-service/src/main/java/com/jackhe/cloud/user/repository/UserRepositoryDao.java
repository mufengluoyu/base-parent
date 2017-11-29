package com.jackhe.cloud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jackhe.cloud.user.entity.User;

/**
 * 数据库关联
 * @author hechangzhi 2017年11月9日
 *
 */
@Repository
public interface UserRepositoryDao extends JpaRepository<User, Long>{

}
