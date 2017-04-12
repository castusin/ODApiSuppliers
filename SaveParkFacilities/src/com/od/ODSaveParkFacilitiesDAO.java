package com.od;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class ODSaveParkFacilitiesDAO extends JdbcDaoSupport {

	/**
	 * @param parkId
	 * @param facilityTypeCode
	 * @param facilityTypeDescription
	 * @param ticketType
	 * @param maxQty
	 * @param currentAvailableQty
	 * @param price
	 * @return 1 in case of error or 0 if successful
	 */
	public CISResults saveParkFacilities(int parkId, String facilityTypeCode,
			String facilityTypeDescription, String ticketType, int maxQty,
			int currentAvailableQty, Float price) {
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			// Capture service Start time
			
		     TimeCheck time=new TimeCheck();
		     testServiceTime seriveTimeCheck=new testServiceTime();
		     String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(ODSaveParkFacilitiesQuery.SQL_SAVEPARKSFACILITIES,parkId,facilityTypeCode,facilityTypeDescription,ticketType,maxQty,currentAvailableQty,price);
			   // Capture Service End time

			    String serviceEndTime=time.getTimeZone();
			    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			    logger.info("Query time for save park facilities service:: " +result );

			} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

		return cisResults;  
	}


}
