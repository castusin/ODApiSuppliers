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


public class ODSaveParkInfoBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODSaveParkInfoDAO saveParkInfoDAO=(ODSaveParkInfoDAO)ctx.getBean("SaveParkInfoDAO");
	
	 private static final AtomicInteger count = new AtomicInteger(100001); 
	  
	  
	/**
	 * @param saveParkInfo
	 * @return 1 in case of error or 0 if successful
	 */
	public CISResults saveParkInfo(ODSaveParkInfoModel saveParkInfo) {
		
		 // Capture service Start time
		
	         TimeCheck time=new TimeCheck();
	         testServiceTime seriveTimeCheck=new testServiceTime();
	         String serviceStartTime=time.getTimeZone();
		 			
			 final Logger logger = Logger.getLogger(ODSaveParkInfoBL.class);
			 int parkId = count.incrementAndGet();
			 Calendar currentdate = Calendar.getInstance();
		     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE2);
		     formatter.setTimeZone(obj);
		     String ODDate=formatter.format(currentdate.getTime());
		  
			 CISResults CISResults = saveParkInfoDAO.saveParkInfo(saveParkInfo.getAppId(),saveParkInfo.getParktype(),saveParkInfo.getParkSubcategory(),saveParkInfo.getMetro(),saveParkInfo.getLocalArea(),saveParkInfo.getStreetAddress(),saveParkInfo.getCity(),saveParkInfo.getState(),saveParkInfo.getPin(),saveParkInfo.getName(),saveParkInfo.getDescription(),saveParkInfo.getDetails(),parkId,saveParkInfo.getOdRating(),saveParkInfo.getSponsoredFeaturedFlag(),saveParkInfo.getOverviewText(),saveParkInfo.getFaq(),saveParkInfo.getLatitude(),saveParkInfo.getLongitude(),saveParkInfo.getTypeString(),saveParkInfo.getNatureString(),saveParkInfo.getSubCategoryString(),saveParkInfo.getDurationString(),saveParkInfo.getMaxPeople(),ODDate,saveParkInfo.getPopularity(),saveParkInfo.getMinCost1(),saveParkInfo.getMinCost1People(),saveParkInfo.getMinCost2(),saveParkInfo.getMinCost2People(),saveParkInfo.getMinCost3(),saveParkInfo.getMinCost3People(),saveParkInfo.getSpecialOfferPercentage(),saveParkInfo.getSpecialRate(),saveParkInfo.getPhotoUrl(),saveParkInfo.getImagefoldername());
			
			 logger.debug("save ParkInfoBL service" +CISResults);
			 
			   // Capture Service End time

			    String serviceEndTime=time.getTimeZone();
			    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			    logger.info("Database time for save park info service:: " +result );

			 return CISResults;
		}

	}
