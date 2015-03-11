package com.ph.sinonet.spring.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate4.type.EncryptedStringType;
import org.springframework.format.annotation.DateTimeFormat;

import com.ph.sinonet.spring.model.constant.EntityConst;


@TypeDef(name="encryptPassword",typeClass=EncryptedStringType.class,parameters={
	@Parameter(value="hibernateStringEncryptor",name="encryptorRegisteredName")
})
@Entity
@Table(name="user")
@DynamicInsert
@DynamicUpdate
public class User{
	
	
	/**
	 * 
	 */
	
	
	private String username;
	
	private String password;
	private Double credit;
	private String email;
	private Date createTime;
	private Date updateTime;
	@Id
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	
	@Column(name="password")
	@Type(type="encryptPassword")
	public String getPassword() {
		return password;
	}
	
	@Column(name="credit")
	public Double getCredit() {
		return credit;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time",columnDefinition=EntityConst.ColumDefinition.TIMESTAMP_UPDATE)
	public Date getUpdateTime() {
		return updateTime;
	}
	

	
	
	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
