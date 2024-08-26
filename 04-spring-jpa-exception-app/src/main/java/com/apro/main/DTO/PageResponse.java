package com.apro.main.DTO;

import java.util.List;

import com.apro.main.entity.Student;

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
    

}
