package top.wml.train.member.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.wml.train.common.resp.CommonResp;
import top.wml.train.member.req.MemberRegisterReq;
import top.wml.train.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public Integer count(){
        return memberService.count();
    }

    @PostMapping("/register")
    public CommonResp<Long> register( MemberRegisterReq req){
        Long register = memberService.register(req);
        return new CommonResp<Long>(register);
    }
}
