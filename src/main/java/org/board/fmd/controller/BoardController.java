package org.board.fmd.controller;

import lombok.extern.log4j.Log4j2;
import org.board.fmd.dto.BoardDTO;
import org.board.fmd.dto.ResponseDTO;
import org.board.fmd.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Log4j2
@RestController
@RequestMapping("/test")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public ResponseEntity<?> list(){

        log.info("------------testService call");
        BoardDTO list = service.testService();
        log.info("-------------success test");

        ResponseDTO<Object> response = ResponseDTO.builder()
                .data(list)
                .build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/read")
    public String read(@RequestParam(required = false) int id ){
        return "read page for" + id;
    }



}
