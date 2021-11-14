package org.board.fmd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.board.fmd.model.BoardEntity;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private String id;
    private String userId;
    private String title;
    private String contents;
    private String category;
    private String day;
    private int calories;
    private Timestamp date;
    private String thumbnail;

    public BoardDTO(final BoardEntity boardEntity){
        this.id = boardEntity.getId();
        this.userId = boardEntity.getUserId();
        this.title = boardEntity.getTitle();
        this.contents = boardEntity.getContents();
        this.category = boardEntity.getCategory();
        this.day = boardEntity.getDay();
        this.calories = boardEntity.getCalories();
        this.date = boardEntity.getDate();
        this.thumbnail = boardEntity.getThumbnail();
    }

}
