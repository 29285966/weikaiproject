package com.demo.model;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class JobinfoController extends Controller {
	public void index() {
		setAttr("jobinfo", Jobinfo.me.paginate(getParaToInt(0, 1), 50));
		render("job_info.html");
	}
	
	
	public void save() {
		getModel(Jobinfo.class).save();
		redirect("/jobinfo");
	}
	
	public void edit() {
		setAttr("jobinfo", Jobinfo.me.findById(getParaToInt()));
	}
	
	
	public void update() {
		getModel(Jobinfo.class).update();
		redirect("/jobinfo");
	}
	
	public void delete() {
		Jobinfo.me.deleteById(getParaToInt());
		redirect("/jobinfo");
	}
	@Before(LoginValidator.class)
	public void login(){
		String name=getPara("name");
		String password=getPara("password");
		if(name.equals("admin")&&password.equals("admin")){
			redirect("/jobinfo");
		}else{
			render("/admin/login.html");
		}
		
	}
	
	
	@Override
	public UploadFile getFile() {
		// TODO Auto-generated method stub
		return super.getFile();
	}

}
