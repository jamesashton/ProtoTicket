package com.aka.prototicket.service.prediction;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import io.prediction.Client;
import io.prediction.Item;
import io.prediction.ItemRecGetTopNRequestBuilder;
import io.prediction.ItemSimGetTopNRequestBuilder;
import io.prediction.UnidentifiedUserException;
import io.prediction.User;
import io.prediction.UserActionItemRequestBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PredictionHelper
{
	@Value("${prediction.apiUrl}")
	private String apiUrl;
	
	@Value("${prediction.appKey}")
	private String appKey;
	
	private Client client;

	public PredictionHelper()
	{
	}

	public void setAppKey(String appKey)
	{
		if(client != null)
		{
			client.close();
			client = null;
		}
		this.appKey = appKey;
	}
	public String getAppKey()
	{
		return appKey;
	}
	
	public void setApiUrl(String apiUrl)
	{		
		if(client != null)
		{
			client.close();
			client = null;
		}
		this.apiUrl = apiUrl;
	}
	public String getApiUrl()
	{
		return apiUrl;
	}
	
	public void close()
	{
		client.close();
	}

	public void initialise()
	{
		if(client!=null)
		{
			client.close();
		}
		client = new Client(appKey, apiUrl);
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
	public String[] getRecommendations(String userId, int count)
	{
		String[] results = new String[]{};
		try
		{
			identify(userId);  
			ItemRecGetTopNRequestBuilder builder = client.getItemRecGetTopNRequestBuilder("TestItemRecommendationEngine", count);
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
			if(e.getMessage().equalsIgnoreCase("java.io.IOException: {\"message\":\"Cannot find items for user.\"}")){}
			else
			{	
				throw new RuntimeException(e);
			}
		}
		return results;
	}
	public String[] getSimilar(String itemId, int count)
	{
		String[] result = null;
		try
		{
			ItemSimGetTopNRequestBuilder builder = client.getItemSimGetTopNRequestBuilder("TestItemSimilarityEngine", itemId, count);	
			result = client.getItemSimTopN(builder);
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
			if(e.getMessage().indexOf("Cannot find similar items for item.") > -1)
			{}
			else
			{	
				throw new RuntimeException(e);
			}
		}
		
		return result; 
	}
}
