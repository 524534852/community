package bristol.yhj.community.controller;

import bristol.yhj.community.entity.DiscussPost;
import bristol.yhj.community.entity.Page;
import bristol.yhj.community.entity.User;
import bristol.yhj.community.service.DiscussPostService;
import bristol.yhj.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private DiscussPostService discussPostService;

    @RequestMapping(path="/index",method= RequestMethod.GET)
    public String getIndexPage(Model model, Page page)
    {
        List<Map<String,Object>> list=new ArrayList<>();
        page.setPath("/index");
        page.setRows(discussPostService.findDiscussPostRows(0));
        List<DiscussPost> post=discussPostService.findDiscussPost(0,page.getOffset(),page.getLimit());
        if(post!=null) {
            for (DiscussPost p : post) {
                User u = userService.findUserbyId(p.getUserId());
                HashMap<String, Object> map = new HashMap<>();
                map.put("user", u);
                map.put("post", p);
                list.add(map);
            }
        }
        model.addAttribute("discussPosts",list);
        return "/index";
    }
}
