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
import com.validation.CommonCISValidation;
/**
 * Rest Controller : Save park information
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */


@RestController
public class ODSaveParksInfoRestService {

	/**
	 * @param request
	 * @param saveParkInfo
	 * @return 1 in case of error or 0 if successful
	 */
	@RequestMapping(value="/saveParkInfo",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public String saveParkInfo(HttpServletRequest request,@RequestBody ODSaveParkInfoModel saveParkInfo){
		
		 Logger logger = Logger.getLogger(ODSaveParksInfoRestService.class);
		
		 // Capture service Start time
			
	     TimeCheck time=new TimeCheck();
	     testServiceTime seriveTimeCheck=new testServiceTime();
	     String serviceStartTime=time.getTimeZone();
	     
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults CISResults=CommonCISValidation.SaveParkInfoValidation(saveParkInfo,request);
		  if(CISResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODSaveParkInfoWebservice saveParkInfoWebservice = new ODSaveParkInfoWebservice();
		      CISResults = saveParkInfoWebservice.saveParkInfo(saveParkInfo);
		    }
		   // Capture Service End time

		    String serviceEndTime=time.getTimeZone();
		    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		    logger.info("Total service time for save park info service:: " +result );

		
		  
		  return returnJsonData(CISResults);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}