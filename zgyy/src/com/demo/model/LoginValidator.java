package com.demo.model;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("name", "namemsg", "用户名不能为空");
		validateRequiredString("password", "pwdmsg", "密码不能为空");
		
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.keepPara("name");
		c.render("/admin/login.html");
		
	}

}
