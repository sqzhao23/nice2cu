package com.sqzhao.nice2cu.service;

import com.sqzhao.nice2cu.dao.MemberDAO;
import com.sqzhao.nice2cu.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: nice2cu
 * @description: member业务类
 * @author: sqzhao
 * @create: 2020-05-01 12:45
 **/
@Service
public class MemberService {
    @Autowired
    MemberDAO memberDAO;

    public void add(Member member) {
        memberDAO.save(member);
    }

}
