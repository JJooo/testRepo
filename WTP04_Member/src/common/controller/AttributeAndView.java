package common.controller;

import java.util.HashMap;
import java.util.Map;

public class AttributeAndView {
	private String url;
	private boolean redirect;
	private Map<String, Object> attribute;
	//생성자
	public AttributeAndView(){}
	
	public AttributeAndView(String url, boolean redirect) {
		this.url = url;
		this.redirect = redirect;
	}
	//Attribute가 1개 이상일 경우 값 받는 생성자
	public AttributeAndView(String url, boolean redirect, Map<String, Object> attribute) {
		this.url = url;
		this.redirect = redirect;
		this.attribute = attribute;
	}
	//attribute가 하나일 경우 값 받는 생성자
	public AttributeAndView(String url, boolean redirect, String attributeName, Object attributeValue){
		this.url = url;
		this.redirect = redirect;
		attribute = new HashMap<String, Object>();
		attribute.put(attributeName, attributeValue);
	}
	//setter/getter

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public Map<String, Object> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, Object> attribute) {
		this.attribute = attribute;
	}
	//toString()

	@Override
	public String toString() {
		return "AttributeAndView [url=" + url + ", redirect=" + redirect
				+ ", attribute=" + attribute + "]";
	}
}
