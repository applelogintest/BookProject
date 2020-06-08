package com.sist.book;

import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BookManager {
	public void bookAllData()
	{
		
		for(int i=1; i<=20; i++){
			try{
				Document doc=Jsoup.connect("https://www.aladin.co.kr/shop/common/wbest.aspx?BestType=MonthlyBest&BranchType=1&CID=0&page="+i+"&cnt=1000&SortOrder=1").get();
				Elements listSize=doc.select(".ss_book_box");
				for(int j=0; j<listSize.size(); j++)
				{
					BookVO vo=new BookVO();
					
					Element titleElement=listSize.select(".bo3").get(j);
					Element posterElement=listSize.select(".i_cover").get(j);
					
					int infoSize=listSize.select(".ss_book_list:eq(0) ul").get(j).childNodeSize();
					System.out.println("infoSize :"+infoSize);
					
					Element infoElement;
					
					if(infoSize==7)
					{
						infoElement=listSize.select(".ss_book_list li:eq(1)").get(j);
					}
					else
					{
						infoElement=listSize.select(".ss_book_list li:eq(2)").get(j);
					}
					
					Element priceElement=listSize.select(".ss_book_list ul span b").get(j);
					
					String title=elementToString(titleElement);
					String poster=elementAttrToString(posterElement, "src");
					String info=elementToString(infoElement);
					StringTokenizer st=new StringTokenizer(info, "|");
					String price=elementToString(priceElement);
					
					vo.setTitle(title);
					vo.setPoster(poster);
					vo.setAuthor(nextTokenException(st));
					vo.setPublisher(nextTokenException(st));
					vo.setRegdate(nextTokenException(st));
					vo.setPrice(price);
					
					System.out.println("title : "+vo.getTitle());
					System.out.println("poster : "+vo.getPoster());
					System.out.println("author : "+vo.getAuthor());
					System.out.println("publisher : "+vo.getPublisher());
					System.out.println("regdate : "+vo.getRegdate());
					System.out.println("price : "+vo.getPrice());
					
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	public String nextTokenException(StringTokenizer st)
	{
		String result="";
		try{
			result=st.nextToken();
		}catch (Exception ex) {
			System.out.println("result : null");
		}
		return result;
				
	}
	public String elementToString(Element e)
	{
		String res="";
		try{
			res=e.text();
		}catch (Exception ex) {
			System.out.println("elementToString Error"+ex.getMessage());
		}
		return res;
	}
	
	public String elementAttrToString(Element e,String strAttr)
	{
		String res="";
		try{
			res=e.attr(strAttr);
		}catch (Exception ex) {
			System.out.println("elementToAttrString Error"+ex.getMessage());
		}
		return res;
	}
	
	
	public static void main(String[] args)
	{
		BookManager bm=new BookManager();
		bm.bookAllData();
	}
}
