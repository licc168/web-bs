package com.licc.dao.po;


import com.licc.dao.base.IEntity;

import java.util.Date;

/**
 *  
 */
public class TalentUser implements IEntity {
    /**
     *  ID
     */
    private Long id;

    /**
     *  聚贸达人名字
     */
    private String name;

    /**
     *  聚贸达人手机号
     */
    private String mobile;

    /**
     *  身份证号
     */
    private String idCard;

    /**
     *  擅长品种
     */
    private Integer product;

    /**
     *  推荐码
     */
    private String referralCode;

    /**
     *  上级ID
     */
    private Long parentId;

    /**
     *  关联用户ID
     */
    private Long userId;

    /**
     *  行业ID
     */
    private Long industryId;

    /**
     *  状态@0:启用 1:停用
     */
    private Integer status;

    /**
     *  停用时间
     */
    private Date noTime;

    /**
     *  启用时间
     */
    private Date openTime;

    /**
     *  创建时间-注册时间
     */
    private Date createTime;

    /**
     *  修改时间
     */
    private Date updateTime;

    /**
     *  描述
     */
    private String remart;

    private static final long serialVersionUID = 1L;

    /**
     * 获取字段 talent_user.ID
     *
     * @return the value of talent_user.ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置字段 talent_user.ID
     *
     * @param id the value for talent_user.ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字段 talent_user.NAME
     *
     * @return the value of talent_user.NAME
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字段 talent_user.NAME
     *
     * @param name the value for talent_user.NAME
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取字段 talent_user.MOBILE
     *
     * @return the value of talent_user.MOBILE
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置字段 talent_user.MOBILE
     *
     * @param mobile the value for talent_user.MOBILE
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取字段 talent_user.ID_CARD
     *
     * @return the value of talent_user.ID_CARD
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置字段 talent_user.ID_CARD
     *
     * @param idCard the value for talent_user.ID_CARD
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取字段 talent_user.PRODUCT
     *
     * @return the value of talent_user.PRODUCT
     */
    public Integer getProduct() {
        return product;
    }

    /**
     * 设置字段 talent_user.PRODUCT
     *
     * @param product the value for talent_user.PRODUCT
     */
    public void setProduct(Integer product) {
        this.product = product;
    }

    /**
     * 获取字段 talent_user.REFERRAL_CODE
     *
     * @return the value of talent_user.REFERRAL_CODE
     */
    public String getReferralCode() {
        return referralCode;
    }

    /**
     * 设置字段 talent_user.REFERRAL_CODE
     *
     * @param referralCode the value for talent_user.REFERRAL_CODE
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode == null ? null : referralCode.trim();
    }

    /**
     * 获取字段 talent_user.PARENT_ID
     *
     * @return the value of talent_user.PARENT_ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置字段 talent_user.PARENT_ID
     *
     * @param parentId the value for talent_user.PARENT_ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取字段 talent_user.USER_ID
     *
     * @return the value of talent_user.USER_ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置字段 talent_user.USER_ID
     *
     * @param userId the value for talent_user.USER_ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取字段 talent_user.INDUSTRY_ID
     *
     * @return the value of talent_user.INDUSTRY_ID
     */
    public Long getIndustryId() {
        return industryId;
    }

    /**
     * 设置字段 talent_user.INDUSTRY_ID
     *
     * @param industryId the value for talent_user.INDUSTRY_ID
     */
    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    /**
     * 获取字段 talent_user.STATUS
     *
     * @return the value of talent_user.STATUS
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置字段 talent_user.STATUS
     *
     * @param status the value for talent_user.STATUS
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取字段 talent_user.NO_TIME
     *
     * @return the value of talent_user.NO_TIME
     */
    public Date getNoTime() {
        return noTime;
    }

    /**
     * 设置字段 talent_user.NO_TIME
     *
     * @param noTime the value for talent_user.NO_TIME
     */
    public void setNoTime(Date noTime) {
        this.noTime = noTime;
    }

    /**
     * 获取字段 talent_user.OPEN_TIME
     *
     * @return the value of talent_user.OPEN_TIME
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 设置字段 talent_user.OPEN_TIME
     *
     * @param openTime the value for talent_user.OPEN_TIME
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取字段 talent_user.CREATE_TIME
     *
     * @return the value of talent_user.CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置字段 talent_user.CREATE_TIME
     *
     * @param createTime the value for talent_user.CREATE_TIME
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取字段 talent_user.UPDATE_TIME
     *
     * @return the value of talent_user.UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置字段 talent_user.UPDATE_TIME
     *
     * @param updateTime the value for talent_user.UPDATE_TIME
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取字段 talent_user.REMART
     *
     * @return the value of talent_user.REMART
     */
    public String getRemart() {
        return remart;
    }

    /**
     * 设置字段 talent_user.REMART
     *
     * @param remart the value for talent_user.REMART
     */
    public void setRemart(String remart) {
        this.remart = remart == null ? null : remart.trim();
    }
}