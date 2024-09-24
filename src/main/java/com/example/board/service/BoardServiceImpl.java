package com.example.board.service;

import com.example.board.dto.BoardDTO;
import com.example.board.dto.PageRequestDTO;
import com.example.board.dto.PageResultDTO;
import com.example.board.entity.Borad;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository repository;
    @Override
    public Long register(BoardDTO dto) {
        Borad board = dtoToEntity(dto);
        repository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

        Function<Object[], BoardDTO> fn = (en -> entityToDTO((Borad) en[0], (Member) en[1], (Long) en[2]));
        Page<Object[]> result = repository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result, fn);
    }
}
