package com.oradt.dbtest;

import com.mongodb.DB;  
import com.mongodb.DBCollection;  
import com.mongodb.DBCursor;  
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;  

public class Mongodb {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mongo mg=new Mongo("191.cc");
		Long starttime = System.currentTimeMillis();
		for( String name : mg.getDatabaseNames())
			System.out.println(name);
		
		DB db = mg.getDB("db1");
		for(String name : db.getCollectionNames())
			System.out.println(name);
		
		
		DBCollection users = db.getCollection("users");
		DBCursor cursor = users.find().limit(10);
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			System.out.println(dbObject.get("_id") + " : " + dbObject.get("username"));
		}
		
		mg.close();
		System.out.println(starttime);
		System.out.println(System.currentTimeMillis());
	}

}
