package com.hospitality.common.util;

public enum PaymentType {
	CASH("cash", "cash"),
	POS("pos", "pos"),
	DD("dd", "dd"),
	OTHER("other", "other"),
	ONLINE("online", "online");
	
	private final String key;
    private final String value;

    PaymentType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

}
