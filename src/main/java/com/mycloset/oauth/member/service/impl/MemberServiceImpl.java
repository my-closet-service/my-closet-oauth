package com.mycloset.oauth.member.service.impl;

import com.mycloset.oauth.member.entity.Member;
import com.mycloset.oauth.member.repository.MemberRepository;
import com.mycloset.oauth.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

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

    @Override
    public UserDetails loadUserByUsername(String userId) {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("user is not exists"));
        detailsChecker.check(member);
        return member;
    }
}
