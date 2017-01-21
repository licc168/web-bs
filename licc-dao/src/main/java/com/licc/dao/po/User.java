package com.licc.dao.po;

import com.licc.dao.base.IEntity;
import java.util.Date;

/**
 *  
 */
public class User implements IEntity {
    /**
     *  
     */
    private Long id;

    /**
     *  用户昵称
     */
    private String nickname;

    /**
     *  邮箱|登录帐号
     */
    private String email;

    /**
     *  密码
     */
    private String pswd;

    /**
     *  创建时间
     */
    private Date createTime;

    /**N
     *  最后登录时间
     */
    private Date lastLoginTime;

    /**
     *  1:有效，0:禁止登录
     */
    private Long status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 u_user.id
     *
     * @return the value of u_user.id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置字段 u_user.id
     *
     * @param id the value for u_user.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字段 u_user.nickname
     *
     * @return the value of u_user.nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置字段 u_user.nickname
     *
     * @param nickname the value for u_user.nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取字段 u_user.email
     *
     * @return the value of u_user.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置字段 u_user.email
     *
     * @param email the value for u_user.email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取字段 u_user.pswd
     *
     * @return the value of u_user.pswd
     */
    public String getPswd() {
        return pswd;
    }

    /**
     * 设置字段 u_user.pswd
     *
     * @param pswd the value for u_user.pswd
     */
    public void setPswd(String pswd) {
        this.pswd = pswd == null ? null : pswd.trim();
    }

    /**
     * 获取字段 u_user.create_time
     *
     * @return the value of u_user.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置字段 u_user.create_time
     *
     * @param createTime the value for u_user.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取字段 u_user.last_login_time
     *
     * @return the value of u_user.last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置字段 u_user.last_login_time
     *
     * @param lastLoginTime the value for u_user.last_login_time
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取字段 u_user.status
     *
     * @return the value of u_user.status
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置字段 u_user.status
     *
     * @param status the value for u_user.status
     */
    public void setStatus(Long status) {
        this.status = status;
    }
}