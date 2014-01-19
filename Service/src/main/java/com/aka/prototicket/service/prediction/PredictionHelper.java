package com.aka.prototicket.service.prediction;

import io.prediction.Client;
import io.prediction.User;

import org.springframework.stereotype.Component;

@Component
public class PredictionHelper
{

	Client client;

	public PredictionHelper()
	{
	}

	public void setAppKey(String appKey)
	{

		this.client = new Client(appKey);
	}

	public void setApiUrl(String apiUrl)
	{
		client.setApiUrl(apiUrl);
	}

	public void close()
	{
		client.close();
	}

	public String getStatus()
	{
		String rtn;
		try
		{
			rtn = client.getStatus();
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return rtn;
	}

	public void addUser(String userId)
	{
		try
		{
			client.createUser(userId);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public void addItem(String itemId, String[] itemTypes)
	{
		try
		{
			client.createItem(itemId, itemTypes);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public void deleteUser(String userId)
	{
		try
		{
			client.deleteUser(userId);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public void deleteItem(String itemId)
	{
		try
		{
			client.deleteItem(itemId);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public User getUser(String userId)
	{
		User user;
		try
		{
			user = client.getUser(userId);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return user;
	}
}
