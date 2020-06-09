package com.sist.book;
import java.net.InetSocketAddress;
import java.util.*;
import com.mongodb.*;
public class BookDAO {
    private MongoClient mc;
    private DB db;
    private DBCollection dbc;
    
    public BookDAO()
    {
    	//mc=new MongoClient(new ServerAddress(new InetSocketAddress("211.238.142.192",27017)));
    	try
    	{
    		mc=new MongoClient(new ServerAddress("localhost",27017));
    		db=mc.getDB("mydb");
    		dbc=db.getCollection("book");
    	}catch(Exception ex){}
    }
    /*
     *  private int no;
	    private String title;
	    private String poster;
	    private String chef;
	    private String link;
     */
    public void bookInsert(BookVO vo)
    {
    	try
    	{
    		/*int max=0;
    		DBCursor cursor=dbc.find();
    		while(cursor.hasNext())
    		{
    			 BasicDBObject data=(BasicDBObject)cursor.next();
    			 int no=data.getInt("no");
    			 if(max<no)
    				 max=no;
    		}
    		cursor.close();*/
    		BasicDBObject obj=new BasicDBObject();
    		obj.put("no", vo.getNo());
    		obj.put("title", vo.getTitle());
    		obj.put("poster", vo.getPoster());
    		obj.put("author", vo.getAuthor());
    		obj.put("publisher", vo.getPublisher());
    		obj.put("regdate", vo.getRegdate());
    		obj.put("price", vo.getPrice());
    		
    		dbc.insert(obj);
    		
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    }
    /*
     * private String poster;
    private String chef;
    private String mem_cont1;
    private String mem_cont3;
    private String mem_cont7;
    private String mem_cont2;
     */
/*    public List<RecipeVO> recipeListData()
    {
    	List<RecipeVO> list=new ArrayList<RecipeVO>();
    	try
    	{
    		dbc=db.getCollection("recipe");
    		DBCursor cursor=dbc.find();
    		int k=1;
    		while(cursor.hasNext())
    		{
    			BasicDBObject obj=(BasicDBObject)cursor.next();
    			RecipeVO vo=new RecipeVO();
    			vo.setNo(obj.getInt("no"));
    			vo.setLink(obj.getString("link"));
    			list.add(vo);
    			System.out.println("k="+k);
    			k++;
    		}
    		cursor.close();
    	}catch(Exception ex){}
    	return list;
    }
    public void chefInsert(ChefVO vo)
    {
    	try
    	{
    		BasicDBObject obj=new BasicDBObject();
    		obj.put("poster", vo.getPoster());
    		obj.put("chef", vo.getChef());
    		obj.put("mem_cont1", vo.getMem_cont1());
    		obj.put("mem_cont3", vo.getMem_cont3());
    		obj.put("mem_cont7", vo.getMem_cont7());
    		obj.put("mem_cont2", vo.getMem_cont2());
    		
    		dbc.insert(obj);
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    }*/
    /*
     *  private int no;
	    private String poster;
	    private String title;
	    private String chef;
	    private String chef_poster;
	    private String chef_profile;
	    private String info1,info2,info3;
	    private String content;
	    private String foodmake;
     */
  /*  public void recipeDetailInsert(RecipeDetailVO vo)
    {
    	try
    	{
    		dbc=db.getCollection("recipe_detail");
    	    BasicDBObject obj=new BasicDBObject();
    	    obj.put("no", vo.getNo());
    	    obj.put("poster", vo.getPoster());
    	    obj.put("title", vo.getTitle());
    	    obj.put("chef", vo.getChef());
    	    obj.put("chef_poster", vo.getChef_poster());
    	    obj.put("chef_profile", vo.getChef_profile());
    	    obj.put("info1", vo.getInfo1());
    	    obj.put("info2", vo.getInfo2());
    	    obj.put("info3", vo.getInfo3());
    	    obj.put("content", vo.getContent());
    	    obj.put("foodmake", vo.getFoodmake());
    	    
    	    dbc.insert(obj);
    	}catch(Exception ex){}
    }*/
}





