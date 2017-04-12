package com.od;

import java.sql.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;

public class ODSaveParkPricingDAO extends JdbcDaoSupport {

	public CISResults saveParkPricing(int parkId, String roomTypeCode,
			Date fromDate, Date toDate, float currentPrice) {
		
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{parkId,roomTypeCode,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate};
		try{
			 getJdbcTemplate().update(ODSaveParkPricingQuery.SQL_SAVEPARKSPRICING,parkId,roomTypeCode,fromDate,toDate,currentPrice);
	
			} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

		return cisResults;  
	}

}
