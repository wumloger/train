package top.wml.train.common.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.wml.train.common.context.LoginMemberContext;
import top.wml.train.common.resp.MemberLoginResp;
import top.wml.train.common.util.JwtUtil;

@Component
@Slf4j
public class MemberInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(StrUtil.isNotBlank(token)){
            log.info("获取会员登录token:{}",token);
            JSONObject loginMember = JwtUtil.getJSONObject(token);
            log.info("当前登录会员:{}",loginMember);
            MemberLoginResp member = JSONUtil.toBean(loginMember,MemberLoginResp.class);
            LoginMemberContext.setMember(member);
        }

        return true;
    }
}
