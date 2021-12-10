package com.mycloset.oauth.member.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name="MEMBER")
@NoArgsConstructor
public class Member implements Serializable {

    @Id
    @NotNull
    @Column(name="USER_ID")
    private String userId;

    @Column(name="USER_PWD")
    private String userPwd;

    @Column(name="USER_NM")
    private String userNm;

    private String gender;

    private Integer height;

    private Integer weight;

    @Column(name="PRIVATE_YN")
    private String privateYn;

    private Instant regdate;
}
