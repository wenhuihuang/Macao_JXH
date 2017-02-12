package com.fg.utils;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SendPostMessage {

	private HttpURLConnection conn = null;

	public boolean send(String urlAddr, Map map) throws Exception {

		boolean isSuccess = false;
		StringBuffer params = new StringBuffer();

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry element = (Entry) it.next();
			params.append(element.getKey());
			params.append("=");
			params.append(element.getValue());
			params.append("&");
		}

		if (params.length() > 0) {
			params.deleteCharAt(params.length() - 1);
		}
		System.out.println("params : " + params);
		try {
			URL url = new URL(urlAddr);
			conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length",
					String.valueOf(params.length()));
			conn.setDoInput(true);
			conn.connect();

			OutputStreamWriter out = new OutputStreamWriter(
					conn.getOutputStream(), "UTF-8");
			out.write(params.toString());
			out.flush();
			out.close();

			int code = conn.getResponseCode();
			System.out.println("code : " + code );
			if (code != 200) {
				System.out.println("ERROR===" + code);
			} else {
				isSuccess = true;
				System.out.println("Success!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return isSuccess;
	}

	public static void main(String[] args) {
		SendPostMessage send = new SendPostMessage();
		String urlAddr = "http://202.75.248.226/HttpSend/HttpSendAction";
		Map<String,String> map = new HashMap<String,String>();
//		private String corpid = "68873";// ��ҵ�û���
//		private String time = "1308191750";
//		private String username = "admin@58698";
//		private String password = "Ah#yyh32";// ��ҵ����
//		private String from = "62139500";
//		private String to = "15363567895";
//		private String text = "hello,this is �� testing message !";
		
		
		
		map.put("copid", "20987");
		map.put("time", "1408221205");
		map.put("username", "jzxj");
		map.put("password", "jzxj@853");
		
		map.put("from", "65604247");
		map.put("to", "8618026832573");
		
		/*map.put("time", "1408181015");
		map.put("username", "65604247");
		map.put("password", "1qaz!QAZ");
		
		map.put("from", "18165604247");*/
		//map.put("from", "65604247");
		
		//map.put("to", "63581702");
		//map.put("to", "8613902886973");
		
		map.put("text", "HELLOWORLD");
		try {
			send.send(urlAddr, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
