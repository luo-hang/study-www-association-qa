package com.shiant.study.core.system.vo;

import com.fasterxml.jackson.annotation.JsonView;
import com.shiant.rmi.user.vo.UserRmiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户信息")
//@Data
//@JsonPropertyOrder({"id","name","displayName","valueColumn","samplecode","organization"})
public class UserVo extends UserRmiVo{

	private static final long serialVersionUID = 8106535274039803470L;
	
	public interface UserBase {}

	public interface UserDetail extends UserBase{}

	@JsonView(UserDetail.class)
	@ApiModelProperty(value = "验证码")  
	String code;//验证码

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
