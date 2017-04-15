package com.hl.loan.action;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static Jedis jd=new Jedis("localhost");
	public static void main(String[] args) {
		//list();
		//set();
		//appand();
		//move();
		//keyrename();
		sort();
	}
	public static void list(){
		jd.lpush("list", "abc");
		jd.lpush("list", "efg");
		List list=jd.lrange("list", 0, -1);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	public static void set(){						//set改变   第一次name输出是name    第二次name2 输出是name2
		jd.set("name", "name");
		jd.set("id", "id");
		String name=jd.get("name");
		String id=jd.get("id");
		jd.set("name", "name2");
		String name2=jd.get("name");
		System.out.println(name);
		System.out.println(id);
		System.out.println(name2);
	}
	public static void appand(){
		jd.set("name", "name");
		System.out.println(jd.get("name"));
		jd.append("name", "name2");
		System.out.println(jd.get("name"));
	}
	public static void move(){
		jd.set("name", "name");
		System.out.println(jd.get("name"));
		jd.move("name", 1);
		System.out.println(jd.get("name"));
	}
	public static void keyrename(){					//把key改名
		jd.set("name", "name");
		jd.rename("name", "names");
		System.out.println(jd.get("names"));
	}
	public static void sort(){				//排序，默认是升序
		jd.rpush("sort", "1");
		jd.rpush("sort", "3");
		jd.rpush("sort", "4");
		jd.rpush("sort", "0");
		List list=jd.sort("sort");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}






