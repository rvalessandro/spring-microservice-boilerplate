package com.systeric.springmicroserviceboilerplate.foundation.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ListResponse<T> extends BaseResponse {

    List<T> data;
    private int page;
    private int limit;
    private int totalPages;
    private int numberOfElements;
    private long totalElements;
    private boolean previousPage;
    private boolean first;
    private boolean nextPage;
    private boolean last;

    public ListResponse(Page<T> page) {
        super("Success", HttpStatus.OK.value());
        this.page = page.getNumber();
        this.limit = page.getSize();
        this.totalPages = page.getTotalPages();
        this.numberOfElements = page.getNumberOfElements();
        this.totalElements = page.getTotalElements();
        this.previousPage = page.hasPrevious();
        this.first = page.isFirst();
        this.nextPage = page.hasNext();
        this.last = page.isLast();
        this.data = page.getContent();
    }
}
