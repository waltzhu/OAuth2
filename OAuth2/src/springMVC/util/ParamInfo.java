package springMVC.util;

import java.io.Serializable;

public class ParamInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2107860926055784053L;
	
	String paramName;
	String paramIdx;
	String paramValue;
	String desc;
	String mac;
	String resv1;
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamIdx() {
		return paramIdx;
	}
	public void setParamIdx(String paramIdx) {
		this.paramIdx = paramIdx;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getResv1() {
		return resv1;
	}
	public void setResv1(String resv1) {
		this.resv1 = resv1;
	}
	
}
