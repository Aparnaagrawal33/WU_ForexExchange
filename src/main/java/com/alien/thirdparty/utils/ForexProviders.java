package com.alien.thirdparty.utils;

import com.alien.thirdparty.models.LiveForexRates;

public interface ForexProviders {
	
	
	ForexProviders setObject(Float value,String name,LiveForexRates obj);
	
	ForexProviders setObject(Double value, String name, LiveForexRates obj);
	
	

}
