package com.utilities;

public class PropertiesInitializer {

	private String testUrl;
	private String browser;
	private String extentRptAuthId;
	private String extentRptAuthPwd;
	private String extentRptSendTO;
	private String extentRptSendCc;
	private String extentRptSubject;
	private String extentRptMailBody;

	public String getTestUrl() {
		return testUrl;
	}

	public void setTestUrl(String url) {
		this.testUrl = url;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getExtentRptAuthId() {
		return extentRptAuthId;
	}

	public void setExtentRptAuthId(String extentRptAuthId) {
		this.extentRptAuthId = extentRptAuthId;
	}

	public String getExtentRptAuthPwd() {
		return extentRptAuthPwd;
	}

	public void setExtentRptAuthPwd(String extentRptAuthPwd) {
		this.extentRptAuthPwd = extentRptAuthPwd;
	}

	public String getExtentRptSendTO() {
		return extentRptSendTO;
	}

	public void setExtentRptSendTO(String extentRptSendTO) {
		this.extentRptSendTO = extentRptSendTO;
	}

	public String getExtentRptSendCc() {
		return extentRptSendCc;
	}

	public void setExtentRptSendCc(String extentRptSendCc) {
		this.extentRptSendCc = extentRptSendCc;
	}

	public String getExtentRptSubject() {
		return extentRptSubject;
	}

	public void setExtentRptSubject(String extentRptSubject) {
		this.extentRptSubject = extentRptSubject;
	}

	public String getExtentRptMailBody() {
		return extentRptMailBody;
	}

	public void setExtentRptMailBody(String extentRptMailBody) {
		this.extentRptMailBody = extentRptMailBody;
	}

}
