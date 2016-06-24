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
    private static String in_radiation="10000";
    private static String in_co2="420";    
	private static String winddirection="无";
    private static String atmosphere="1000";
    private static String rain="false";
    private static String updatetime="0-0-0-0";
    private static String roof_vent_north="off";
    private static String roof_vent_south="off";
    private static String side_vent="off";
    private static String shade_screen_out="off";
    private static String shade_screen_in="off";
    private static String thermal_screen="off";
    private static String cooling_pad="off";
    private static String fogging="off";
    private static String heating="off";
    private static String co2="off";
    private static String lighting_1="off";
    private static String lighting_2="off";
    private static String irrigation="off";
    
    
    /*"roof_vent_south": "on",
                    "roof_vent_north": "off",
                    "side_vent": "off",
                    "shade_screen_out": "off",
                    "shade_screen_in": "off",
                    "thermal_screen": "off"
                },
                "bi_state":{
                    "cooling_pad": "on",
                    "fogging": "off",
                    "heating": "off",
                    "co2": "off",
                    "lighting_1": "off",
                    "lighting_2": "off",
                    "irrigation": "off"
     * 
     * */

    
    
    public static String getWinddirection() {
		return winddirection;
	}

	public static void setWinddirection(String winddirection) {
		Data.winddirection = winddirection;
	}

	public static String getAtmosphere() {
		return atmosphere;
	}

	public static void setAtmosphere(String atmosphere) {
		Data.atmosphere = atmosphere;
	}

	public static String getRain() {
		return rain;
	}

	public static void setRain(String rain) {
		Data.rain = rain;
	}
    
    public static String getUpdatetime() {
		return updatetime;
	}

	public static void setUpdatetime(String aupdatetime) {
		updatetime = aupdatetime;
	}

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

    public static String getIn_radiation() {
        return in_radiation;
    }

    public static void setIn_radiation(String aIn_radiation) {
        in_radiation = aIn_radiation;
    }

    public static String getIn_co2() {
        return in_co2;
    }

    public static void setIn_co2(String aIn_co2) {
        in_co2 = aIn_co2;
    }

    public static String getRoof_vent_north() {
		return roof_vent_north;
	}

	public static void setRoof_vent_north(String roof_vent_north) {
		Data.roof_vent_north = roof_vent_north;
	}

	public static String getRoof_vent_south() {
		return roof_vent_south;
	}

	public static void setRoof_vent_south(String roof_vent_south) {
		Data.roof_vent_south = roof_vent_south;
	}

	public static String getSide_vent() {
		return side_vent;
	}

	public static void setSide_vent(String side_vent) {
		Data.side_vent = side_vent;
	}

	public static String getShade_screen_out() {
		return shade_screen_out;
	}

	public static void setShade_screen_out(String shade_screen_out) {
		Data.shade_screen_out = shade_screen_out;
	}

	public static String getShade_screen_in() {
		return shade_screen_in;
	}

	public static void setShade_screen_in(String shade_screen_in) {
		Data.shade_screen_in = shade_screen_in;
	}

	public static String getThermal_screen() {
		return thermal_screen;
	}

	public static void setThermal_screen(String thermal_screen) {
		Data.thermal_screen = thermal_screen;
	}

	public static String getCooling_pad() {
		return cooling_pad;
	}

	public static void setCooling_pad(String cooling_pad) {
		Data.cooling_pad = cooling_pad;
	}

	public static String getFogging() {
		return fogging;
	}

	public static void setFogging(String fogging) {
		Data.fogging = fogging;
	}

	public static String getHeating() {
		return heating;
	}

	public static void setHeating(String heating) {
		Data.heating = heating;
	}

	public static String getCo2() {
		return co2;
	}

	public static void setCo2(String co2) {
		Data.co2 = co2;
	}

	public static String getLighting_1() {
		return lighting_1;
	}

	public static void setLighting_1(String lighting_1) {
		Data.lighting_1 = lighting_1;
	}

	public static String getLighting_2() {
		return lighting_2;
	}

	public static void setLighting_2(String lighting_2) {
		Data.lighting_2 = lighting_2;
	}

	public static String getIrrigation() {
		return irrigation;
	}

	public static void setIrrigation(String irrigation) {
		Data.irrigation = irrigation;
	}


    
    public static void getindoor()
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
  
    public static void getoutdoor()
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
    public static void getcontrolstate()
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
   	   		Data.setRoof_vent_south(change(tri.getString("roof_vent_south")));
   	   		Data.setRoof_vent_north(change(tri.getString("roof_vent_north")));
   	   		Data.setSide_vent(change(tri.getString("side_vent")));
   	   		Data.setShade_screen_out(change(tri.getString("shade_screen_out")));
   	   		Data.setShade_screen_in(change(tri.getString("shade_screen_in")));
   	   		Data.setThermal_screen(change(tri.getString("thermal_screen")));
   	   		Data.setCooling_pad(change(bi.getString("cooling_pad")));
   	   		Data.setFogging(change(bi.getString("fogging")));
   	   		Data.setHeating(change(bi.getString("heating")));
   	   		Data.setCo2(change(bi.getString("co2")));
   	   		Data.setLighting_1(change(bi.getString("lighting_1")));
   	   		Data.setLighting_2(change(bi.getString("lighting_2")));
   	   		Data.setIrrigation(change(bi.getString("irrigation")));
   	}
    public static String getparameter()
   	{	
   		String httpurl="http://127.0.0.1:8020/parameter";
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
   		    	
   			return sb==null?"error":sb.toString();
   		
   	}

   public static String change(String s)
   {	
	   String open="开";
	   String close="关";
	   int status=0;
	   if (s.equals("on"))
		   status=1;	   
	return status==1?open:close;
   }
   
    public static String post_controlcommand()
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
    
    public static void postParameter(String s)
   	{	
   		String httpurl="http://127.0.0.1:8020/control";
   		String command=s;
   		//StringBuffer sb=new StringBuffer();
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
   		}
   		catch(Exception e)
   		{
   			System.out.println(e.toString());
   		}
   		
             //return sb==null?"error":sb.toString();
   		System.out.println("post parameter success");
   		
   	}


   
    
   
    
}
