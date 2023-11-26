package top.wml.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.wml.train.business.domain.Programmers;
import top.wml.train.business.domain.ProgrammersExample;

public interface ProgrammersMapper {
    long countByExample(ProgrammersExample example);

    int deleteByExample(ProgrammersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Programmers row);

    int insertSelective(Programmers row);

    List<Programmers> selectByExample(ProgrammersExample example);

    Programmers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Programmers row, @Param("example") ProgrammersExample example);

    int updateByExample(@Param("row") Programmers row, @Param("example") ProgrammersExample example);

    int updateByPrimaryKeySelective(Programmers row);

    int updateByPrimaryKey(Programmers row);
}