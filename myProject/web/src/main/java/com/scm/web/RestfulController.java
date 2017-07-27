package com.scm.web;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scm.bean.Message;
import com.scm.bean.Response;
import com.scm.utils.JsonMapper;

/**
 * Created by admin on 2017-06-14.
 */
@RestController
@EnableAutoConfiguration
public class RestfulController {

		// 查账户信息的http地址
		private static String URL_GET_USER_INFO = "http://127.0.0.1:8081/getP";

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Response get(@PathVariable String id) {
			Response response = new Response();
			response.success(new Message(id,"获取成功"));
			return response;
    }

		@RequestMapping(value = "/getP", method = RequestMethod.POST)
		public Response getP(String id) {
			Response response = new Response();
			response.success(new Message(id,"获取成功"));
			return response;
		}

    @RequestMapping("/home")
		public Response home() {
			NameValuePair[] data = new NameValuePair[]{new NameValuePair("id", "23")};
			String s = doPost(URL_GET_USER_INFO, data);
			Object o = JsonMapper.fromJsonString(s, Response.class);
			Response response = (Response)o;
			return response;
		}

	private static String doPost(String url, NameValuePair[] data) {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		// method.setRequestHeader("ContentType",
		// "application/x-www-form-urlencoded;charset=UTF-8");
		method.setRequestBody(data);
		// client.getParams().setContentCharset("UTF-8");
		client.getParams().setConnectionManagerTimeout(10000);
		try {
			client.executeMethod(method);
			return method.getResponseBodyAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
