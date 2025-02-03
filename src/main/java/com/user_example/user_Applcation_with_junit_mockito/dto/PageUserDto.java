package com.user_example.user_Applcation_with_junit_mockito.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;
@Getter
@Setter
public class PageUserDto {

   private int pageNo=0;

   private int pageSize=10;

   private Sort.Direction sortOrder=Sort.Direction.ASC;

   private String sortByCol="id";

   public Pageable getPageable(PageUserDto dto){

       PageRequest request = PageRequest.of(dto.getPageNo(), dto.getPageSize(),dto.getSortOrder(), dto.getSortByCol());
       return request;
   }

}
