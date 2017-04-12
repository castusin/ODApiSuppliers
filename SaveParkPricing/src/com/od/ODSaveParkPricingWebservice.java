package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODSaveParkPricingWebservice {
	static Logger logger = Logger.getLogger(ODSaveParkFacilitiesWebservice.class);
	ODSaveParkPricingBL saveParkPricingBL=new ODSaveParkPricingBL();

	public CISResults saveParkPricing(ODSaveParkPricingModel saveParkPricing) {
		 CISResults cisResults = saveParkPricingBL.saveParkPricing(saveParkPricing);	
		 logger.info("save parkPricing Webservice " +cisResults );
		 return cisResults;
	}

}
