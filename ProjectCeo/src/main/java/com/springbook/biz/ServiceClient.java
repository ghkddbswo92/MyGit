package com.springbook.biz;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.Arrays;

public class ServiceClient {
	
	StringBuilder sb = new StringBuilder();
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	public int OrderTime(int[] order) {
		RecipeService recipeService = (RecipeService) container.getBean("RecipeService");
		int cnt=0;
		RecipeVO Rvo = new RecipeVO();
			
		List<RecipeVO> recipeList = recipeService.getRecipeList(Rvo);

	    sb = appendSb(order);
		int time=0,Mtime=0,Ftime=0,Htime=0; 
		
		  for(int i=0; i<sb.length(); i++) {
			  
			   for(int j=0; j<recipeList.size(); j++)
				   
				   if(Character.toString(sb.charAt(i)).equals(recipeList.get(j).getNum())) {
					  
					   if(recipeList.get(j).getPriority()==0) {
						   
							cnt++;
						}
						else if(recipeList.get(j).getPriority()<3) {
							
							 Htime=Htime+recipeList.get(j).getTime();
						} 
						else if(recipeList.get(j).getPriority()==3) {
							
							 Ftime=Ftime+recipeList.get(j).getTime();
							 
							 if(Mtime>Htime) {
								 
			            		   time=Mtime+Ftime; 
			            	 }
			            	  else if(Mtime<Htime) {
			            		  
			            		   time=Htime+Ftime;
			            	 }
						}
					   Mtime=(cnt+1)/2*(recipeList.get(0).getTime());
				   }
		   	}

		  return time;
	   }

	public String insertOrderlist(int[] order, int time, String orderid) {
		   DrinkService drinkService = (DrinkService) container.getBean("DrinkService");
		   
		   DrinkVO Dvo = new DrinkVO();
		   OrdertbVO Ovo = new OrdertbVO();
		   
		   List<DrinkVO> drinkList = drinkService.getdrinkList(Dvo);
		   
		   OrdertbService ordertbService = (OrdertbService) container.getBean("OrdertbService");
			
		   String Sorderlist = "";
			
			for(int i=0; i<order.length; i++) {
				if(order[i]!=0) {
					Sorderlist += (drinkList.get(i).getName()+" "+order[i]+"개\n");
				}
		   }
		
		   ordertbService.insertOrdertb(Ovo, Sorderlist, time,orderid);
		   return Sorderlist;
	   }

	public StringBuilder appendSb(int[] order) {
		   DrinkService drinkService = (DrinkService) container.getBean("DrinkService");
		   DrinkVO Dvo = new DrinkVO();
		   
		   List<DrinkVO> drinkList = drinkService.getdrinkList(Dvo);
		   
		   int index=0;
		   int[] temp = Arrays.copyOf(order, order.length);
		   
		   while(true) {
			   
				if(temp[index]!=0) {
					
					temp[index]--;
					sb.append(drinkList.get(index).getRecipe());
					
					continue;
					
				}else {
					
					index++;
					
					if(index==order.length) break;
				}
		   }
		   
		      String[] arr = sb.toString().split("");
		      
		      Arrays.sort(arr);
		      
		      StringBuilder newSb = new StringBuilder();
		      
		      for(int i=0; i<arr.length; i++) {
		    	  
		         newSb.append(arr[i]);
		      }
		      return newSb;
	   }
	 
	public List<String> printActionStep(String orderSt) {
		   RecipeService recipeService = (RecipeService) container.getBean("RecipeService");
		   DrinkService drinkService = (DrinkService) container.getBean("DrinkService");
		   
		   DrinkVO Dvo = new DrinkVO();
		   
		   List<DrinkVO> drinkList = drinkService.getdrinkList(Dvo);
		   
		   RecipeVO Rvo = new RecipeVO();
		   
		   List<RecipeVO> recipeList = recipeService.getRecipeList(Rvo);
		   
		   String temp = "";
		   int cnt=0;
		   int[] order = new int[drinkList.size()];
		   
		   for(int i=0; i<drinkList.size(); i++) {
			   
				String tempSt = drinkList.get(i).getName();
				
				if(orderSt.indexOf(tempSt)==-1) continue;
				
				order[i] = orderSt.charAt(orderSt.indexOf(tempSt)+tempSt.length()+1)-48;
				
				System.out.println(order[i]);
			}
			sb = appendSb(order);
			
			for(int i=0; i<sb.length(); i++) {
				
				for(int j=0; j<recipeList.size(); j++)
					
					   if(Character.toString(sb.charAt(i)).equals(recipeList.get(j).getNum())) {
						   
						   if(recipeList.get(j).getPriority()==0) {
							   
								cnt++;
							}
					   }
			}
			
			Queue<Character> q = new LinkedList<Character>();
			
			if(cnt>2) {
				
				temp = sb.toString();
				temp = temp.replace("A", "");
				temp = temp.replace("C", "");
				
				if(cnt%2==1) {
					
					temp += "AC";
					
				}
				
				sb.delete(0,sb.length());
			}
			sb.append(temp);
			String[] arr = sb.toString().split("");
			
		    Arrays.sort(arr);
		    StringBuilder newSb = new StringBuilder();
		    
		    for(int i=0; i<arr.length; i++) {
		    	
		         newSb.append(arr[i]);
		    }
		    sb = newSb;
			int size = (cnt%2==0)?(cnt/2):((cnt-1)/2);
			
			for(int i=0; i<size; i++) {
				
				q.offer('A');
				q.offer('A');
				q.offer('C');
				q.offer('C');
				
			}
			for(int i=0; i<sb.length(); i++) {
				
				q.offer(sb.charAt(i));
				
			}
			
			List<String> result = new ArrayList<String>();
			
			while(q.isEmpty()==false) {
				
				String st = Character.toString(q.poll());
				
				for(int i=0; i<recipeList.size(); i++) {
					
					if(st.equals(recipeList.get(i).getNum())) {
						
						result.add(recipeList.get(i).getAction());
					}
				
				}
			}
			return result;
	   }
}
