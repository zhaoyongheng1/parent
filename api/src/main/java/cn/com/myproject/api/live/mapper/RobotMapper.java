package cn.com.myproject.api.live.mapper;

import cn.com.myproject.api.live.entity.PO.Robot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/20.
 */
@Mapper
public interface RobotMapper {
    int insert(Robot robot);
    int update(Robot robot);
    List<Robot> getList(@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize);
}
