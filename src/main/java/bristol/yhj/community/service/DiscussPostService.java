package bristol.yhj.community.service;

import bristol.yhj.community.dao.DiscussPostMapper;
import bristol.yhj.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    DiscussPostMapper discussPostMapper;
    public List<DiscussPost> findDiscussPost(int userId, int offset, int limit)
    {
        return discussPostMapper.selectDiscussPost(userId,offset,limit);
    }

    public int findDiscussPostRows(int userId)
    {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
