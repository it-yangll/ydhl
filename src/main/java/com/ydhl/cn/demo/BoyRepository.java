package com.ydhl.cn.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoyRepository extends JpaRepository<Boy,Integer> {

    /**
     * 名称查询
     * @param name
     * @return
     */
    List<Boy> findByName(String name);
}
