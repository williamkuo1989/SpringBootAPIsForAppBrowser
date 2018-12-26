package com.fih.mobilebrowser.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceInfo {
	private String AccId="";
	private String IMEI="";
	private String PSN="";
	private String AnVer="";
	private String Net="";
	private String NetOp="";
	private String SDen="";
	private String Lan="";
	private String PkgName="";
	private String AnVerName="";
	private String AnVerCode="";
	private String Prj="";

	private String PrjProject="";
	private String PrjModel="";
	private String PrjVersion="";
	private String PrjSubversion="";

	@JsonProperty("AccId")
	public String getAccId() {
		return AccId;
	}
	public void setAccId(String AccId) {
		this.AccId = AccId;
	}
	@JsonProperty("IMEI")
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	@JsonProperty("PSN")
	public String getPSN() {
		return PSN;
	}
	public void setPSN(String pSN) {
		PSN = pSN;
	}
	@JsonProperty("AnVer")
	public String getAnVer() {
		return AnVer;
	}
	public void setAnVer(String AnVer) {
		this.AnVer = AnVer;
	}
	@JsonProperty("Net")
	public String getNet() {
		return Net;
	}
	public void setNet(String Net) {
		this.Net = Net;
	}
	@JsonProperty("NetOp")
	public String getNetOp() {
		return NetOp;
	}
	public void setNetOp(String NetOp) {
		this.NetOp = NetOp;
	}
	@JsonProperty("SDen")
	public String getSDen() {
		return SDen;
	}
	public void setSDen(String SDen) {
		this.SDen = SDen;
	}
	@JsonProperty("Lan")
	public String getLan() {
		return Lan;
	}
	public void setLan(String Lan) {
		this.Lan = Lan;
	}
	@JsonProperty("PkgName")
	public String getPkgName() {
		return PkgName;
	}
	public void setPkgName(String PkgName) {
		this.PkgName = PkgName;
	}
	@JsonProperty("AnVerName")
	public String getAnVerName() {
		return AnVerName;
	}
	public void setAnVerName(String AnVerName) {
		this.AnVerName = AnVerName;
	}
	@JsonProperty("AnVerCode")
	public String getAnVerCode() {
		return AnVerCode;
	}
	public void setAnVerCode(String AnVerCode) {
		this.AnVerCode = AnVerCode;
	}
	@JsonProperty("Prj")
	public String getPrj() {
		return Prj;
	}
	public void setPrj(String Prj) {
		this.Prj = Prj;
	}

	public void splitPrj() throws Exception {
		String[] splts = Prj.split("_");
		String[] myElements = new String[4];		
		for (int i = 0 ; i < myElements.length ; i++) {
			if (i < splts.length) {
				myElements[i] = splts[i];
			} else {
				myElements[i] = "";
			}
		}
		PrjProject = myElements[0];
		PrjModel = myElements[1];
		PrjVersion = myElements[2];
		PrjSubversion = myElements[3];
	}

	public String getPrjProject() {
		return PrjProject;
	}

	public String getPrjModel() {
		return PrjModel;
	}

	public String getPrjVersion() {
		return PrjVersion;
	}

	public String getPrjSubversion() {
		return PrjSubversion;
	}
}
