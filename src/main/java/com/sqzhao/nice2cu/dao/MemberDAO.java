package com.sqzhao.nice2cu.dao;

import com.sqzhao.nice2cu.pojo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sqzhao
 */
public interface MemberDAO extends JpaRepository<Member,Integer> {

}
