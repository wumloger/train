package top.wml.train.business.req;

import top.wml.train.common.req.PageReq;

public class TrainSeatQueryReq extends PageReq {
    private String trainCode;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
    public String toString() {
    return "TrainSeatQueryReq{" +
    "} " + super.toString();
    }
}
