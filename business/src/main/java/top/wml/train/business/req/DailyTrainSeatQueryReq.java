package top.wml.train.business.req;

import top.wml.train.common.req.PageReq;

public class DailyTrainSeatQueryReq extends PageReq {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
    return "DailyTrainSeatQueryReq{" +
    "} " + super.toString();
    }
}
