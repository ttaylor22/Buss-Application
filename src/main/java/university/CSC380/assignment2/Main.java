/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.CSC380.assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.HashMap;
import javax.json.*;

/**
 *
 * @author bill
 */
// Google Geocoding API key : AIzaSyDVO746CwOhnxOo6KQOrEL1L6as-Ag_sKw
public class Main {

    public static void main(String[] args) throws FileNotFoundException,
            IOException,
            ParseException,
            org.json.simple.parser.ParseException {

//        Utility.startupTasks();
//        HttpsURLConnection conn = Utility.openGoogleApiConnection("Malcom X Bl, 146 St");
//        System.out.println("Response code = " + conn.getResponseCode());
//        Utility.getFile(conn, "/home/bill/SchoolWork/csc380/CSC_380_bus_project", "GOOGLESTUFF.json", true);
        //HttpURLConnection conn = Utility.openMTAApiConnection();
        //System.out.println("Response code = " + conn.getResponseCode());
        //Utility.getFile(conn, "/home/bill/SchoolWork/csc380/CSC_380_bus_project", "vehicle-monitoring.json", false);
        HashMap<String, Bus> busses = Utility.jsonParser("vehicle-monitoring.json");
//
//        for (Bus b : busses.values()) {
//            System.out.println("\nBus ID = " + b.id);
//            System.out.println("Bus Destination Name = " + b.destinationName);
//            System.out.println("Bus Direction = " + b.direction);
//        }

//        System.out.println("\n\nPARSING SCHEDULE\n\n");
//
//        busses = Utility.parseSchedule("Routes.txt", busses);

//        
//        HashMap hm = Utility.parseSchedule("Routes.txt");
//        
//        String fileName1 = Utility.getFile("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyDVO746CwOhnxOo6KQOrEL1L6as-Ag_sKw&address=Malcom%20x%20bl,%20w%20146%20st", "/home/bill/SchoolWork/csc380/CSC_380_bus_project", "address-data.json");
//        
//        String fileName2 = Utility.getFile("http://bustime.mta.info/api/siri/vehicle-monitoring.json?key=7a22c3e8-61a7-40ff-9d54-714e36f56880", "/home/bill/SchoolWork/csc380/CSC_380_bus_project", "vehicle-monitoring.json");
//        
//        JsonObject j = Utility.parseJson(fileName1);
//        
//        System.out.println("Finished creating JObject");


        HashMap<String, Trip> trips = Utility.parseTrips("trips.txt");
        HashMap<String, Stop> stops = Utility.parseStops("stops.txt");
        HashMap<String, Shape> shapes = Utility.parseShapes("shapes.txt");
        trips = Utility.parseStopTimes("stop_times.txt", trips);
        busses = Utility.assignTrips(busses, trips, stops, shapes);
        
        for (Bus b : busses.values()) {
            System.out.println("\nBus ID = " + b.id);
            System.out.println("Bus Destination Name = " + b.destinationName);
            System.out.println("Bus Direction = " + b.direction);
            if (b.busRoute != null) {
                for (Stop s : b.busRoute) {
                    System.out.println("Stop : " + s.stop_name);
                }
            }
        }
        
        
//        for (Trip t : trips.values()){
//            System.out.println(t.trip_id + ":");
//            for (String s : t.route){
//                System.out.println("    " + stops.get(s).stop_name);
//            }
//            System.out.println("");
//        }

//        for (Stop s : stops.values()) {
//            System.out.println(s.stop_name + "\n");
//        }

    }

}
