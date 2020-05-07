//用户控制器
package com.neo.web;
import com.github.pagehelper.PageHelper;
import com.neo.entity.*;
import com.neo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PageHelper pageHelper;

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/showRoomList")
    public List<Room> showRoomList(Room room) {
        List<Room> roomList=userMapper.showRoomList(room);
        return roomList;
    }
    @RequestMapping("/dologin")
    public Map<String,Object> login(Users users, HttpServletRequest request) {
        users =userMapper.getOneByNameAndPass(users);
        Map<String,Object> map=new ConcurrentHashMap<>();
        if (users !=null){
            map.put("code",200);
            map.put("message","登录成功");
            saveLoginStatus(request, users);
        }else {
            map.put("code",404);
            map.put("message","用户名密码错误");
        }
        return map;
    }
    //保存登陆信息
    public void saveLoginStatus(HttpServletRequest request, Users student) {
        HttpSession session=request.getSession();
        session.setAttribute("userSession",student);
        student=(Users) session.getAttribute("userSession");
        String studentID=student.getUserID();
        System.out.println(studentID);
        session.setMaxInactiveInterval(7*24*60*60);
    }
    @RequestMapping("/register")
    public Map<String,Object> register(Users users) {
        List<Users> usersList =userMapper.getRegister(users);
        Map<String,Object> map=new ConcurrentHashMap<>();
        if (usersList.size()==0){
            userMapper.insert(users);
            map.put("code",200);
            map.put("message","注册成功");
        }else {
            map.put("code",404);
            map.put("message","改用户已存在");
        }
        return map;
    }

    @RequestMapping("/addBooking")
    public Map<String,Object> addBooking(Booking booking,HttpSession session) {
        Map<String,Object> map=new ConcurrentHashMap<>();
        Users users =(Users)session.getAttribute("userSession");
        booking.setUserID(users.getUserID());
        List<Booking> bookingList=userMapper.getBooking(booking);
        if (bookingList.size()>0){
            map.put("code",0);
            return map;
        }
        int count=userMapper.addBooking(booking);
        booking.setRoomState("未付款");
        userMapper.editRoomState(booking);
        if (1!=count){
            map.put("code",404);
        }else {
            map.put("code",200);
        }
        return map;
    }
    @RequestMapping("/showBookingList")
    public List<Booking> showBookingList(Booking booking,HttpSession session) {
        Map<String,Object> map=new ConcurrentHashMap<>();
        Users users =(Users)session.getAttribute("userSession");
        booking.setUserID(users.getUserID());
        List<Booking> bookingList=userMapper.showBookingList(booking);
        return bookingList;
    }
    @RequestMapping("/addComment")
    public Map<String,Object> addComment(Comment comment,HttpSession session) {
        Map<String,Object> map=new ConcurrentHashMap<>();
        Users users =(Users)session.getAttribute("userSession");
        comment.setUserID(users.getUserID());
        int count=userMapper.addComment(comment);
        userMapper.editCommentState(comment);
        if (1!=count){
            map.put("code",404);
        }else {
            map.put("code",200);
        }
        return map;
    }
    @RequestMapping("/showCommentList")
    public List<Comment> showCommentList(Comment comment,HttpSession session) {
        Users users =(Users)session.getAttribute("userSession");
        comment.setUserID(users.getUserID());
        List<Comment> commentList=userMapper.showCommentList(comment);
        return commentList;
    }
    @RequestMapping("/showNearbyList")
    public List<Nearby> showNearbyList() {
        List<Nearby> nearbyList=userMapper.showNearbyList();
        return nearbyList;
    }
    @RequestMapping("/checkbox")
    public Map<String,Object> checkbox(Booking booking,HttpSession session) {
        Map<String,Object> map=new ConcurrentHashMap<>();
        Users users =(Users)session.getAttribute("userSession");
        booking.setUserID(users.getUserID());
        String roomID=booking.getRoomID();
        String[] roomList=roomID.split(",");
        for (String s : roomList) {
            booking.setRoomID(s);
            userMapper.addBooking(booking);
            booking.setRoomState("未付款");
            userMapper.editRoomState(booking);
        }
            map.put("code",200);
        return map;
    }
    @RequestMapping("/pay")
    public Map<String,Object> pay(Booking booking) {
        booking.setRoomState("已付款");
        userMapper.editRoomState(booking);
        Map<String,Object> map=new ConcurrentHashMap<>();
        map.put("code",200);
        return map;
    }
}