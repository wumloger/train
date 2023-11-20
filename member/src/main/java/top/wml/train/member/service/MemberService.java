package top.wml.train.member.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.wml.train.member.mapper.MemberMapper;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return memberMapper.count();
    }
}
