package me.lucheng.xiaowei.dal.dataobject;

public class JobDO {
	private String id;
	private String cid;
	private String jname;
	private String jtype;
	private String jlocation;
	private String jdegree;
	private String jsalary;
	private String jexperience;
	private String jdescription;

	public JobDO() {
		super();
	}

	public JobDO(String cid, String jname, String jtype, String jlocation, String jdegree,
			String jsalary, String jexperience, String jdescription) {
		super();
		this.cid = cid;
		this.jname = jname;
		this.jtype = jtype;
		this.jlocation = jlocation;
		this.jdegree = jdegree;
		this.jsalary = jsalary;
		this.jexperience = jexperience;
		this.jdescription = jdescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public String getJtype() {
		return jtype;
	}

	public void setJtype(String jtype) {
		this.jtype = jtype;
	}

	public String getJlocation() {
		return jlocation;
	}

	public void setJlocation(String jlocation) {
		this.jlocation = jlocation;
	}

	public String getJdegree() {
		return jdegree;
	}

	public void setJdegree(String jdegree) {
		this.jdegree = jdegree;
	}

	public String getJsalary() {
		return jsalary;
	}

	public void setJsalary(String jsalary) {
		this.jsalary = jsalary;
	}

	public String getJexperience() {
		return jexperience;
	}

	public void setJexperience(String jexperience) {
		this.jexperience = jexperience;
	}

	public String getJdescription() {
		return jdescription;
	}

	public void setJdescription(String jdescription) {
		this.jdescription = jdescription;
	}
}
