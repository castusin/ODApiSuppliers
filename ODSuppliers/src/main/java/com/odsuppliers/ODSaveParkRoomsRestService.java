package com.odsuppliers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.od.ODSaveParkInfoModel;
import com.od.ODSaveParkInfoWebservice;
import com.od.ODSaveParkRoomsModel;
import com.od.ODSaveParkRoomsWebservice;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Checks if account already exists
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */

@RestController
public class ODSaveParkRoomsRestService {

	/**
	 * @param request
	 * @param saveParkRooms
	 * @return 1 in case of error or 0 if successful
	 */
	@RequestMapping(value="/saveParkRooms",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public String saveParkRooms(HttpServletRequest request,@RequestBody ODSaveParkRoomsModel saveParkRooms){
		
		 Logger logger = Logger.getLogger(ODSaveParksInfoRestService.class);
		// Capture service Start time
			
	     TimeCheck time=new TimeCheck();
	     testServiceTime seriveTimeCheck=new testServiceTime();
	     String serviceStartTime=time.getTimeZone();
		 
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults CISResults=CommonCISValidation.SaveParkRoomsValidation(saveParkRooms,request);
		  if(CISResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODSaveParkRoomsWebservice parkRoomsWebservice = new ODSaveParkRoomsWebservice();
		      CISResults = parkRoomsWebservice.saveParkRooms(saveParkRooms);
		    }
		   // Capture Service End time

		    String serviceEndTime=time.getTimeZone();
		    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		    logger.info("Total service time for get save park rooms service:: " +result );

		  
		  return returnJsonData(CISResults);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}