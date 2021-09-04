package org.zerock.ex2.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="memo_tbl")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemoEntity { //entity class로 데이터베이스의 테이블과 같은 구조로 작성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(length=200, nullable = false)
    private String text;
}
