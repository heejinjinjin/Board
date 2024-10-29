package com.example.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    // 지연로딩 방식으로 수정 이유: 즉시 로딩을 사용할 경우 불필요한 JOIN을 하므로 성능을 저하시킬 수 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    private Borad board;
}
