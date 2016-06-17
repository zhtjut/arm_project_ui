package com;
import java.io.*;
import java.util.*;

import gnu.io.CommPortIdentifier; 
import gnu.io.NoSuchPortException; 
import gnu.io.PortInUseException; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;  
import gnu.io.SerialPortEventListener;  
import gnu.io.UnsupportedCommOperationException; 

public class Serialcomm implements Runnable,SerialPortEventListener{	   
static CommPortIdentifier portId;	   
static String messageString = "FE050001FF00C9F5";	    
static SerialPort serialPort;	    
static OutputStream outputStream;
static InputStream inputStream;
static int num;
public Serialcomm()
{	initSerial();
	Thread readThread = new Thread(this);   
	readThread.start();
}


public  void initSerial()
{	try
		{
			portId=CommPortIdentifier.getPortIdentifier("COM2");	
		}
		catch(NoSuchPortException e){e.printStackTrace();}

	try {
	    serialPort = (SerialPort)
	        portId.open("SimpleWrite", 2000);
		} 
	catch (PortInUseException e) {e.printStackTrace();}
	
	try {
	    serialPort.setSerialPortParams(9600,
	        SerialPort.DATABITS_8,
	        SerialPort.STOPBITS_1,
	        SerialPort.PARITY_NONE);
		} 
	catch (UnsupportedCommOperationException e) {e.printStackTrace();}
	
	try {
	    outputStream = serialPort.getOutputStream();
	    inputStream=serialPort.getInputStream();
		} 
	catch (IOException e) {e.printStackTrace();}


	
	try { 
		serialPort.addEventListener(this); 
	} catch (TooManyListenersException e) {e.printStackTrace();} 
	
	serialPort.notifyOnDataAvailable(true); 
}

public static void writer(String s)
{
	try {
        outputStream.write(hexStringToBytes(s));
    } 
	catch (IOException e) {}
}

public void serialEvent(SerialPortEvent event) {
	switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[50];

		try {
			while (inputStream.available() > 0) {
				num=inputStream.read(readBuffer);
			}
			System.out.println(bytesToHexString(readBuffer));
			if(num==6)
			{
					if(readBuffer[3]==0x01)
				{
					System.out.println("open!!!");
				}
				if(readBuffer[3]==0x00)
				{
					System.out.println("close!!!");
				}
			}
			
				
		} catch (IOException e) {
			
		}
	}
}

public static String bytesToHexString(byte[] src){  
    StringBuilder stringBuilder = new StringBuilder("");  
    if (src == null || src.length <= 0) {  
        return null;  
    }  
    for (int i = 0; i < num; i++) {  
        int v = src[i] & 0xFF;  
        String hv = Integer.toHexString(v);  
        if (hv.length() < 2) {  
            stringBuilder.append(0);  
        }  
        stringBuilder.append(hv);  
    }  
    return stringBuilder.toString();  
}

private static byte charToByte(char c){
	return (byte) "0123456789ABCDEF".indexOf(c);
}
//private static byte charToByte(char c) {
  //  return (byte) "0123456789ABCDEF".indexOf(c);  
//}  
public static byte[] hexStringToBytes(String hexString){
	if (hexString==null||hexString.equals(""))
			return null;
	hexString=hexString.toUpperCase();
	int length=hexString.length()/2;
	char[] hexChars=hexString.toCharArray();
	byte[] res=new byte[length];
	for(int i=0;i<length;i++){
		int pos=i*2;
		res[i]=(byte)(charToByte(hexChars[pos])<<4|charToByte(hexChars[pos+1]));
	}
	return res;
}

public void run() {
	
	try {     
		Thread.sleep(100);    
	} catch (InterruptedException e) {   }  
}

	
	
}
