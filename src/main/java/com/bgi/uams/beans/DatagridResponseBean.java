package com.bgi.uams.beans;
import java.util.List;
public class DatagridResponseBean<T>{
private int total;
private List<T> rows;
private int sum;
private int successCounts;
private int failedCounts;
public int getSuccessCounts() {
	return successCounts;
}
public void setSuccessCounts(int successCounts) {
	this.successCounts = successCounts;
}
public int getFailedCounts() {
	return failedCounts;
}
public void setFailedCounts(int failedCounts) {
	this.failedCounts = failedCounts;
}
public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public List<T> getRows() {
	return rows;
}
public void setRows(List<T> rows) {
	this.rows = rows;
}

}
