package com.od;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class ODSaveParkRoomsDAO extends JdbcDaoSupport{

	
	/**
	 * @param parkId
	 * @param facilityTypeCode
	 * @param facilityType
	 * @param rommTypeDescription
	 * @param maxPeople
	 * @param maxAdults
	 * @param maxKids
	 * @param maxQty
	 * @param regularPrice
	 * @param oDDate
	 * @return 1 in case of error or 0 if successful
	 */
	public CISResults saveParkRooms(int parkId, String facilityTypeCode,
			String facilityType, String rommTypeDescription, String maxPeople, String maxAdults,
			String maxKids, String maxQty, String regularPrice, String oDDate) {
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			// Capture service Start time
			
		     TimeCheck time=new TimeCheck();
		     testServiceTime seriveTimeCheck=new testServiceTime();
		     String serviceStartTime=time.getTimeZone();
			 
			 getJdbcTemplate().update(ODSaveParkRoomsQuery.SQL_SAVEPARKSROOMS,parkId,facilityTypeCode,facilityType,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate);
			 // Capture Service End time

			    String serviceEndTime=time.getTimeZone();
			    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			    logger.info("Query  time for save park rooms service:: " +result );
			} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

 		return cisResults;  

	}

	
}
