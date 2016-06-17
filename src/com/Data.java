/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
/**
 *
 * @author Administrator
 */
public class Data {
    private static String out_radiation="20000";
    private static String out_temprature="25";
    private static String out_co2="460";
    private static String out_humidity="60";
    private static String out_windspeed="20";
    private static String in_temprature="25";
    private static String in_humidity="25";
    private static String in_ratiation="10000";
    private static String in_co2="420";

    static String skylight_south_open = "FE050000FF009835";
    static String skylight_south_close= "FE0500000000D9C5";
    static String skylight_north_open = "FE050001FF00C9F5";
    static String skylight_north_close= "FE05000100008805";    
    static String sunshade_curtain_open = "FE050002FF0039F5";
    static String sunshade_curtain_close= "FE05000200007805";
    static String spray_open = "FE050003FF006835";
    static String spary_close= "FE050003000029C5";   
    static String sunshade_curtain_north_open = "FE050004FF00D9F4";
    static String sunshade_curtain_north_close= "FE05000400009804";    
    static String wet_curtain_open = "FE050005FF008834";
    static String wet_curtain_close= "FE0500050000C9C4";    
    static String co2_open="FE050006FF007834";
    static String co2_close="FE050006000039C4";    
    static String led2_open="FE050007FF0029F4";
    static String led2_close="FE05000700006804";
    
    
    
    
    
    public static String getOut_radiation() {
        return out_radiation;
    }

    public static void setOut_radiation(String aOut_radiation) {
        out_radiation = aOut_radiation;
    }

    public static String getOut_temprature() {
        return out_temprature;
    }

    public static void setOut_temprature(String aOut_temprature) {
        out_temprature = aOut_temprature;
    }

    public static String getOut_co2() {
        return out_co2;
    }

    public static void setOut_co2(String aOut_co2) {
        out_co2 = aOut_co2;
    }

    public static String getOut_humidity() {
        return out_humidity;
    }

    public static void setOut_humidity(String aOut_humidity) {
        out_humidity = aOut_humidity;
    }

    public static String getOut_windspeed() {
        return out_windspeed;
    }

    public static void setOut_windspeed(String aOut_windspeed) {
        out_windspeed = aOut_windspeed;
    }

    public static String getIn_temprature() {
        return in_temprature;
    }

    public static void setIn_temprature(String aIn_temprature) {
        in_temprature = aIn_temprature;
    }

    public static String getIn_humidity() {
        return in_humidity;
    }

    public static void setIn_humidity(String aIn_humidity) {
        in_humidity = aIn_humidity;
    }

    public static String getIn_ratiation() {
        return in_ratiation;
    }

    public static void setIn_ratiation(String aIn_ratiation) {
        in_ratiation = aIn_ratiation;
    }

    public static String getIn_co2() {
        return in_co2;
    }

    public static void setIn_co2(String aIn_co2) {
        in_co2 = aIn_co2;
    }

    public static String getPacket()
	{	
		String httpurl="http://120.27.110.211/new.json";
		StringBuffer sb=new StringBuffer();
		try
		{
			URL url=new URL(httpurl);
			URLConnection conn=url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line=null;
			while((line=reader.readLine())!=null){
				sb.append(line+"");
				sb.append("\r\n");
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
			return sb==null?"error":sb.toString();
		
	} 
    
    public static String postcommand()
	{	
		String httpurl="http://120.27.110.211:8020/control";
		String command="{\"roof_vent_south\": \"on\"}";
		StringBuffer sb=new StringBuffer();
		try
		{
			URL url=new URL(httpurl);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("content-Type", "application/json");
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			writer.write(command);
			writer.close();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line=null;
			while((line=reader.readLine())!=null){
				sb.append(line+"");
				sb.append("\r\n");
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
          //return sb==null?"error":sb.toString();
		System.out.println(sb);
		JSONObject jobj=JSONObject.fromObject(sb.toString());
		String status=jobj.getString("status");
		return status==null?"error":status;
		
	}
    
    
}
