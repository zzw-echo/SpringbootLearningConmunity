package life.echo.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzewen on 2020/1/7
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        showFirstPage = true;
        showEndPage = true;
        showPrevious = true;
        showNext = true;
        Integer totalPage;
        if (totalCount % size == 0){
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page == 1) {
            showPrevious = false;
        }
        if (page == totalPage) {
            showNext = false;
        }

        if (pages.contains(1)){
            showFirstPage = false;
        }

        if (pages.contains(totalPage)){
            showEndPage = false;
        }

    }
}
