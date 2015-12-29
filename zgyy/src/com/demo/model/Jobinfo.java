package com.demo.model;


import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class Jobinfo extends Model<Jobinfo> {
	public static final Jobinfo me = new Jobinfo();
	public Page<Jobinfo> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from job_info order by id desc");
	}
	

}
