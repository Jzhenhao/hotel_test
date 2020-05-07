//管理员控制器
package com.neo.web;
import com.github.pagehelper.PageHelper;
import com.neo.entity.*;
import com.neo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PageHelper pageHelper;

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/showBookingAllList")
    public List<Booking> showBookingAllList(Booking booking) {
        List<Booking> bookingList=userMapper.showBookingAllList(booking);
        return bookingList;
    }

    @RequestMapping("/live")
    public Map<String,Object> live(Booking booking) {
        booking.setRoomState("已入住");
        userMapper.editRoomState(booking);
        Map<String,Object> map=new ConcurrentHashMap<>();
        map.put("code",200);
        return map;
    }
    @RequestMapping("/recede")
    public Map<String,Object> recede(Booking booking) {
        booking.setRoomState("已退房");
        userMapper.editRoomState(booking);
        Map<String,Object> map=new ConcurrentHashMap<>();
        map.put("code",200);
        return map;
    }
    @RequestMapping("/paySuccess")
    public Map<String,Object> paySuccess(Booking booking) {
        booking.setRoomState("已预订");
        userMapper.editRoomState(booking);
        Map<String,Object> map=new ConcurrentHashMap<>();
        map.put("code",200);
        return map;
    }
}