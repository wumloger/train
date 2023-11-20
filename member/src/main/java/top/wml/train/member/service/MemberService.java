package top.wml.train.member.service;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.wml.train.member.domain.Member;
import top.wml.train.member.domain.MemberExample;
import top.wml.train.member.mapper.MemberMapper;

import java.util.List;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public Long register(String mobile){
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(list)){
            throw new RuntimeException("手机号已注册");
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
