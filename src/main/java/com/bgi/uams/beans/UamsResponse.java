package com.bgi.uams.beans;
public class UamsResponse {
    /**
     * 状态码（默认为成功）
     */
    private String code = UamsException.ERROR_CODE.SUCCESS;
    /**
     * 错误信息
     */
    private String msg = "success";
    /**
     * 返回结果对象
     */
    private Object rows;
    /**
     * 总条数
     * 
     */
    private Integer total;
    private Integer pageRows;
    private Integer pages;

    public Integer getTotal() {
	return total;
    }

    public void setTotal(Integer total) {
	this.total = total;
    }

    public Integer getPageRows() {
	return pageRows;
    }

    public void setPageRows(Integer rows) {
	this.pageRows = rows;
    }

    public Integer getPages() {
	return pages;
    }

    public void setPages(Integer pages) {
	this.pages = pages;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getMsg() {
	return msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }

    public Object getRows() {
	return rows;
    }

    public void setRows(Object data) {
	this.rows = data;
    }

}
