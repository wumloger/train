package top.wml.train.business.mapper.cust;

import java.util.Date;

/**
 * @author wml
 * @date 2023/11/27
 * @description DailyTrainTicketMapperCust
 **/
public interface DailyTrainTicketMapperCust {
    void updateCountBySell(Date date
            , String trainCode
            , String seatTypeCode
            , Integer minStartIndex
            , Integer maxStartIndex
            , Integer minEndIndex
            , Integer maxEndIndex);
}
