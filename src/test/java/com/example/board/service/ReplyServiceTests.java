package com.example.board.service;

import com.example.board.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReplyServiceTests {
    @Autowired
    private ReplyService service;

    @Test
    public void testGetList() {
        Long bno = 97L;
        List<ReplyDTO> replyDTOlist = service.getList(bno);
        replyDTOlist.forEach(replyDTO -> System.out.println(replyDTO));
    }
}
