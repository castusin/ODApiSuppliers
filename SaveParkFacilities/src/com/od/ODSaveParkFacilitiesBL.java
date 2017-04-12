package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODSaveParkFacilitiesBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODSaveParkFacilitiesDAO saveParkFacilitiesDAO=(ODSaveParkFacilitiesDAO)ctx.getBean("SaveParkFacilitiesDAO");
	
	
	  
	/**
	 * @param saveParkFacilities
	 * @return 1 in case of error or 0 if successful
	 */
	public CISResults saveParkFacilities(ODSaveParkFacilitiesModel saveParkFacilities) {
		
		// Capture service Start time
		
	     TimeCheck time=new TimeCheck();
	     testServiceTime seriveTimeCheck=new testServiceTime();
	     String serviceStartTime=time.getTimeZone();
		 			
			 final Logger logger = Logger.getLogger(ODSaveParkInfoBL.class);
			 int parkId = saveParkFacilities.getParkId();
			 Calendar currentdate = Calendar.getInstance();
		     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE2);
		     formatter.setTimeZone(obj);
		     String ODDate=formatter.format(currentdate.getTime());
		   
			 CISResults cisResults = saveParkFacilitiesDAO.saveParkFacilities(parkId,saveParkFacilities.getFacilityTypeCode(),saveParkFacilities.getFacilityTypeDescription(),saveParkFacilities.getTicketType(),saveParkFacilities.getMaxQty(),saveParkFacilities.getCurrentAvailableQty(),saveParkFacilities.getPrice());
			
			 logger.debug("save ParkInfoBL service" +cisResults);
			   // Capture Service End time

			    String serviceEndTime=time.getTimeZone();
			    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			    logger.info("Database time for save park facilities service:: " +result );

			  
			 return cisResults;
		}

	}
