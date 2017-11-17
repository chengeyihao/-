package com.shuaichen.crm.utils;
import java.util.List;

/**
 * 用于封装分页的信息
 */
public class PageBean<T> {

    // 必选项
    private int pageNum;  // 第几页
    private int pageSize; // 每页显示的条目数
    private int totalRecord;  // 总的记录数
    // 计算项
    private int startIndex;  // 开始索引
    private int totalPage;    // 总分页数
    // 数据
    private List<T> data;  // 分页数据

    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
    }

    public PageBean(int pageNum, int pageSize, int totalRecord, int totalPage) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
    }

    public PageBean(int pageNum, int pageSize, int totalRecord, int startIndex, int totalPage) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.startIndex = startIndex;
        this.totalPage = totalPage;
    }

    public int getPageNum() { return pageNum;}

    public void setPageNum(int pageNum) { this.pageNum = pageNum;}

    public int getPageSize() { return pageSize;}

    public void setPageSize(int pageSize) { this.pageSize = pageSize;}

    public int getTatalRecord() { return totalRecord;}

    public void setTatalRecord(int tatalRecord) { this.totalRecord = tatalRecord;}

    public int getStartIndex() { return startIndex;}

    public void setStartIndex(int startIndex) { this.startIndex = startIndex;}

    public int getTotalPage() { return totalPage;}

    public void setTotalPage(int totalPage) { this.totalPage = totalPage;}

    public List<T> getData() { return data;}

    public void setData(List<T> data) { this.data = data;}

}
