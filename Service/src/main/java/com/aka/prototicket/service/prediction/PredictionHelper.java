package com.aka.prototicket.service.prediction;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import io.prediction.Client;
import io.prediction.Item;
import io.prediction.ItemRecGetTopNRequestBuilder;
import io.prediction.UnidentifiedUserException;
import io.prediction.User;
import io.prediction.UserActionItemRequestBuilder;

import org.springframework.stereotype.Component;

@Component
public class PredictionHelper
{
	private static final String API_URL = "http://192.168.0.2:8000";
	
	Client client;

	public PredictionHelper()
	{
	}

	public void setAppKey(String appKey)
	{
		if(client != null)
		{
			client.close();
		}
		this.client = new Client(appKey);
		setApiUrl(API_URL);
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

	public Item getItem(String itemId)
	{	
		Item item;
		try
		{
			item = client.getItem(itemId);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return item;
	}
	public User getUser(String userId)
	{
		User user;
		try
		{
			user = client.getUser(userId);
		}
		catch(IOException ie)
		{
			if(ie.getMessage().equalsIgnoreCase("{\"message\":\"Cannot find user.\"}"))
			{
				user = null;
			}
			else
			{
				throw new RuntimeException(ie);
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return user;
	}
	public void identify(String userId)
	{
		client.identify(userId);
	}
	public void recordActionOnItem(String userId, String itemId)
	{
		try
		{
			identify(userId);
			UserActionItemRequestBuilder builder = client.getUserActionItemRequestBuilder(UserActionItemRequestBuilder.VIEW, itemId);
			client.userActionItem(builder);
			
		}
		catch(UnidentifiedUserException e)
		{
			throw new RuntimeException(e);
		}
		catch(ExecutionException e)
		{
			throw new RuntimeException(e);
		}
		catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	public void deleteAction()
	{
		// TODO: Delete Action
	}
	public String[] getPrediction(String userId)
	{
		String[] results = null;
		try
		{
			identify(userId);  
			ItemRecGetTopNRequestBuilder builder = client.getItemRecGetTopNRequestBuilder("TestItemRecommendationEngine", 5);
			results = client.getItemRecTopN(builder);
			
		}
		catch(UnidentifiedUserException e)
		{
			throw new RuntimeException(e);
		}
		catch(ExecutionException e)
		{
			throw new RuntimeException(e);
		}
		catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
		return results;
	}
	
}
