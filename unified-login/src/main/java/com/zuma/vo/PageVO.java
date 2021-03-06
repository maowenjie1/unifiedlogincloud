package com.zuma.vo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * author:ZhengXing
 * datetime:2017/10/17 0017 13:44
 * 分页数据
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageVO<T> {
    /**当前页*/
    private Integer pageNo;
    /**每页条数*/
    private Integer pageSize;
    /**总记录数*/
    private Long totalElement;
    /**总页数*/
    private Integer totalPage;
    /**数据*/
    private List<T> list;
    /**当前id*/
    private Long id;

    public PageVO(Integer pageNo, Integer pageSize, Long totalElement, Integer totalPage, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalElement = totalElement;
        this.totalPage = totalPage;
        this.list = list;
    }
}
