//路由器

package com.neo.web;

import com.neo.entity.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RountController {
    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String toindex() {
        return "index";
    }


    @GetMapping("/admin/admin")
    public String admin() {
        return "admin";
    }


    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }



   @GetMapping("/toManagerlist")
// RequestMapping用于映射url到控制器类的一个特定处理程序方法。
    public String toManagerlist() {
        return "managerlist";
    }

    @GetMapping("/toBooking")
    public String toBooking(Booking booking,Model model) {
        return "booking";
    }
    @GetMapping("/toBookinglist")
    public String toBookinglist() {
        return "bookinglist";
    }

    @GetMapping("/toComment")
    public String toComment(Booking booking,Model model) {
        model.addAttribute("bookingID", booking.getBookingID());
        return "comment";
    }
    @GetMapping("/toCommentlist")
    public String toCommentlist() {
        return "commentlist";
    }
    @GetMapping("/toNearbyList")
    public String toNearbyList() {
        return "nearbyList";
    }
}