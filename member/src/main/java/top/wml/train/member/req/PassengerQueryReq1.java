package top.wml.train.member.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.wml.train.common.req.PageReq;
@EqualsAndHashCode(callSuper = true)
@Data
public class PassengerQueryReq1 extends PageReq {
    private Long memberId;
}
