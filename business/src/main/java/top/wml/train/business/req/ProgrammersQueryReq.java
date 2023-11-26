package top.wml.train.business.req;

import top.wml.train.common.req.PageReq;

public class ProgrammersQueryReq extends PageReq {
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
    return "ProgrammersQueryReq{" +
    "} " + super.toString();
    }
}
