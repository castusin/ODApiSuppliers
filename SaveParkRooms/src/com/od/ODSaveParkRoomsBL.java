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


public class ODSaveParkRoomsBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODSaveParkRoomsDAO parkRoomsDAO=(ODSaveParkRoomsDAO)ctx.getBean("SaveParkRoomsDAO");
	
	/**
	 * @param saveParkRooms
	 * @return 1 in case of error or 0 if successful
	 */
	public CISResults saveParkRooms(ODSaveParkRoomsModel saveParkRooms) {
		
		// Capture service Start time
		
	     TimeCheck time=new TimeCheck();
	     testServiceTime seriveTimeCheck=new testServiceTime();
	     String serviceStartTime=time.getTimeZone();
		 
			 final Logger logger = Logger.getLogger(ODSaveParkInfoBL.class);
			// int parkId = count.incrementAndGet();
			 Calendar currentdate = Calendar.getInstance();
		     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE2);
		     formatter.setTimeZone(obj);
		     String ODDate=formatter.format(currentdate.getTime());
		   		 int parkId=	 saveParkRooms.getParkId();
			 CISResults cisResults = parkRoomsDAO.saveParkRooms(parkId,saveParkRooms.getFacilityTypeCode(),saveParkRooms.getFacilityType(),saveParkRooms.getRommTypeDescription(),saveParkRooms.getMaxPeople(),saveParkRooms.getMaxAdults(),saveParkRooms.getMaxKids(),saveParkRooms.getMaxQty(),saveParkRooms.getRegularPrice(),ODDate);
			
			   // Capture Service End time

			    String serviceEndTime=time.getTimeZone();
			    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			    logger.info("Database time for get save park rooms service:: " +result );

			  
			 return cisResults;
		}

	}
