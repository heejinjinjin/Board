package com.example.board.service;

import com.example.board.dto.BoardDTO;
import com.example.board.entity.Borad;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
