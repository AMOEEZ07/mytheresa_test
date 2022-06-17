package com.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.utils.URIBuilder;

public class Util {
	
	public static final String PRICE_PATTREN = "^(\\$|USD|£|PND)?[0-9]+(\\.[0-9][0-9]?)?(\\$|USD|£|PND)?";
	public static final String PRICE_VALUE_PATTREN = "([0-9]+(\\.[0-9][0-9]?)?)";
	public static final String PRICE_TYPE_PATTREN = "(\\$|USD|£|PND|EUR|€)";
	public static final String STRONG_PASSOWRD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{#passwordLenght,}$";
	public static HashMap<String, String> properNames = null;
	
	
	public static boolean isNullOrEmpty(String value) {
		return value == null || "".equals(value);
	}
	
	public static boolean isNotNullOrEmpty(String value) {
		return value != null && !"".equals(value) && !"null".equals(value);		
	}
	
	public static boolean isNullOrEmptyTrimmed(String value) {
		return value == null || "".equals(value.trim());
	}
	
	public static String concate(List<? extends Object> strings, String seprater) {
		if(strings == null){
			return "";
		}
		return concate(strings.toArray(new Object[strings.size()]), seprater);
	}

	public static String concate(Object[] strings, String seprater) {
		String str = "";
		if(strings != null){
			for (Object obj : strings) {
				if(obj != null && !isNullOrEmptyTrimmed(obj.toString())){
					if(!str.isEmpty()){
						str += seprater;
					}
					str += obj.toString();
				}
			}
		}
		return str;
	}
	
	public static Double parseDouble(String value) {

		if(isNullOrEmpty(value)) {
			return null;
		}

		try {
			return Double.valueOf(value);
		}
		catch (NumberFormatException e) {
		}

		return null;
	}
	
	public static Boolean parseBoolean(String value) {

		try {
			return Boolean.valueOf(value);
		}
		catch (Exception e) {
			return null;
		}
		
	}

	public static Long parseLong(String value) {

		if(isNullOrEmpty(value)) {
			return null;
		}
		try {
			return Long.valueOf(value.trim());
		}
		catch (NumberFormatException e) {}
		return null;
	}
	
	public static Integer parseInteger(String value) {

		if(isNullOrEmpty(value)) {
			return null;
		}
		try {
			return Integer.valueOf(value);
		}
		catch (NumberFormatException e) {}
		return null;
	}

	public static List<Long> splitIds(String str, String seprator) {
		List<Long> ids = new ArrayList<Long>();
		if(isNullOrEmpty(str) || isNullOrEmpty(seprator)){
			return ids;
		}
		String[] arr = str.split(seprator);
		for (String idStr : arr) {
			Long id = parseLong(idStr.trim());
			if(id != null){
				ids.add(id);
			}
		}
		return ids;
	}
	
	public static List<String> stringToList(String str, String seprator) {
		List<String> list = new ArrayList<String>();
		if(isNullOrEmpty(str) || isNullOrEmpty(seprator)){
			return list;
		}
		String[] arr = str.split(seprator);
		for (String idStr : arr) {
			list.add( idStr );
		}
		return list;
	}
	
	public static String[] split(String str, String seprator) {
		if(isNullOrEmpty(str) || isNullOrEmpty(seprator)){
			return new String[]{};
		}
		return str.split(seprator);
	}
	
	
	
	public static boolean isValidPrice(String price){
		
		if(!isNullOrEmptyTrimmed(price)){
			return Pattern.matches(PRICE_PATTREN, price.replace(",", ""));
		}
		return false;
	}
	
	public static String parseSignedRequest(String signedRequest) {
        if(!isNullOrEmptyTrimmed(signedRequest)){
            String payLoad = signedRequest.split("[.]")[1];            
            return new String(Base64.decodeBase64(payLoad));
        }
        return null;
    }
	

	public static String getUniqueId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String getHexString(Long id, int length) {
		if(id == null){
			return null;
		}
		String str = Long.toHexString(id);
		while(str.length() < length){
			str = "0"+str;
		}
		return str;
	}
	
	public static Double getPrice(String price){
		if(isNullOrEmptyTrimmed(price)){
			return null;
		}
		Pattern pattern = Pattern.compile(PRICE_VALUE_PATTREN);
		Matcher matcher = pattern.matcher(price.replace(",", ""));
		if (matcher.find()){
		    return parseDouble(matcher.group(1));
		}
		return null;
	}
	
	public static String getFileExtension(String fileName){
		if(Util.isNullOrEmptyTrimmed(fileName)){
			return null;
		}
		int mid = fileName.lastIndexOf(".");
		if(mid < 0){
			return null;
		}
		return fileName.substring(mid+1); 
	}
	
	
	
	public static void main(String[] arg){
		String signedRequest = "34PuGnrZf3vXdsEw5yOKIiJg9eLQ6CPQH0Ygm3JIQNM.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImNvZGUiOiJBUUFZUDlOMkxmZUo0UVBjXzJPRFpvLS0xTm5SV0Q1djRVaEFKd2t5T3BqeFZXd0tkX3dDNGxYS1FjTW8xT3psYkxCbHVDUm93d1hxWGJURlhYMEQ2dTNPdXhZbTF4Y2d0WWJGT0JwSHFDYl9CS2EtRnRWdjFqWmRnOC1iSVEtNFBkR2lyc293bU5YbE9BM0NjVzdjQVhsb1dWYnQ1ZW5abjY4LThzMXJOYTg1TWxWaEVZQVh0LU1McTBFVzduWlZaMk1kQ25NTWdGRnFHT3RSQ3oyaHNPRWoiLCJpc3N1ZWRfYXQiOjEzNTA5MTc3MjAsInVzZXJfaWQiOiIxMDAwMDAxMDIzNDI3MDUifQ";
		System.out.println(Util.parseSignedRequest(signedRequest));
	}

	public static String getCountString(int buyingOptionsCount) {
		if(buyingOptionsCount <= 0){
			return "";
		}
		int mod = buyingOptionsCount % 10;
		if(mod == 1){
			return buyingOptionsCount+"st";
		} 
		if(mod == 2){
			return buyingOptionsCount+"nd";
		} 
		if(mod == 3){
			return buyingOptionsCount+"rd";
		} 
		return  buyingOptionsCount+"th";			
	}

	public static Long[] toArray(List<Long> ids) {
		if(ids != null){
			return ids.toArray(new Long[ids.size()]);
		}
		return new Long[0];
	}

	public static Boolean isProperName(String keyword) {
		if(keyword == null){
			return false;
		}
		if(properNames ==  null || properNames.size() == 0){
			properNames = new HashMap<String, String>();
			BufferedReader br = new BufferedReader( new InputStreamReader(Util.class.getClassLoader().getResourceAsStream("propernames.txt")));
			String name;
    		try {
				while ((name = br.readLine()) != null) {
					name = name.toLowerCase();
					properNames.put(name, name);
				}
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} 
		}
		return properNames.containsValue(keyword.toLowerCase());
	}

	public static String getFormatString(String queryKeyword) {
		if(Util.isNullOrEmptyTrimmed(queryKeyword)){
			return null;
		}
		String formatedString = "";
		for(String word : queryKeyword.split(" ")){
			if(!Util.isNullOrEmptyTrimmed(word)){
				formatedString = formatedString + word + " ";
			}
		}
		return formatedString.trim();
	}

	public static String formatStringForUrlQuery(String queryKeyword) {
		String urlQuery = "";
		String[] queryTokens = queryKeyword.split(" ");
		for(int index = 0; index < queryTokens.length; index ++ ){
			if(index == queryKeyword.split(" ").length -1){
				urlQuery = urlQuery + queryTokens[index];
			} else{
				urlQuery = urlQuery + queryTokens[index] + "+";
			}	
		}
		return urlQuery;
	}
	
	public static String constructURL(Map<String, Object> map) {
		URIBuilder builder = new URIBuilder();
		Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> pairs = (Map.Entry<String, Object>)it.next();
            if(pairs.getValue() != null) {
            	builder = builder.addParameter(pairs.getKey(), String.valueOf(pairs.getValue()));
            }
        }
        
        try {
			URI uri = builder.build();
			return uri.getQuery();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	public static String getExcelFileName(Date date , String fileName){
		String formatedDate = "";
		String completeFileName  = "";
		if(date != null)
			formatedDate = new SimpleDateFormat("YYYYMMdd").format(date);
		
		if(fileName != null)
		  completeFileName = fileName.replace(".xlsx", "");
		completeFileName = completeFileName+"_"+formatedDate+".xlsx";
		
		return completeFileName;
	}
	
	public static String getExcelNameWithTable(String tableName , String fileName){
		String completeFileName  = "";
		if(tableName != null && fileName != null){
			completeFileName = fileName.replace(".xlsx", "_"+tableName+".xlsx");
		}
		return completeFileName;
	}
	
	public static ArrayList<Long> convertStringIdsToLongIds(String ids){
		ArrayList<Long> inputIds = new ArrayList<>();
		if(isNotNullOrEmpty(ids)){
			String[] inputIdsStringArray = ids.split(",");
			
			for (int j = 0; j < inputIdsStringArray.length; j++) {
				inputIds.add( Long.valueOf( inputIdsStringArray[j] ) );
			}
			return inputIds;
		}
		return inputIds;
	}
	
	//
	public static ArrayList<String> getHeaderColumnsListFromSelectQuery(String query ){
		ArrayList<String> colList = new ArrayList<String>();
		try{
			if( isNotNullOrEmpty( query ) ){
				query = query.replace(" as ", " AS ");
				String columnLis = query.substring(query.indexOf("SELECT") + 6 , query.indexOf("FROM"));
				
				if(columnLis.equals("*") || colList.contains("*")){
					return colList;
				}else{
					for(String col : columnLis.split(",")){
						if( col.contains(" AS ")){
							colList.add( col.substring(col.indexOf("AS") + 2, col.length() ) );
						}else {
							colList.add( col );
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			colList = new ArrayList<String>();
		}
		return colList;

	}
	
    public static BigDecimal getBigDecimal( Object value ) {
        BigDecimal ret = null;
        if( value != null ) {
            if( value instanceof BigDecimal ) {
                ret = (BigDecimal) value;
            }else if( value instanceof String ) {
                ret = new BigDecimal( (String) value );
            }
        }
        return ret;
    }
	
    public static String getStringValue(Object object){
		return object != null ? String.valueOf(object) : null;
    }
    
    public static Integer getIntegerValue(Object object){
		return object != null ? Integer.valueOf(getStringValue(object)) : null;
    }
    
    public static Long getLongValue(Object object){
		return object != null ? parseLong(getStringValue(object)) : null;
    }
    
    public static String getEncodedURLString(String value){
    	try {
    		if(isNotNullOrEmpty(value)){
    			value = value.replace(" ", "-").replace("/", "").replace("\\", "");
    			return URLEncoder.encode(value, "UTF-8");
    		}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return "";
    }
    
    public static String getTrimmedValue(String value) {
    	return getStringValue(value.trim());
    }
}
