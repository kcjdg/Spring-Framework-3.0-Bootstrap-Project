package com.ph.sinonet.spring.enums;

public enum FlagType {
		DISABLE(0),
		ENABLE(1);
		
	private final int type;

	private FlagType(int type) {
		this.type=type;
	}
	
	public final int getType() {
		return type;
	}

	public static FlagType getByBool(boolean isEnable){
		return (isEnable) ? FlagType.ENABLE : FlagType.DISABLE; 
	}
	
	public static FlagType getByNum(int num){
		return (num == 1) ? FlagType.ENABLE : FlagType.DISABLE;
	}
}
