package com.jack.mq.MsgBody;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.mq.MsgBody
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/8 1:59
 * @version: V1.0
 */
public class TradleMsgBody {

    private BigDecimal amount;
    private Date date;
    private Integer type;
    private Integer tradeType;
    private String remark;
    private List<Integer> nameList;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Integer> getNameList() {
        return nameList;
    }

    public void setNameList(List<Integer> nameList) {
        this.nameList = nameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TradleMsgBody that = (TradleMsgBody) o;
        return com.google.common.base.Objects.equal(amount, that.amount) &&
                com.google.common.base.Objects.equal(date, that.date) &&
                com.google.common.base.Objects.equal(type, that.type) &&
                com.google.common.base.Objects.equal(tradeType, that.tradeType) &&
                com.google.common.base.Objects.equal(remark, that.remark) &&
                com.google.common.base.Objects.equal(nameList, that.nameList);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(amount, date, type, tradeType, remark, nameList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TradleMsgBody{");
        sb.append("amount=").append(amount);
        sb.append(", date=").append(date);
        sb.append(", type=").append(type);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", nameList=").append(nameList);
        sb.append('}');
        return sb.toString();
    }
}
