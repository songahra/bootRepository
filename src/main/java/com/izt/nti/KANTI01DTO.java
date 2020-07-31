package com.izt.nti;

public class KANTI01DTO {
    
    public String sortType;
    public String search_title;

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSearch_title() {
        return search_title;
    }

    public void setSearch_title(String search_title) {
        this.search_title = search_title;
    }

    @Override
    public String toString() {
        return "KANTI01VO [sortType=" + sortType + ", search_title=" + search_title + "]";
    }

}