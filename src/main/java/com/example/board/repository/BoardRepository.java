package com.example.board.repository;

import com.example.board.entity.Borad;
import com.example.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Borad, Long> {
    @Query("select b, w from Borad b left join b.writer w where b.bno=:bno")
    Object getBoardWithWriter(@Param("bno") Long bno);
}
