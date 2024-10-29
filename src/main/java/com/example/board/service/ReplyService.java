package com.example.board.service;

import com.example.board.dto.ReplyDTO;
import com.example.board.entity.Borad;
import com.example.board.entity.Reply;

import java.util.List;

public interface ReplyService {
    // 댓글 등록 기능
    Long register(ReplyDTO replyDTO);

    // 댓글 수정 기능
    void modify(ReplyDTO replyDTO);

    // 댓글 삭제 기능
    void remove(Long rno);

    // 댓글 목록 반환 기능
    List<ReplyDTO> getList(Long bno);

    // ReplyDTO => Reply(Entity) 변환
    default Reply dtoToEntity(ReplyDTO dto){
        Borad board = Borad.builder()
                .bno(dto.getBno())
                .build();

        Reply reply = Reply.builder()
                .rno(dto.getRno())
                .text(dto.getText())
                .replyer(dto.getReplyer())
                .board(board)
                .build();

        return reply;
    }

    // Reply(Entity) => ReplyDTO 변환
    default ReplyDTO entityToDto(Reply reply){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
                .bno(reply.getBoard().getBno())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();

        return replyDTO;
    }

}
