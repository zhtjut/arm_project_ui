/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
/**
 *
 * @author Administrator
 */
public class Data {
    //室内室外数据
    private String out_radiation="20000";
    private String out_temprature="25";
    private String out_co2="460";
    private String out_humidity="60";
    private String out_windspeed="20";
    private String in_temprature="25";
    private String in_humidity="25";
    private String in_radiation="10000";
    private String in_co2="420";    
    private String winddirection="无";
    private String atmosphere="1000";
    private String rain="false";
    private String updatetime="0-0-0-0";
    //执行机构数据
    private String roof_vent_north="off";
    private String roof_vent_south="off";
    private String side_vent="off";
    private String shade_screen_out="off";
    private String shade_screen_in="off";
    private String thermal_screen="off";
    private String cooling_pad="off";
    private String fogging="off";
    private String heating="off";
    private String co2="off";
    private String lighting_1="off";
    private String lighting_2="off";
    private String irrigation="off";
    //参数设置
    private String time1=""; 
    private String temperature1="";
    private String time2="";
    private String temperature2="";
    private String time3="";
    private String temperature3="";
    private String time4="";
    private String temperature4="";
    private String co2_upper_limit="";
    private String co2_lower_limit="";
    private String cooling_start_temperature="";
    private String cooling_stop_temperature="";
    private String expect_humidity="";  
    private String humidity_influence_range_of_air_temperature=""; 
    private String low_humidity_influence_on_air_temperature="";
    private String high_humidity_influence_on_air_temperature="";
    private String expect_light="";
    private String light_influence_on_air_temperature_slope="";
    private String high_light_influence_on_temperature="";
    private String low_light_influence_on_temperature="";
    private String frost_temperature="";
    private String indoor_temperature_lower_limit="";
    private String roof_vent_wind_speed_upper_limit="";
    private String roof_vent_rain_upper_limit="";
    private String heating_start_lowest_temperature="";
    private String heating_stop_highest_temperature=""; 
    private String month_to_open_thermal_screen="";
    private String month_to_close_thermal_screen="";
    private String time_to_open_thermal_screen="";
    private String time_to_close_thermal_screen="";    
    private String temperature_to_open_side="";
    private String wait_time_to_open_side="";
    private String rain_upper_limit_to_close=""; 
    private String upper_limit_light_to_open_out_shade_screen="";
    private String upper_limit_light_to_open_in_shade_screen="";
    private String soil_humidity_to_start_irrigation="";
    private String soil_humidity_to_stop_irrigation="";
    private String temperature_to_open_fogging="";
    private String temperature_to_open_cooling_pad="";     
    private String month_to_open_lighting="";
    private String month_to_close_lighting="";
    private String period1_start_lighting="";
    private String period1_stop_lighting="";
    private String period2_start_lighting="";
    private String period2_stop_lighting="";
    private String radiation1_to_open_lighting="";
    private String radiation2_to_open_lighting="";     
    private String roof_vent_open_time="";
    private String side_vent_open_time="";
    private String shade_screen_out_open_time="";
    private String shade_screen_in_open_time="";
    private String thermal_screen_open_time="";     
    public  void getindoor()
   	{	
   		String httpurl="http://127.0.0.1:8020/indoor";
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
   		
    	
   			//return sb==null?"error":sb.toString();
   		JSONObject indoordata=JSONObject.fromObject(sb.toString());
   		Object indoortemp=indoordata.get("indoor");
   		
   		JSONObject indoortemp2=JSONObject.fromObject(indoortemp);  		
   		Object indoortemp3=indoortemp2.get("node_0");
   		
   		JSONObject nodedata=JSONObject.fromObject(indoortemp3);
   		
   		setIn_temprature(nodedata.getString("temperature"));
   		setIn_co2(nodedata.getString("co2"));
   		setIn_radiation(nodedata.getString("radiation"));
   		setIn_humidity(nodedata.getString("humidity"));
   		
   		
   		
   	}  
    public  void getoutdoor()
   	{	
   		String httpurl="http://127.0.0.1:8020/outdoor";
   		StringBuffer sb=new StringBuffer();
   		try
   		{
   			URL url=new URL(httpurl);
   			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
   			conn.setRequestMethod("GET");
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
   		
   	   		JSONObject outdoordata=JSONObject.fromObject(sb.toString());
   	   		Object outdoortemp2=outdoordata.get("outdoor");
   	   		JSONObject outdoortemp=JSONObject.fromObject(outdoortemp2);
   	   		setOut_windspeed(outdoortemp.getString("wind_speed"));
   	   		setWinddirection(outdoortemp.getString("wind_direction"));
   	   		setOut_humidity(outdoortemp.getString("humidity"));
   	   		setAtmosphere(outdoortemp.getString("atmosphere"));
   	   		setRain(outdoortemp.getString("rain"));
   	   		setOut_radiation(outdoortemp.getString("radiation"));
   	   		setOut_co2(outdoortemp.getString("co2"));
                        setUpdatetime(outdoortemp.getString("update_time"));
   		
   	}
    public  void getparameter()
   	{	
   		String httpurl="http://127.0.0.1:8020/parameter";
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
                        System.out.println(sb.toString());
                        JSONObject outdoordata=JSONObject.fromObject(sb.toString());
                        JSONObject plantset=outdoordata.getJSONObject("plant_parameter_setting");
	   		JSONObject co2set=outdoordata.getJSONObject("co2_parameter_setting");
	   		JSONObject coolfanset=outdoordata.getJSONObject("cooling_fans");
	   		JSONObject roofset=outdoordata.getJSONObject("roof_vent_parameter_setting");
	   		JSONObject heatset=outdoordata.getJSONObject("heating_parameter_setting");
	   		JSONObject thermalset=outdoordata.getJSONObject("thermal_screen_parameter_setting");
	   		JSONObject sideset=outdoordata.getJSONObject("side_vent_parameter_setting");
	   		JSONObject otherset =outdoordata.getJSONObject("other_parameter_setting");
	   		JSONObject opencloseset=outdoordata.getJSONObject("time_that_full_open_to_full_close");
	   		JSONObject lightset=outdoordata.getJSONObject("lighting_setting");
                        
	   		setTime1(plantset.getString("time1"));
	   		setTime2(plantset.getString("time2"));
	   		setTime3(plantset.getString("time3"));
	   		setTime4(plantset.getString("time4"));
	   		setTemperature1(plantset.getString("temperature1"));
	   		setTemperature2(plantset.getString("temperature2"));
	   		setTemperature3(plantset.getString("temperature3"));
	   		setTemperature4(plantset.getString("temperature4"));
	   		setCo2_lower_limit(co2set.getString("co2_lower_limit"));
	   		setCo2_upper_limit(co2set.getString("co2_upper_limit"));
	   		setCooling_start_temperature(coolfanset.getString("cooling_start_temperature"));
	   		setCooling_stop_temperature(coolfanset.getString("cooling_stop_temperature"));
	   		setHumidity_influence_range_of_air_temperature(roofset.getString("humidity_influence_range_of_air_temperature"));
	   		setExpect_humidity(roofset.getString("expect_humidity"));
	   		setLow_humidity_influence_on_air_temperature(roofset.getString("low_humidity_influence_on_air_temperature"));
	   		setHigh_humidity_influence_on_air_temperature(roofset.getString("high_humidity_influence_on_air_temperature"));
	   		setExpect_light(roofset.getString("expect_light"));
	   		setLight_influence_on_air_temperature_slope(roofset.getString("light_influence_on_air_temperature_slope"));
	   		setHigh_light_influence_on_temperature(roofset.getString("high_light_influence_on_temperature"));
	   		setLow_light_influence_on_temperature(roofset.getString("low_light_influence_on_temperature"));
	   		setFrost_temperature(roofset.getString("frost_temperature"));
	   		setIndoor_temperature_lower_limit(roofset.getString("indoor_temperature_lower_limit"));
	   		setRoof_vent_wind_speed_upper_limit(roofset.getString("roof_vent_wind_speed_upper_limit"));
	   		setRoof_vent_rain_upper_limit(roofset.getString("roof_vent_rain_upper_limit"));	   		
	   		setHeating_start_lowest_temperature(heatset.getString("heating_start_lowest_temperature"));
	   		setHeating_stop_highest_temperature(heatset.getString("heating_stop_highest_temperature"));	   		
	   		setMonth_to_open_thermal_screen(thermalset.getString("month_to_open_thermal_screen"));
	   		setMonth_to_close_thermal_screen(thermalset.getString("month_to_close_thermal_screen"));
	   		setTime_to_open_thermal_screen(thermalset.getString("time_to_open_thermal_screen"));
	   		setTime_to_close_thermal_screen(thermalset.getString("time_to_close_thermal_screen"));	   		
	   		setTemperature_to_open_side(sideset.getString("temperature_to_open_side"));
	   		setWait_time_to_open_side(sideset.getString("wait_time_to_open_side"));
	   		setRain_upper_limit_to_close(sideset.getString("rain_upper_limit_to_close"));	   		
	   		setMonth_to_open_lighting(lightset.getString("month_to_open_lighting"));
	   		setMonth_to_close_lighting(lightset.getString("month_to_close_lighting"));
	   		setPeriod1_start_lighting(lightset.getString("period1_start_lighting"));
	   		setPeriod1_stop_lighting(lightset.getString("period1_stop_lighting"));
	   		setPeriod2_start_lighting(lightset.getString("period2_start_lighting"));
	   		setPeriod2_stop_lighting(lightset.getString("period2_stop_lighting"));
	   		setRadiation1_to_open_lighting(lightset.getString("radiation1_to_open_lighting"));
	   		setRadiation2_to_open_lighting(lightset.getString("radiation2_to_open_lighting"));	   		
	   		setUpper_limit_light_to_open_out_shade_screen(otherset.getString("upper_limit_light_to_open_out_shade_screen"));
	   		setUpper_limit_light_to_open_in_shade_screen(otherset.getString("upper_limit_light_to_open_in_shade_screen"));
	   		setSoil_humidity_to_start_irrigation(otherset.getString("soil_humidity_to_start_irrigation"));
	   		setSoil_humidity_to_stop_irrigation(otherset.getString("soil_humidity_to_stop_irrigation"));
	   		setTemperature_to_open_fogging(otherset.getString("temperature_to_open_fogging"));
	   		setTemperature_to_open_cooling_pad(otherset.getString("temperature_to_open_cooling_pad"));	   		
	   		setRoof_vent_open_time(opencloseset.getString("roof_vent_open_time"));
	   		setSide_vent_open_time(opencloseset.getString("side_vent_open_time"));
	   		setShade_screen_out_open_time(opencloseset.getString("shade_screen_out_open_time"));
	   		setShade_screen_in_open_time(opencloseset.getString("shade_screen_in_open_time"));
	   		setThermal_screen_open_time(opencloseset.getString("thermal_screen_open_time"));
               
   		
   	} 
    public  String post_roofsouth_on()
	{	
		String httpurl="http://127.0.0.1:8020/control";
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
    public  String post_roofsouth_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"roof_vent_south\": \"off\"}";
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
     public  String post_roofsouth_stop()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"roof_vent_south\": \"stop\"}";
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
     
     
    public  String post_roofnorth_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"roof_vent_north\": \"on\"}";
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
    public  String post_roofnorth_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"roof_vent_north\": \"off\"}";
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
    public  String post_roofnorth_stop()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"roof_vent_north\": \"stop\"}";
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
    
    
    public  String post_sidevent_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"side_vent\": \"on\"}";
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
    public  String post_sidevent_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"side_vent\": \"off\"}";
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
     public  String post_sidevent_stop()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"side_vent\": \"stop\"}";
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
     
     
    public  String post_shade_screen_out_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"shade_screen_out\": \"on\"}";
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
    public  String post_shade_screen_out_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"shade_screen_out\": \"off\"}";
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
     public  String post_shade_screen_out_stop()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"shade_screen_out\": \"stop\"}";
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
     
     
    public  String post_shade_screen_in_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"shade_screen_in\": \"on\"}";
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
    public  String post_shade_screen_in_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"shade_screen_in\": \"off\"}";
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
    public  String post_shade_screen_in_stop()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"shade_screen_in\": \"stop\"}";
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
    
    
    public  String post_thermal_screen_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"thermal_screen\": \"on\"}";
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
    public  String post_thermal_screen_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"thermal_screen\": \"off\"}";
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
    public  String post_thermal_screen_stop()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"thermal_screen\": \"stop\"}";
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
    
    
    public  String post_cooling_pad_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"cooling_pad\": \"on\"}";
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
    public  String post_cooling_pad_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"cooling_pad\": \"off\"}";
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
    public  String post_fogging_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"fogging\": \"on\"}";
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
    public  String post_fogging_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"fogging\": \"off\"}";
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
    public  String post_heating_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"heating\": \"on\"}";
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
    public  String post_heating_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"heating\": \"off\"}";
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
    public  String post_co2_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"co2\": \"on\"}";
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
    public  String post_co2_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"co2\": \"off\"}";
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
    public  String post_lighting_1_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"lighting_1\": \"on\"}";
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
    public  String post_lighting_1_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"lighting_1\": \"off\"}";
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
    public  String post_lighting_2_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"lighting_2\": \"on\"}";
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
    public  String post_lighting_2_off()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"lighting_2\": \"off\"}";
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
    public  String post_irrigation_on()
  	{	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"irrigation\": \"on\"}";
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
    public  String post_irrigation_off()
            {	
  		String httpurl="http://127.0.0.1:8020/control";
  		String command="{\"irrigation\": \"off\"}";
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
    
    public void postParameter(String s)
   	{	
   		String httpurl="http://127.0.0.1:8020/parameter";
   		String command=s;
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
                        System.out.println(sb.toString());
   		}
   		catch(Exception e)
   		{
   			System.out.println(e.toString());
   		}
   		
             //return sb==null?"error":sb.toString();
   		System.out.println("post parameter success");
   		
   	}
    public  void getcontrolstate()
   	{	
   		String httpurl="http://127.0.0.1:8020/control";
   		StringBuffer sb=new StringBuffer();
   		try
   		{
   			URL url=new URL(httpurl);
   			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
   			conn.setRequestMethod("GET");
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

   	   		JSONObject controldata=JSONObject.fromObject(sb.toString());
   	   		JSONObject actuator=controldata.getJSONObject("actuator");
   	   		JSONObject tri=actuator.getJSONObject("tri_state");
   	   		JSONObject bi=actuator.getJSONObject("bi_state");
   	   		setRoof_vent_south(change(tri.getString("roof_vent_south")));
   	   		setRoof_vent_north(change(tri.getString("roof_vent_north")));
   	   		setSide_vent(change(tri.getString("side_vent")));
   	   		setShade_screen_out(change(tri.getString("shade_screen_out")));
   	   		setShade_screen_in(change(tri.getString("shade_screen_in")));
   	   		setThermal_screen(change(tri.getString("thermal_screen")));
   	   		setCooling_pad(change(bi.getString("cooling_pad")));
   	   		setFogging(change(bi.getString("fogging")));
   	   		setHeating(change(bi.getString("heating")));
   	   		setCo2(change(bi.getString("co2")));
   	   		setLighting_1(change(bi.getString("lighting_1")));
   	   		setLighting_2(change(bi.getString("lighting_2")));
   	   		setIrrigation(change(bi.getString("irrigation")));
   	}
    public  String change(String s)
   {	
	   String open="开";
	   String close="关";
	   int status=0;
	   if (s.equals("on"))
		   status=1;	   
	return status==1?open:close;
   }
    /**
     * @return the out_radiation
     */
    public String getOut_radiation() {
        return out_radiation;
    }

    /**
     * @param out_radiation the out_radiation to set
     */
    public void setOut_radiation(String out_radiation) {
        this.out_radiation = out_radiation;
    }

    /**
     * @return the out_temprature
     */
    public String getOut_temprature() {
        return out_temprature;
    }

    /**
     * @param out_temprature the out_temprature to set
     */
    public void setOut_temprature(String out_temprature) {
        this.out_temprature = out_temprature;
    }

    /**
     * @return the out_co2
     */
    public String getOut_co2() {
        return out_co2;
    }

    /**
     * @param out_co2 the out_co2 to set
     */
    public void setOut_co2(String out_co2) {
        this.out_co2 = out_co2;
    }

    /**
     * @return the out_humidity
     */
    public String getOut_humidity() {
        return out_humidity;
    }

    /**
     * @param out_humidity the out_humidity to set
     */
    public void setOut_humidity(String out_humidity) {
        this.out_humidity = out_humidity;
    }

    /**
     * @return the out_windspeed
     */
    public String getOut_windspeed() {
        return out_windspeed;
    }

    /**
     * @param out_windspeed the out_windspeed to set
     */
    public void setOut_windspeed(String out_windspeed) {
        this.out_windspeed = out_windspeed;
    }

    /**
     * @return the in_temprature
     */
    public String getIn_temprature() {
        return in_temprature;
    }

    /**
     * @param in_temprature the in_temprature to set
     */
    public void setIn_temprature(String in_temprature) {
        this.in_temprature = in_temprature;
    }

    /**
     * @return the in_humidity
     */
    public String getIn_humidity() {
        return in_humidity;
    }

    /**
     * @param in_humidity the in_humidity to set
     */
    public void setIn_humidity(String in_humidity) {
        this.in_humidity = in_humidity;
    }

    /**
     * @return the in_radiation
     */
    public String getIn_radiation() {
        return in_radiation;
    }

    /**
     * @param in_radiation the in_radiation to set
     */
    public void setIn_radiation(String in_radiation) {
        this.in_radiation = in_radiation;
    }

    /**
     * @return the in_co2
     */
    public String getIn_co2() {
        return in_co2;
    }

    /**
     * @param in_co2 the in_co2 to set
     */
    public void setIn_co2(String in_co2) {
        this.in_co2 = in_co2;
    }

    /**
     * @return the winddirection
     */
    public String getWinddirection() {
        return winddirection;
    }

    /**
     * @param winddirection the winddirection to set
     */
    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection;
    }

    /**
     * @return the atmosphere
     */
    public String getAtmosphere() {
        return atmosphere;
    }

    /**
     * @param atmosphere the atmosphere to set
     */
    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

    /**
     * @return the rain
     */
    public String getRain() {
        return rain;
    }

    /**
     * @param rain the rain to set
     */
    public void setRain(String rain) {
        this.rain = rain;
    }

    /**
     * @return the updatetime
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime the updatetime to set
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return the roof_vent_north
     */
    public String getRoof_vent_north() {
        return roof_vent_north;
    }

    /**
     * @param roof_vent_north the roof_vent_north to set
     */
    public void setRoof_vent_north(String roof_vent_north) {
        this.roof_vent_north = roof_vent_north;
    }

    /**
     * @return the roof_vent_south
     */
    public String getRoof_vent_south() {
        return roof_vent_south;
    }

    /**
     * @param roof_vent_south the roof_vent_south to set
     */
    public void setRoof_vent_south(String roof_vent_south) {
        this.roof_vent_south = roof_vent_south;
    }

    /**
     * @return the side_vent
     */
    public String getSide_vent() {
        return side_vent;
    }

    /**
     * @param side_vent the side_vent to set
     */
    public void setSide_vent(String side_vent) {
        this.side_vent = side_vent;
    }

    /**
     * @return the shade_screen_out
     */
    public String getShade_screen_out() {
        return shade_screen_out;
    }

    /**
     * @param shade_screen_out the shade_screen_out to set
     */
    public void setShade_screen_out(String shade_screen_out) {
        this.shade_screen_out = shade_screen_out;
    }

    /**
     * @return the shade_screen_in
     */
    public String getShade_screen_in() {
        return shade_screen_in;
    }

    /**
     * @param shade_screen_in the shade_screen_in to set
     */
    public void setShade_screen_in(String shade_screen_in) {
        this.shade_screen_in = shade_screen_in;
    }

    /**
     * @return the thermal_screen
     */
    public String getThermal_screen() {
        return thermal_screen;
    }

    /**
     * @param thermal_screen the thermal_screen to set
     */
    public void setThermal_screen(String thermal_screen) {
        this.thermal_screen = thermal_screen;
    }

    /**
     * @return the cooling_pad
     */
    public String getCooling_pad() {
        return cooling_pad;
    }

    /**
     * @param cooling_pad the cooling_pad to set
     */
    public void setCooling_pad(String cooling_pad) {
        this.cooling_pad = cooling_pad;
    }

    /**
     * @return the fogging
     */
    public String getFogging() {
        return fogging;
    }

    /**
     * @param fogging the fogging to set
     */
    public void setFogging(String fogging) {
        this.fogging = fogging;
    }

    /**
     * @return the heating
     */
    public String getHeating() {
        return heating;
    }

    /**
     * @param heating the heating to set
     */
    public void setHeating(String heating) {
        this.heating = heating;
    }

    /**
     * @return the co2
     */
    public String getCo2() {
        return co2;
    }

    /**
     * @param co2 the co2 to set
     */
    public void setCo2(String co2) {
        this.co2 = co2;
    }

    /**
     * @return the lighting_1
     */
    public String getLighting_1() {
        return lighting_1;
    }

    /**
     * @param lighting_1 the lighting_1 to set
     */
    public void setLighting_1(String lighting_1) {
        this.lighting_1 = lighting_1;
    }

    /**
     * @return the lighting_2
     */
    public String getLighting_2() {
        return lighting_2;
    }

    /**
     * @param lighting_2 the lighting_2 to set
     */
    public void setLighting_2(String lighting_2) {
        this.lighting_2 = lighting_2;
    }

    /**
     * @return the irrigation
     */
    public String getIrrigation() {
        return irrigation;
    }

    /**
     * @param irrigation the irrigation to set
     */
    public void setIrrigation(String irrigation) {
        this.irrigation = irrigation;
    }

    /**
     * @return the time1
     */
    public String getTime1() {
        return time1;
    }

    /**
     * @param time1 the time1 to set
     */
    public void setTime1(String time1) {
        this.time1 = time1;
    }

    /**
     * @return the temperature1
     */
    public String getTemperature1() {
        return temperature1;
    }

    /**
     * @param temperature1 the temperature1 to set
     */
    public void setTemperature1(String temperature1) {
        this.temperature1 = temperature1;
    }

    /**
     * @return the time2
     */
    public String getTime2() {
        return time2;
    }

    /**
     * @param time2 the time2 to set
     */
    public void setTime2(String time2) {
        this.time2 = time2;
    }

    /**
     * @return the temperature2
     */
    public String getTemperature2() {
        return temperature2;
    }

    /**
     * @param temperature2 the temperature2 to set
     */
    public void setTemperature2(String temperature2) {
        this.temperature2 = temperature2;
    }

    /**
     * @return the time3
     */
    public String getTime3() {
        return time3;
    }

    /**
     * @param time3 the time3 to set
     */
    public void setTime3(String time3) {
        this.time3 = time3;
    }

    /**
     * @return the temperature3
     */
    public String getTemperature3() {
        return temperature3;
    }

    /**
     * @param temperature3 the temperature3 to set
     */
    public void setTemperature3(String temperature3) {
        this.temperature3 = temperature3;
    }

    /**
     * @return the time4
     */
    public String getTime4() {
        return time4;
    }

    /**
     * @param time4 the time4 to set
     */
    public void setTime4(String time4) {
        this.time4 = time4;
    }

    /**
     * @return the temperature4
     */
    public String getTemperature4() {
        return temperature4;
    }

    /**
     * @param temperature4 the temperature4 to set
     */
    public void setTemperature4(String temperature4) {
        this.temperature4 = temperature4;
    }

    /**
     * @return the co2_upper_limit
     */
    public String getCo2_upper_limit() {
        return co2_upper_limit;
    }

    /**
     * @param co2_upper_limit the co2_upper_limit to set
     */
    public void setCo2_upper_limit(String co2_upper_limit) {
        this.co2_upper_limit = co2_upper_limit;
    }

    /**
     * @return the co2_lower_limit
     */
    public String getCo2_lower_limit() {
        return co2_lower_limit;
    }

    /**
     * @param co2_lower_limit the co2_lower_limit to set
     */
    public void setCo2_lower_limit(String co2_lower_limit) {
        this.co2_lower_limit = co2_lower_limit;
    }

    /**
     * @return the cooling_start_temperature
     */
    public String getCooling_start_temperature() {
        return cooling_start_temperature;
    }

    /**
     * @param cooling_start_temperature the cooling_start_temperature to set
     */
    public void setCooling_start_temperature(String cooling_start_temperature) {
        this.cooling_start_temperature = cooling_start_temperature;
    }

    /**
     * @return the cooling_stop_temperature
     */
    public String getCooling_stop_temperature() {
        return cooling_stop_temperature;
    }

    /**
     * @param cooling_stop_temperature the cooling_stop_temperature to set
     */
    public void setCooling_stop_temperature(String cooling_stop_temperature) {
        this.cooling_stop_temperature = cooling_stop_temperature;
    }

    /**
     * @return the expect_humidity
     */
    public String getExpect_humidity() {
        return expect_humidity;
    }

    /**
     * @param expect_humidity the expect_humidity to set
     */
    public void setExpect_humidity(String expect_humidity) {
        this.expect_humidity = expect_humidity;
    }

    /**
     * @return the humidity_influence_range_of_air_temperature
     */
    public String getHumidity_influence_range_of_air_temperature() {
        return humidity_influence_range_of_air_temperature;
    }

    /**
     * @param humidity_influence_range_of_air_temperature the humidity_influence_range_of_air_temperature to set
     */
    public void setHumidity_influence_range_of_air_temperature(String humidity_influence_range_of_air_temperature) {
        this.humidity_influence_range_of_air_temperature = humidity_influence_range_of_air_temperature;
    }

    /**
     * @return the low_humidity_influence_on_air_temperature
     */
    public String getLow_humidity_influence_on_air_temperature() {
        return low_humidity_influence_on_air_temperature;
    }

    /**
     * @param low_humidity_influence_on_air_temperature the low_humidity_influence_on_air_temperature to set
     */
    public void setLow_humidity_influence_on_air_temperature(String low_humidity_influence_on_air_temperature) {
        this.low_humidity_influence_on_air_temperature = low_humidity_influence_on_air_temperature;
    }

    /**
     * @return the high_humidity_influence_on_air_temperature
     */
    public String getHigh_humidity_influence_on_air_temperature() {
        return high_humidity_influence_on_air_temperature;
    }

    /**
     * @param high_humidity_influence_on_air_temperature the high_humidity_influence_on_air_temperature to set
     */
    public void setHigh_humidity_influence_on_air_temperature(String high_humidity_influence_on_air_temperature) {
        this.high_humidity_influence_on_air_temperature = high_humidity_influence_on_air_temperature;
    }

    /**
     * @return the expect_light
     */
    public String getExpect_light() {
        return expect_light;
    }

    /**
     * @param expect_light the expect_light to set
     */
    public void setExpect_light(String expect_light) {
        this.expect_light = expect_light;
    }

    /**
     * @return the light_influence_on_air_temperature_slope
     */
    public String getLight_influence_on_air_temperature_slope() {
        return light_influence_on_air_temperature_slope;
    }

    /**
     * @param light_influence_on_air_temperature_slope the light_influence_on_air_temperature_slope to set
     */
    public void setLight_influence_on_air_temperature_slope(String light_influence_on_air_temperature_slope) {
        this.light_influence_on_air_temperature_slope = light_influence_on_air_temperature_slope;
    }

    /**
     * @return the high_light_influence_on_temperature
     */
    public String getHigh_light_influence_on_temperature() {
        return high_light_influence_on_temperature;
    }

    /**
     * @param high_light_influence_on_temperature the high_light_influence_on_temperature to set
     */
    public void setHigh_light_influence_on_temperature(String high_light_influence_on_temperature) {
        this.high_light_influence_on_temperature = high_light_influence_on_temperature;
    }

    /**
     * @return the low_light_influence_on_temperature
     */
    public String getLow_light_influence_on_temperature() {
        return low_light_influence_on_temperature;
    }

    /**
     * @param low_light_influence_on_temperature the low_light_influence_on_temperature to set
     */
    public void setLow_light_influence_on_temperature(String low_light_influence_on_temperature) {
        this.low_light_influence_on_temperature = low_light_influence_on_temperature;
    }

    /**
     * @return the frost_temperature
     */
    public String getFrost_temperature() {
        return frost_temperature;
    }

    /**
     * @param frost_temperature the frost_temperature to set
     */
    public void setFrost_temperature(String frost_temperature) {
        this.frost_temperature = frost_temperature;
    }

    /**
     * @return the indoor_temperature_lower_limit
     */
    public String getIndoor_temperature_lower_limit() {
        return indoor_temperature_lower_limit;
    }

    /**
     * @param indoor_temperature_lower_limit the indoor_temperature_lower_limit to set
     */
    public void setIndoor_temperature_lower_limit(String indoor_temperature_lower_limit) {
        this.indoor_temperature_lower_limit = indoor_temperature_lower_limit;
    }

    /**
     * @return the roof_vent_wind_speed_upper_limit
     */
    public String getRoof_vent_wind_speed_upper_limit() {
        return roof_vent_wind_speed_upper_limit;
    }

    /**
     * @param roof_vent_wind_speed_upper_limit the roof_vent_wind_speed_upper_limit to set
     */
    public void setRoof_vent_wind_speed_upper_limit(String roof_vent_wind_speed_upper_limit) {
        this.roof_vent_wind_speed_upper_limit = roof_vent_wind_speed_upper_limit;
    }

    /**
     * @return the roof_vent_rain_upper_limit
     */
    public String getRoof_vent_rain_upper_limit() {
        return roof_vent_rain_upper_limit;
    }

    /**
     * @param roof_vent_rain_upper_limit the roof_vent_rain_upper_limit to set
     */
    public void setRoof_vent_rain_upper_limit(String roof_vent_rain_upper_limit) {
        this.roof_vent_rain_upper_limit = roof_vent_rain_upper_limit;
    }

    /**
     * @return the heating_start_lowest_temperature
     */
    public String getHeating_start_lowest_temperature() {
        return heating_start_lowest_temperature;
    }

    /**
     * @param heating_start_lowest_temperature the heating_start_lowest_temperature to set
     */
    public void setHeating_start_lowest_temperature(String heating_start_lowest_temperature) {
        this.heating_start_lowest_temperature = heating_start_lowest_temperature;
    }

    /**
     * @return the heating_stop_highest_temperature
     */
    public String getHeating_stop_highest_temperature() {
        return heating_stop_highest_temperature;
    }

    /**
     * @param heating_stop_highest_temperature the heating_stop_highest_temperature to set
     */
    public void setHeating_stop_highest_temperature(String heating_stop_highest_temperature) {
        this.heating_stop_highest_temperature = heating_stop_highest_temperature;
    }

    /**
     * @return the month_to_open_thermal_screen
     */
    public String getMonth_to_open_thermal_screen() {
        return month_to_open_thermal_screen;
    }

    /**
     * @param month_to_open_thermal_screen the month_to_open_thermal_screen to set
     */
    public void setMonth_to_open_thermal_screen(String month_to_open_thermal_screen) {
        this.month_to_open_thermal_screen = month_to_open_thermal_screen;
    }

    /**
     * @return the month_to_close_thermal_screen
     */
    public String getMonth_to_close_thermal_screen() {
        return month_to_close_thermal_screen;
    }

    /**
     * @param month_to_close_thermal_screen the month_to_close_thermal_screen to set
     */
    public void setMonth_to_close_thermal_screen(String month_to_close_thermal_screen) {
        this.month_to_close_thermal_screen = month_to_close_thermal_screen;
    }

    /**
     * @return the time_to_open_thermal_screen
     */
    public String getTime_to_open_thermal_screen() {
        return time_to_open_thermal_screen;
    }

    /**
     * @param time_to_open_thermal_screen the time_to_open_thermal_screen to set
     */
    public void setTime_to_open_thermal_screen(String time_to_open_thermal_screen) {
        this.time_to_open_thermal_screen = time_to_open_thermal_screen;
    }

    /**
     * @return the time_to_close_thermal_screen
     */
    public String getTime_to_close_thermal_screen() {
        return time_to_close_thermal_screen;
    }

    /**
     * @param time_to_close_thermal_screen the time_to_close_thermal_screen to set
     */
    public void setTime_to_close_thermal_screen(String time_to_close_thermal_screen) {
        this.time_to_close_thermal_screen = time_to_close_thermal_screen;
    }

    /**
     * @return the temperature_to_open_side
     */
    public String getTemperature_to_open_side() {
        return temperature_to_open_side;
    }

    /**
     * @param temperature_to_open_side the temperature_to_open_side to set
     */
    public void setTemperature_to_open_side(String temperature_to_open_side) {
        this.temperature_to_open_side = temperature_to_open_side;
    }

    /**
     * @return the wait_time_to_open_side
     */
    public String getWait_time_to_open_side() {
        return wait_time_to_open_side;
    }

    /**
     * @param wait_time_to_open_side the wait_time_to_open_side to set
     */
    public void setWait_time_to_open_side(String wait_time_to_open_side) {
        this.wait_time_to_open_side = wait_time_to_open_side;
    }

    /**
     * @return the rain_upper_limit_to_close
     */
    public String getRain_upper_limit_to_close() {
        return rain_upper_limit_to_close;
    }

    /**
     * @param rain_upper_limit_to_close the rain_upper_limit_to_close to set
     */
    public void setRain_upper_limit_to_close(String rain_upper_limit_to_close) {
        this.rain_upper_limit_to_close = rain_upper_limit_to_close;
    }

    /**
     * @return the upper_limit_light_to_open_out_shade_screen
     */
    public String getUpper_limit_light_to_open_out_shade_screen() {
        return upper_limit_light_to_open_out_shade_screen;
    }

    /**
     * @param upper_limit_light_to_open_out_shade_screen the upper_limit_light_to_open_out_shade_screen to set
     */
    public void setUpper_limit_light_to_open_out_shade_screen(String upper_limit_light_to_open_out_shade_screen) {
        this.upper_limit_light_to_open_out_shade_screen = upper_limit_light_to_open_out_shade_screen;
    }

    /**
     * @return the upper_limit_light_to_open_in_shade_screen
     */
    public String getUpper_limit_light_to_open_in_shade_screen() {
        return upper_limit_light_to_open_in_shade_screen;
    }

    /**
     * @param upper_limit_light_to_open_in_shade_screen the upper_limit_light_to_open_in_shade_screen to set
     */
    public void setUpper_limit_light_to_open_in_shade_screen(String upper_limit_light_to_open_in_shade_screen) {
        this.upper_limit_light_to_open_in_shade_screen = upper_limit_light_to_open_in_shade_screen;
    }

    /**
     * @return the soil_humidity_to_start_irrigation
     */
    public String getSoil_humidity_to_start_irrigation() {
        return soil_humidity_to_start_irrigation;
    }

    /**
     * @param soil_humidity_to_start_irrigation the soil_humidity_to_start_irrigation to set
     */
    public void setSoil_humidity_to_start_irrigation(String soil_humidity_to_start_irrigation) {
        this.soil_humidity_to_start_irrigation = soil_humidity_to_start_irrigation;
    }

    /**
     * @return the soil_humidity_to_stop_irrigation
     */
    public String getSoil_humidity_to_stop_irrigation() {
        return soil_humidity_to_stop_irrigation;
    }

    /**
     * @param soil_humidity_to_stop_irrigation the soil_humidity_to_stop_irrigation to set
     */
    public void setSoil_humidity_to_stop_irrigation(String soil_humidity_to_stop_irrigation) {
        this.soil_humidity_to_stop_irrigation = soil_humidity_to_stop_irrigation;
    }

    /**
     * @return the temperature_to_open_fogging
     */
    public String getTemperature_to_open_fogging() {
        return temperature_to_open_fogging;
    }

    /**
     * @param temperature_to_open_fogging the temperature_to_open_fogging to set
     */
    public void setTemperature_to_open_fogging(String temperature_to_open_fogging) {
        this.temperature_to_open_fogging = temperature_to_open_fogging;
    }

    /**
     * @return the temperature_to_open_cooling_pad
     */
    public String getTemperature_to_open_cooling_pad() {
        return temperature_to_open_cooling_pad;
    }

    /**
     * @param temperature_to_open_cooling_pad the temperature_to_open_cooling_pad to set
     */
    public void setTemperature_to_open_cooling_pad(String temperature_to_open_cooling_pad) {
        this.temperature_to_open_cooling_pad = temperature_to_open_cooling_pad;
    }

    /**
     * @return the month_to_open_lighting
     */
    public String getMonth_to_open_lighting() {
        return month_to_open_lighting;
    }

    /**
     * @param month_to_open_lighting the month_to_open_lighting to set
     */
    public void setMonth_to_open_lighting(String month_to_open_lighting) {
        this.month_to_open_lighting = month_to_open_lighting;
    }

    /**
     * @return the month_to_close_lighting
     */
    public String getMonth_to_close_lighting() {
        return month_to_close_lighting;
    }

    /**
     * @param month_to_close_lighting the month_to_close_lighting to set
     */
    public void setMonth_to_close_lighting(String month_to_close_lighting) {
        this.month_to_close_lighting = month_to_close_lighting;
    }

    /**
     * @return the period1_start_lighting
     */
    public String getPeriod1_start_lighting() {
        return period1_start_lighting;
    }

    /**
     * @param period1_start_lighting the period1_start_lighting to set
     */
    public void setPeriod1_start_lighting(String period1_start_lighting) {
        this.period1_start_lighting = period1_start_lighting;
    }

    /**
     * @return the period1_stop_lighting
     */
    public String getPeriod1_stop_lighting() {
        return period1_stop_lighting;
    }

    /**
     * @param period1_stop_lighting the period1_stop_lighting to set
     */
    public void setPeriod1_stop_lighting(String period1_stop_lighting) {
        this.period1_stop_lighting = period1_stop_lighting;
    }

    /**
     * @return the period2_start_lighting
     */
    public String getPeriod2_start_lighting() {
        return period2_start_lighting;
    }

    /**
     * @param period2_start_lighting the period2_start_lighting to set
     */
    public void setPeriod2_start_lighting(String period2_start_lighting) {
        this.period2_start_lighting = period2_start_lighting;
    }

    /**
     * @return the period2_stop_lighting
     */
    public String getPeriod2_stop_lighting() {
        return period2_stop_lighting;
    }

    /**
     * @param period2_stop_lighting the period2_stop_lighting to set
     */
    public void setPeriod2_stop_lighting(String period2_stop_lighting) {
        this.period2_stop_lighting = period2_stop_lighting;
    }

    /**
     * @return the radiation1_to_open_lighting
     */
    public String getRadiation1_to_open_lighting() {
        return radiation1_to_open_lighting;
    }

    /**
     * @param radiation1_to_open_lighting the radiation1_to_open_lighting to set
     */
    public void setRadiation1_to_open_lighting(String radiation1_to_open_lighting) {
        this.radiation1_to_open_lighting = radiation1_to_open_lighting;
    }

    /**
     * @return the radiation2_to_open_lighting
     */
    public String getRadiation2_to_open_lighting() {
        return radiation2_to_open_lighting;
    }

    /**
     * @param radiation2_to_open_lighting the radiation2_to_open_lighting to set
     */
    public void setRadiation2_to_open_lighting(String radiation2_to_open_lighting) {
        this.radiation2_to_open_lighting = radiation2_to_open_lighting;
    }

    /**
     * @return the roof_vent_open_time
     */
    public String getRoof_vent_open_time() {
        return roof_vent_open_time;
    }

    /**
     * @param roof_vent_open_time the roof_vent_open_time to set
     */
    public void setRoof_vent_open_time(String roof_vent_open_time) {
        this.roof_vent_open_time = roof_vent_open_time;
    }

    /**
     * @return the side_vent_open_time
     */
    public String getSide_vent_open_time() {
        return side_vent_open_time;
    }

    /**
     * @param side_vent_open_time the side_vent_open_time to set
     */
    public void setSide_vent_open_time(String side_vent_open_time) {
        this.side_vent_open_time = side_vent_open_time;
    }

    /**
     * @return the shade_screen_out_open_time
     */
    public String getShade_screen_out_open_time() {
        return shade_screen_out_open_time;
    }

    /**
     * @param shade_screen_out_open_time the shade_screen_out_open_time to set
     */
    public void setShade_screen_out_open_time(String shade_screen_out_open_time) {
        this.shade_screen_out_open_time = shade_screen_out_open_time;
    }

    /**
     * @return the shade_screen_in_open_time
     */
    public String getShade_screen_in_open_time() {
        return shade_screen_in_open_time;
    }

    /**
     * @param shade_screen_in_open_time the shade_screen_in_open_time to set
     */
    public void setShade_screen_in_open_time(String shade_screen_in_open_time) {
        this.shade_screen_in_open_time = shade_screen_in_open_time;
    }

    /**
     * @return the thermal_screen_open_time
     */
    public String getThermal_screen_open_time() {
        return thermal_screen_open_time;
    }

    /**
     * @param thermal_screen_open_time the thermal_screen_open_time to set
     */
    public void setThermal_screen_open_time(String thermal_screen_open_time) {
        this.thermal_screen_open_time = thermal_screen_open_time;
    }
    
    
    
}

