package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserDao;
import tool.Tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/loginlayui.action")
    @ResponseBody
    public Map<String,String> loginlayui(@RequestBody User user){

        HttpSession session = request.getSession();
        User loginUser = userDao.login(user);
        Map<String, String> msg = new HashMap<>();
        if (loginUser != null){
            session.setAttribute("user", loginUser);
            msg.put("msg", "success");
            return msg;
        }else{
            msg.put("msg", "false");
            return msg;
        }
    }

    @RequestMapping("/userListPage.action")
    public String userListPage(){
        return "userList";
    }


    @RequestMapping("/userList.action")
    @ResponseBody
    public Map<String,Object> userList(){
        List<User> userList = userDao.getUserList();
        return Tool.testLayui(userList,0,0);
    }


    @RequestMapping("/userList2.action")
    @ResponseBody
    public Map<String,Object> UserList2(int page,int limit){
        HashMap<String,Integer> map = new HashMap<>();
        int pagestart = (page - 1) * limit;
        map.put("pagestart",pagestart);
        map.put("size",limit);
        List<User> userList = userDao.getUserList2(map);
        Integer pagecount = userDao.userCount();
        Map<String,Object> returnTable = Tool.testLayui(userList,page,limit);
        returnTable.put("count",pagecount);
        return returnTable;
    }

    @RequestMapping("/updateUserList.action")
    @ResponseBody
    public int updateUserList(User user){
        return userDao.updateUserList(user);
    }

}
