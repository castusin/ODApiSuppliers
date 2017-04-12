package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODSaveParkFacilitiesWebservice {
	static Logger logger = Logger.getLogger(ODSaveParkFacilitiesWebservice.class);
	ODSaveParkFacilitiesBL saveParkFacilitiesBL=new ODSaveParkFacilitiesBL();

	public CISResults saveParkFacilities(ODSaveParkFacilitiesModel saveParkFacilities) {
		 CISResults cisResults = saveParkFacilitiesBL.saveParkFacilities(saveParkFacilities);	
		 logger.info("save parkFacilities Webservice " +cisResults );
		 return cisResults;
	}

}
