package com.bgi.uams.beans;

import org.apache.ibatis.type.Alias;

@Alias(value="UamsData")
public class Data extends PaginationParams{
    private String dataId;//data_id   CHAR(32) not null,
    private String dataType;//data_type  VARCHAR2(32) not null,
    private String field;//field VARCHAR(32),
    private String sign;//sign VARCHAR(32),
    private String option;//option VARCHAR(32),
    private String low;//low VARCHAR(32),
    private String high;//high VARCHAR(32)
    private String userId;//
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getDataId() {
        return dataId;
    }
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getOption() {
        return option;
    }
    public void setOption(String option) {
        this.option = option;
    }
    public String getLow() {
        return low;
    }
    public void setLow(String low) {
        this.low = low;
    }
    public String getHigh() {
        return high;
    }
    public void setHigh(String high) {
        this.high = high;
    }
    
}
