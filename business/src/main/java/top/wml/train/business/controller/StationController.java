package top.wml.train.business.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wml.train.business.resp.StationQueryResp;
import top.wml.train.business.resp.TrainQueryResp;
import top.wml.train.business.service.StationService;
import top.wml.train.business.service.TrainService;
import top.wml.train.common.resp.CommonResp;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {
    @Resource
    private StationService stationService;

    @GetMapping("/query-all")
    public CommonResp<List<StationQueryResp>> queryList(){
        List<StationQueryResp> list = stationService.queryAll();
        return new CommonResp<>(list);
    }
}
