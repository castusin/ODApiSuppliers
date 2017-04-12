package com.od;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;

public class ODSaveParkFacilitiesDAO extends JdbcDaoSupport {

	public CISResults saveParkFacilities(int parkId, String facilityTypeCode,
			String facilityTypeDescription, String ticketType, int maxQty,
			int currentAvailableQty, Float price) {
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			 getJdbcTemplate().update(ODSaveParkFacilitiesQuery.SQL_SAVEPARKSFACILITIES,parkId,facilityTypeCode,facilityTypeDescription,ticketType,maxQty,currentAvailableQty,price);
	
			} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

		return cisResults;  
	}


}
