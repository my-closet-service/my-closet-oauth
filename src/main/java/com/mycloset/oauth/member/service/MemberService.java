package com.mycloset.oauth.member.service;

import com.mycloset.oauth.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService{
    List<Member> findAll();
}
