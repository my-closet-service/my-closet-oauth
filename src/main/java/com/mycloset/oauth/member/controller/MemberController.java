package com.mycloset.oauth.member.controller;

import com.mycloset.oauth.member.entity.Member;
import com.mycloset.oauth.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping
    public List<Member> all() {
        return memberService.findAll();
    }
}
