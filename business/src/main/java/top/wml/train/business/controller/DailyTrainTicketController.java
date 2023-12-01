package top.wml.train.business.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wml.train.business.req.DailyTrainTicketQueryReq;
import top.wml.train.business.resp.DailyTrainTicketQueryResp;
import top.wml.train.business.resp.TrainQueryResp;
import top.wml.train.business.service.DailyTrainTicketService;
import top.wml.train.business.service.TrainService;
import top.wml.train.common.resp.CommonResp;
import top.wml.train.common.resp.PageResp;

import java.util.List;

@RestController
@RequestMapping("/daily-train-ticket")
public class DailyTrainTicketController {
    @Resource
    private DailyTrainTicketService dailyTrainTicketService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req){
        PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
        return new CommonResp<>(list);
    }

}
