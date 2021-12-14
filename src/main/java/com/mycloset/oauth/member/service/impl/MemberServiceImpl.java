package com.mycloset.oauth.member.service.impl;

import com.mycloset.oauth.member.entity.Member;
import com.mycloset.oauth.member.repository.MemberRepository;
import com.mycloset.oauth.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Collections;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        memberRepository.save(Member.builder()
                .userId("test")
                .userPwd(passwordEncoder.encode("test"))
                .userNm("테스트")
                .gender("M")
                .height(180)
                .weight(80)
                .privateYn("Y")
                .regdate(Instant.now())
                .roles(Collections.singletonList("ROLE_USER"))
                .build()
        );
    }
}
