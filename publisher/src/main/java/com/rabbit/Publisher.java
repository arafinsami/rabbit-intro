package com.rabbit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	public static void main(String[] args) throws IOException, TimeoutException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		Map<String, String> map = new HashMap<String, String>();
		map.put("firstName", "Md.Samiul");
		map.put("lastName", "Arafin");
		map.put("email", "sami.cse.1112@gmail.com");

		String jsonstr = new Gson().toJson(map);

		channel.basicPublish("", "Queue-1", null, jsonstr.getBytes());
		channel.close();
		connection.close();
	}

}
