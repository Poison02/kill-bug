package com.killbug.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Data
public class ListVO<T> implements Serializable {

    private static final long serialVersionUID = 8247610319171014183L;

    private long current;

    private long pages;

    private long size;

    private long total;

    private List<T> records;

}
