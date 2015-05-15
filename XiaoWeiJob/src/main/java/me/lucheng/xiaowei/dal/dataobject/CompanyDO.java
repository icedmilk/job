package me.lucheng.xiaowei.dal.dataobject;

public class CompanyDO {
	private String id;
	private String cname;
	private String cpasswd;
	private String cemail;
	private String cscale;
	private String ctype;
	private String cindustry;
	private String cdescription;

	public CompanyDO() {
	}

	public CompanyDO(String cname, String cpasswd, String cemail, String cscale, String ctype,
			String cindustry, String cdescription) {
		this.cname = cname;
		this.cpasswd = cpasswd;
		this.cemail = cemail;
		this.cscale = cscale;
		this.ctype = ctype;
		this.cindustry = cindustry;
		this.cdescription = cdescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCpasswd() {
		return cpasswd;
	}

	public void setCpasswd(String cpasswd) {
		this.cpasswd = cpasswd;
	}

	public String getCscale() {
		return cscale;
	}

	public void setCscale(String cscale) {
		this.cscale = cscale;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCindustry() {
		return cindustry;
	}

	public void setCindustry(String cindustry) {
		this.cindustry = cindustry;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

}
