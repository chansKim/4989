package com.ju.chan;
import java.util.Date;
public class FUpUtil {
	//f=abc.zip => f.indexOf('.') 3
	//f.substring(3)
	//f.substring(0,3)
	public static String getNewFile(String f){
		String filename="";
		String fpost="";
		String fre="";
		if(f.indexOf('.')>=0){
			fpost=f.substring(f.lastIndexOf('.'));
			fre=f.substring(0,f.lastIndexOf('.'));
			filename=fre+new Date().getTime()+fpost;
		}else{
			filename=f+new Date().getTime()+".back";
		}
		return filename;
	} 
}

