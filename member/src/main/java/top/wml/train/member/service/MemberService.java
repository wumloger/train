package top.wml.train.member.service;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.wml.train.common.exception.BusinessException;
import top.wml.train.common.exception.BusinessExceptionEnum;
import top.wml.train.common.util.SnowUtil;
import top.wml.train.member.domain.Member;
import top.wml.train.member.domain.MemberExample;
import top.wml.train.member.mapper.MemberMapper;
import top.wml.train.member.req.MemberRegisterReq;
import top.wml.train.member.req.MemberSendCodeReq;

import java.util.List;

@Service
@Slf4j
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public Long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(list)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }

    public void sendCode(MemberSendCodeReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);

        List<Member> list = memberMapper.selectByExample(memberExample);

        if(CollUtil.isEmpty(list)){
            log.info("手机号不存在，插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        }else{
            log.info("手机号存在，不插入记录");
        }

        String code = "8888";
        log.info("生成短信验证码:{}",code);
        log.info("保存短信记录表");
        log.info("对接短信通道");
    }
}
