package com.od;

import java.sql.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class ODSaveParkPricingDAO extends JdbcDaoSupport {

	/**
	 * @param parkId
	 * @param roomTypeCode
	 * @param fromDate
	 * @param toDate
	 * @param currentPrice
	 * @return 1 in case of error or 0 if successful
	 */
	public CISResults saveParkPricing(int parkId, String roomTypeCode,
			Date fromDate, Date toDate, float currentPrice) {
		
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{parkId,roomTypeCode,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate};
		try{
			// Capture service Start time
			
		     TimeCheck time=new TimeCheck();
		     testServiceTime seriveTimeCheck=new testServiceTime();
		     String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(ODSaveParkPricingQuery.SQL_SAVEPARKSPRICING,parkId,roomTypeCode,fromDate,toDate,currentPrice);
			   // Capture Service End time

			    String serviceEndTime=time.getTimeZone();
			    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			    logger.info("Query time for save park pricing service:: " +result );

			} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

		return cisResults;  
	}

}
