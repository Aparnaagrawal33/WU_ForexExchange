package com.alien.thirdparty.utils;

import com.alien.thirdparty.models.LiveForexRates;

public interface ForexProviders {
	
	
	void setObject(Float value,String name,LiveForexRates obj);
	
	void setObject(Double value, String name, LiveForexRates obj);
	
	

}
