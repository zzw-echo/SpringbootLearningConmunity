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
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        showFirstPage = true;
        showEndPage = true;
        showPrevious = true;
        showNext = true;
        if (totalCount % size == 0){
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1){
            page = 1;
        }
        if (page > totalPage){
            page = totalPage;
        }
        this.page = page;

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0){
                pages.add(0, page - i);
            }
            if (page + i <= totalPage){
                pages.add(page + i);
            }
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
