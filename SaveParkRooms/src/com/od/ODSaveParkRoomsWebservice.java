package com.od;

import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODSaveParkRoomsWebservice {
	static Logger logger = Logger.getLogger(ODSaveParkRoomsWebservice.class);
	ODSaveParkRoomsBL parkRoomsBL=new ODSaveParkRoomsBL();

	public CISResults saveParkRooms(ODSaveParkRoomsModel saveParkRooms) {
		 CISResults CISResults = parkRoomsBL.saveParkRooms(saveParkRooms);	
		 logger.info("save parkRooms Webservice " +CISResults );
		 return CISResults;
	}

}
