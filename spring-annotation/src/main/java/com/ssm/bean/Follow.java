package com.ssm.bean;

import java.util.Date;

/**
 * @author interface
 *
 */
public class Follow {
	private int id;
	private int userId;
	private int followUserId;
	private int isValid;
	private Date createDate;
	private Date updateDate;
	
	protected Follow() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFollowUserId() {
		return followUserId;
	}

	public void setFollowUserId(int followUserId) {
		this.followUserId = followUserId;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
