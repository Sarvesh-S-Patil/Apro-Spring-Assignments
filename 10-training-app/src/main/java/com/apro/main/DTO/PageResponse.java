package com.apro.main.DTO;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PageResponse<T>{
    int totalPages;
    long totalElements;
    int size;
    List<T> Content;
    boolean isLastPage;
    
    public PageResponse(Page<T> page) {
    	this.Content = page.getContent();
    	this.totalElements=page.getTotalElements();
    	this.totalPages=page.getTotalPages();
    	this.size=page.getSize();
    	this.isLastPage=page.isLast();
    }
    

}
