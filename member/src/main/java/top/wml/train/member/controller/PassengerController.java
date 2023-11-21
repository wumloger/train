package top.wml.train.member.controller;

import top.wml.train.common.context.LoginMemberContext;
import top.wml.train.common.resp.CommonResp;
import top.wml.train.common.resp.PageResp;
import top.wml.train.member.req.PassengerQueryReq;
import top.wml.train.member.req.PassengerSaveReq;
import top.wml.train.member.resp.PassengerQueryResp;
import top.wml.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

@Resource
private PassengerService passengerService;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req) {
    passengerService.save(req);
    return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req) {
        req.setMemberId(LoginMemberContext.getId());
        PageResp<PassengerQueryResp> list = passengerService.queryList(req);
            return new CommonResp<>(list);
            }

            @DeleteMapping("/delete/{id}")
            public CommonResp<Object> delete(@PathVariable Long id) {
                passengerService.delete(id);
                return new CommonResp<>();
                }
                }