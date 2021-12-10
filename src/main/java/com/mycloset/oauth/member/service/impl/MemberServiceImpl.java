package com.mycloset.oauth.member.service.impl;

import com.mycloset.oauth.member.entity.Member;
import com.mycloset.oauth.member.repository.MemberRepository;
import com.mycloset.oauth.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    @PostConstruct
    public void init(){
        Optional<Member> memop = memberRepository.findById("user");
        if(!memop.isPresent()){
            Member member = new Member();
            member.setUserId("user");
            member.setUserPwd("{noop}test");
            member.setGender("M");
            member.setHeight(180);
            member.setWeight(100);
            member.setUserNm("유저");
            member.setPrivateYn("Y");
            member.setRegdate(Instant.now());

            memberRepository.save(member);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<Member> memop = memberRepository.findById(userId);
        if (memop.isPresent()) {
            Member member = memop.get();
            return new org.springframework.security.core.userdetails.User(member.getUserNm(),member.getUserPwd(), getAuthorities());
        } else {
            return null;
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
