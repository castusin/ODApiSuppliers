package com.od;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;

public class ODSaveParkRoomsDAO extends JdbcDaoSupport{

	
	public CISResults saveParkRooms(int parkId, String facilityTypeCode,
			String facilityType, String rommTypeDescription, String maxPeople, String maxAdults,
			String maxKids, String maxQty, String regularPrice, String oDDate) {
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			 getJdbcTemplate().update(ODSaveParkRoomsQuery.SQL_SAVEPARKSROOMS,parkId,facilityTypeCode,facilityType,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate);
	
			} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

 		return cisResults;  

	}

	
}
