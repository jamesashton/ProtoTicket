package com.aka.prototicket.service.prediction;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import io.prediction.Client;
import io.prediction.Item;
import io.prediction.ItemRecGetTopNRequestBuilder;
import io.prediction.ItemSimGetTopNRequestBuilder;
import io.prediction.UnidentifiedUserException;
import io.prediction.User;
import io.prediction.UserActionItemRequestBuilder;

import org.springframework.stereotype.Component;

@Component
public class PredictionHelper
{
	private static final String API_URL = "http://localhost:8000";
	private String appKey = "Not Set";
	private String apiUrl;
	
	Client client;

	public PredictionHelper()
	{
	}

	public void initialise()
	{
		if(client != null)
		{
			client.close();
		}
		client = new Client(appKey);
	}
	
	public void setAppKey(String appKey)
	{
		this.appKey = appKey;
	}

	public void setApiUrl(String apiUrl)
	{
		
		this.apiUrl = apiUrl;
		
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
			String enc = URLEncoder.encode(itemId, "utf-8");
			client.createItem(enc, itemTypes);
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
			String enc = URLEncoder.encode(itemId, "utf-8");
			client.deleteItem(enc);
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
			String enc = URLEncoder.encode(itemId, "utf-8");
			item = client.getItem(enc);
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
	public void recordViewActionOnItem(String userId, String itemId)
	{
		try
		{
			String enc = URLEncoder.encode(itemId, "utf-8");
			identify(userId);
			UserActionItemRequestBuilder builder = client.getUserActionItemRequestBuilder(UserActionItemRequestBuilder.VIEW, enc);
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
	public void recordBuyActionOnItem(String userId, String itemId)
	{
		try
		{
			String enc = URLEncoder.encode(itemId, "utf-8");
			identify(userId);
			UserActionItemRequestBuilder builder = client.getUserActionItemRequestBuilder(UserActionItemRequestBuilder.CONVERSION, enc);
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
	public void recordRateActionOnItem(String userId, String itemId, int rating)
	{
		try
		{
			String enc = URLEncoder.encode(itemId, "utf-8");
			identify(userId);
			UserActionItemRequestBuilder builder = client.getUserActionItemRequestBuilder(UserActionItemRequestBuilder.RATE, enc);
			builder.rate(rating);
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
			ItemRecGetTopNRequestBuilder builder = client.getItemRecGetTopNRequestBuilder("engine1", count);
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
			String enc = URLEncoder.encode(itemId, "utf-8");
			ItemSimGetTopNRequestBuilder builder = client.getItemSimGetTopNRequestBuilder("TestItemSimilarityEngine", enc, count);	
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
