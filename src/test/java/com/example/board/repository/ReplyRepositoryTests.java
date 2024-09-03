package com.example.board.repository;

import com.example.board.entity.Borad;
import com.example.board.entity.Member;
import com.example.board.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1, 300).forEach(i ->{
            long bno = (long) (Math.random() * 100 + 1); //1~100사이의 임의의 long 형의 정수 값

            Borad board = Borad.builder()
                    .bno(bno)
                    .build();

            Reply reply = Reply.builder()
                    .text("Reply" + i)
                    .board(board)
                    .replyer("guest")
                    .build();

            replyRepository.save(reply);
        });
    }
}
