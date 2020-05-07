package com.neo.mapper;


import com.neo.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

	@Select("SELECT * FROM users WHERE userName = #{userName} and userPassword=#{userPassword}")
	Users getOneByNameAndPass(Users users);

	@Select("<script>SELECT * FROM room where 1=1 <if test='startDate!=\"\" and endDate!=\"\"'> and roomDate&gt;=#{startDate} and roomDate&lt;=#{endDate}</if></script>")
	List<Room> showRoomList(Room room);

	@Update("update room set roomState=#{roomState} where roomID=#{roomID}")
	void editRoomState(Booking booking);

	@Insert("insert into users (userName,userPassword) value(#{userName},#{userPassword})")
	void insert(Users users);

	@Select("SELECT * FROM users WHERE userName= #{userName}")
	List<Users> getRegister(Users users);

	@Select("SELECT * FROM booking WHERE userID = #{userID} and roomID=#{roomID}")
	List<Booking> getBooking(Booking booking);

	@Select("SELECT * FROM booking c left join room b on c.roomID=b.roomID where c.userID=#{userID}")
	List<Booking> showBookingList(Booking booking);

	@Select("SELECT * FROM booking b left join room r on b.roomID=r.roomID left join users u on b.userID=u.userID ")
	List<Booking> showBookingAllList(Booking booking);

	@Insert("insert into booking (userID,roomID,commentState) value(#{userID},#{roomID},'未评价')")
	int addBooking(Booking booking);


	@Insert("insert into comment (userID,bookingID,content,commentDate) value(#{userID},#{bookingID},#{content},CURDATE())")
	int addComment(Comment comment);

	@Update("update booking set commentState='已评价' where bookingID=#{bookingID}")
	void editCommentState(Comment comment);

	@Select("SELECT * FROM comment c " +
			"left join booking b on c.bookingID=b.bookingID " +
			"left join room r  on b.roomID=r.roomID " +
			"left join users u on c.userID=u.userID")
	List<Comment> showCommentList(Comment comment);

	@Select("SELECT * FROM nearby")
	List<Nearby> showNearbyList();
}