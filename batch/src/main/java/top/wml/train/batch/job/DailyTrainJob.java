package top.wml.train.batch.job;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import top.wml.train.batch.feign.BusinessFeign;
import top.wml.train.common.resp.CommonResp;

import java.util.Date;

@DisallowConcurrentExecution
public class DailyTrainJob implements Job {

    public static final Logger LOG = LoggerFactory.getLogger(DailyTrainJob.class);

    @Resource
    private BusinessFeign businessFeign;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        MDC.put("LOG_ID",System.currentTimeMillis() + RandomUtil.randomString(3));
        LOG.info("生成5天后的定时任务开始");
        Date today = new Date();
        DateTime dateTime = DateUtil.offsetDay(today, 5);
        Date offsetDay = dateTime.toJdkDate();
        CommonResp<Object> commonResp = businessFeign.genDaily(offsetDay);
        LOG.info("生成5天后的定时任务结束");
    }
}
