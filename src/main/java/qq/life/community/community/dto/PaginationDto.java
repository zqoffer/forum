package qq.life.community.community.dto;


import java.util.ArrayList;
import java.util.List;
//分页功能
public class PaginationDto {
    private List<QuestionDto> questions;
    private boolean showPre;//上一页按钮
    private boolean showFirst;//首页按钮
    private boolean showNext;//下一页按钮
    private boolean showEnd;

    private Integer currentPage;
    private List<Integer> pages = new ArrayList<>();

    //获得总页数
    public void setPagination(Integer totalCount, Integer currentPage, Integer size) {
        Integer totalPage = 0;

        if(totalCount%size == 0){
            totalPage = totalCount/size;
        }else{
            totalPage = totalCount/size + 1;
        }

        //显示哪些页面数标
        pages.add(currentPage);
        for(int i = 1;i <= 3; i++){
            if(currentPage - i > 0)
                pages.add(0,currentPage-i);
            if(currentPage+i<=totalPage)
                pages.add(currentPage+i);
        }

        if(currentPage == 1){
            showPre = false;
        }else{
            showPre = true;
        }

        if(currentPage ==totalPage){
            showFirst = false;
        }else{
            showFirst = true;
        }

        if(!pages.contains(1)){
            showNext = false;
        }else{
            showNext = true;
        }

        if(!pages.contains(totalPage))
            showEnd = false;
        else
            showEnd = true;
    }



    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public boolean isShowPre() {
        return showPre;
    }

    public void setShowPre(boolean showPre) {
        this.showPre = showPre;
    }

    public boolean isShowFirst() {
        return showFirst;
    }

    public void setShowFirst(boolean showFirst) {
        this.showFirst = showFirst;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowEnd() {
        return showEnd;
    }

    public void setShowEnd(boolean showEnd) {
        this.showEnd = showEnd;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }


}
