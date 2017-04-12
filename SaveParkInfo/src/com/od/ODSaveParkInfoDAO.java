package com.od;

import java.sql.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class ODSaveParkInfoDAO extends JdbcDaoSupport {

	/**
	 * @param appId
	 * @param parktype
	 * @param parkSubcategory
	 * @param metro
	 * @param localArea
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param pin
	 * @param name
	 * @param description
	 * @param details
	 * @param parkId
	 * @param odRating
	 * @param sponsoredFeaturedFlag
	 * @param overviewText
	 * @param faq
	 * @param latitude
	 * @param longitude
	 * @param typeString
	 * @param natureString
	 * @param subCategoryString
	 * @param durationString
	 * @param maxPeople
	 * @param ODDate
	 * @param popularity
	 * @param minCost1
	 * @param minCost1People
	 * @param minCost2
	 * @param minCost2People
	 * @param minCost3
	 * @param minCost3People
	 * @param specialOfferPercentage
	 * @param specialRate
	 * @param photoUrl
	 * @param imagefoldername
	 * @return 1 in case of error or 0 if successful
	 */
	public CISResults saveParkInfo(String appId, String parktype,
			String parkSubcategory, String metro, String localArea,
			String streetAddress, String city, String state, String pin,
			String name, String description, String details,int parkId, int odRating,
			String sponsoredFeaturedFlag,  String overviewText, String faq,
			String latitude, String longitude, String typeString,
			String natureString, String subCategoryString,
			String durationString, String maxPeople, String ODDate,
			String popularity, Float minCost1, Float minCost1People,
			Float minCost2, Float minCost2People, Float minCost3,
			Float minCost3People, Float specialOfferPercentage,
			Float specialRate, String photoUrl, String imagefoldername) {
		
		ODSaveParkInfoModel parksInfo=new ODSaveParkInfoModel();
		CISResults CISResults=new CISResults();
		CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			 // Capture service Start time
			
	         TimeCheck time=new TimeCheck();
	         testServiceTime seriveTimeCheck=new testServiceTime();
	         String serviceStartTime=time.getTimeZone();
	         
			getJdbcTemplate().update(ODSaveParkInfoQuery.SQL_SAVEPARKSINFO,appId,parktype,parkSubcategory,metro,localArea, streetAddress,  city,  state,  pin,
					 name,  description,  details, parkId, odRating,
					 sponsoredFeaturedFlag,  overviewText,  faq,
					 latitude,  longitude,  typeString,
					 natureString,  subCategoryString,
					 durationString,  maxPeople,  ODDate,
					 popularity,  minCost1,  minCost1People,
					 minCost2,  minCost2People,  minCost3,
					 minCost3People,  specialOfferPercentage,
					 specialRate,  photoUrl,imagefoldername);
			//CISResults.setResultObject(result);
			   // Capture Service End time

		    String serviceEndTime=time.getTimeZone();
		    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		    logger.info("Query time for save park info service:: " +result );

			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			CISResults.setErrorMessage("Failed At DataAccess");
		}

   		return CISResults;  
	}


}




