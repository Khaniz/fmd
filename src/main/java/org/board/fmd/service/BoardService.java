package org.board.fmd.service;

import org.board.fmd.dto.BoardDTO;
import org.board.fmd.model.BoardEntity;
import org.board.fmd.persistence.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {

    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    @Autowired
    private BoardRepository boardRepository;

    public BoardDTO testService(){

        BoardEntity entity = BoardEntity.builder()
                .title("제목은 이렇게 바뀝니다.")
                .contents("내용을 채워넣어볼까요?")
                .build();

        boardRepository.save(entity);

        BoardEntity uploadedEntity = boardRepository.findById(entity.getId()).get();

        BoardDTO boardDTO = modelMapper().map(uploadedEntity, BoardDTO.class);

        return boardDTO;
    }

}
