package top.wml.train.common.context;

import lombok.extern.slf4j.Slf4j;
import top.wml.train.common.resp.MemberLoginResp;

@Slf4j
public class LoginMemberContext {
    private static final ThreadLocal<MemberLoginResp> MEMBER = new ThreadLocal<>();

    public static MemberLoginResp getMember() {
        return MEMBER.get();
    }

    public static void setMember(MemberLoginResp member){
        LoginMemberContext.MEMBER.set(member);
    }

    public static Long getId(){
        try {
            return MEMBER.get().getId();
        }catch (Exception e){
            log.error("获取登录会员信息失败",e);
            throw e;
        }

    }
}
