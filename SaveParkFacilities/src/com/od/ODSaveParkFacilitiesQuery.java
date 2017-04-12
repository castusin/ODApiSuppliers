package com.od;

public class ODSaveParkFacilitiesQuery {
	
	public static String SQL_SAVEPARKSFACILITIES = "insert into Park_facilities_inventory( Park_id,Facility_Type_code,Facility_type_desc,Ticket_type,max_qty,current_available_qty,Price)"+"values(?,?,?,?,?,?,?)"; 


}
