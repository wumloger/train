package top.wml.train.batch.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.wml.train.common.resp.CommonResp;

import java.util.Date;

//@FeignClient(name = "business",url = "http://127.0.0.1:8002/business")
@FeignClient(name = "business",path = "/business")
public interface BusinessFeign {

    @GetMapping("/hello")
    String getHello();

    @GetMapping("/admin/daily-train/gen-daily/{date}")
    CommonResp<Object> genDaily(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date);
}
