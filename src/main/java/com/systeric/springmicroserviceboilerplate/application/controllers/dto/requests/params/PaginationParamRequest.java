package com.systeric.springmicroserviceboilerplate.application.controllers.dto.requests.params;

import lombok.Getter;

@Getter
public class PaginationParamRequest {
    private Integer page = 0;
    private Integer limit = 10;
    private String sortBy = "id";
    private String orderBy = "asc";

    public void setPage(Integer page) {
        if (page == null || page < 0) {
            this.page = 0;
        } else {
            this.page = page;
        }
    }

    public void setLimit(Integer limit) {
        if (limit == null) {
            this.limit = 10;
        } else if (limit > 50) {
            this.limit = 50;
        } else {
            this.limit = limit;
        }
    }

    public void setSortBy(String sortBy) {
        if (sortBy == null || sortBy.isEmpty()) {
            this.sortBy = "id";
        } else {
            this.sortBy = sortBy;
        }
    }

    public void setOrderBy(String orderBy) {
        if (orderBy == null || orderBy.isEmpty()) {
            this.orderBy = "asc";
        } else {
            this.orderBy = orderBy;
        }
    }
}
