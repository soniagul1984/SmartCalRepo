package userbean;

public class Useralert 
{
	private String username = null; 
	private String alertdate = null;
	private String alertevent = null;
	private String alertsubject = null;
	private String alertbody = null;
	
	public String getAlertdate() 
	{
		return alertdate;
	}
	public void setAlertdate(String alertdate) 
	{
		this.alertdate = alertdate;
	}
	public String getAlertevent() 
	{
		return alertevent;
	}
	public void setAlertevent(String alertevent) 
	{
		this.alertevent = alertevent;
	}
	public String getAlertsubject() 
	{
		return alertsubject;
	}
	public void setAlertsubject(String alertsubject) 
	{
		this.alertsubject = alertsubject;
	}
	public String getAlertbody()
	{
		return alertbody;
	}
	public void setAlertbody(String alertbody)
	{
		this.alertbody = alertbody;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	
	

}
