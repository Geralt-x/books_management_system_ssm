package com.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;

}
