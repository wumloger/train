package top.wml.train.business.req;

import org.springframework.format.annotation.DateTimeFormat;
import top.wml.train.common.req.PageReq;

import java.util.Date;

public class DailyTrainCarriageQueryReq extends PageReq {
    private String code;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
    return "DailyTrainCarriageQueryReq{" +
    "} " + super.toString();
    }
}
