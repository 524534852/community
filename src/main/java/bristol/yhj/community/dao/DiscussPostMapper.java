package bristol.yhj.community.dao;

import bristol.yhj.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    public List<DiscussPost> selectDiscussPost(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);
    public int selectDiscussPostRows(@Param("userId")int userId);

}
