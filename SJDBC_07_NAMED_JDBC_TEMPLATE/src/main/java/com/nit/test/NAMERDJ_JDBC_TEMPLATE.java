package com.nit.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.dto.BookDTO;
import com.nit.service.BookService;

public class NAMERDJ_JDBC_TEMPLATE {

	public static void main(String[] args) {

		ApplicationContext ctx = null;
		BookService service = null;
		List<BookDTO> listDTO = null;

		ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/application-context.xml");

		service = ctx.getBean("bookService", BookService.class);

		try
		{
			listDTO = service.fetchBookByAuthors("AUHTOR2", "AUHTOR3", "AUHTOR4");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		listDTO.forEach(dto -> 
		{
			System.out.println("NAMERDJ_JDBC_TEMPLATE.main()");
			System.out.println(dto);
		});

	}
}
