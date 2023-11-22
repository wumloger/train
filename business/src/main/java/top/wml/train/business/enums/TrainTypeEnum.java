package top.wml.train.business.enums;

import lombok.Getter;
import top.wml.train.business.domain.TrainExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

@Getter
public enum TrainTypeEnum {
    G("G","高铁",new BigDecimal("1.2")),
    D("D","动车",new BigDecimal("1")),
    K("K","快车",new BigDecimal("0.8")),
    ;

    private String code;

    private String desc;

    private BigDecimal priceRate;

    TrainTypeEnum(String code, String desc, BigDecimal priceRate) {
        this.code = code;
        this.desc = desc;
        this.priceRate = priceRate;
    }

    @Override
    public String toString() {
        return "TrainTypeEnum{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", priceRate=" + priceRate +
                '}';
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPriceRate(BigDecimal priceRate) {
        this.priceRate = priceRate;
    }

    public static List<HashMap<String,String>> getEnumList(){
        List<HashMap<String,String >> list = new ArrayList<>();
        for (TrainTypeEnum anEnum : EnumSet.allOf(TrainTypeEnum.class)){
            HashMap<String,String> map = new HashMap<>();
            map.put("code",anEnum.code);
            map.put("desc", anEnum.desc);
            list.add(map);
        }
        return list;
    }
}
