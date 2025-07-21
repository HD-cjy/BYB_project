package com.btw09.buyyourbrain.member.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private String userNo; // USER_NO
	private String userId; // USER_ID
	private String userPwd; // PASSWORD
	private String userName; // USER_NAME
	private String email; // EMAIL
	private String phone; // PHONE_NUMBER
	private String address; // ADDRESS_DETAIL
	private Date enrollDate; // JOINED_AT
	private int points; // POINTS
	private String isDelete; // IS_DELETE
	private Date createAt; // CREATE_AT
	private Date updateAt; // UPDATE_AT

}
