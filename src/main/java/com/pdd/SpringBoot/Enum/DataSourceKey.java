package com.pdd.SpringBoot.Enum;

public enum DataSourceKey {
	
	rDaraSource("read"),
	wDataSource("write");
	
	private String key;
	
	private DataSourceKey(String key) {
		this.key=key;
	}
	public String getKey() {
		return key;
	}
}
