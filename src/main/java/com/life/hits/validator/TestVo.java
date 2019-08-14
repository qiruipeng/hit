package com.life.hits.validator;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/** 测试校验类
 * @author: qirp
 * @since: 2019/5/20 10:38
 **/
@Data
public class TestVo {
    @NotNull(message = "应还月供不能为空！")
    private BigDecimal repaymentMounth;
    @NotNull(message = "还款编号不能为空！")
    private String repaymentNum;
    @NotNull(message = "邮件不能为空！")
    @Email
    private String mail;
    private String adress;
}
