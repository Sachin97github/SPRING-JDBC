package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.bo.BookBO;
import com.nit.dao.BookStoreDAO;
import com.nit.dto.BookDTO;

@Service("bookService")
public class BookSeriviceImpl implements BookService {

	@Autowired
	private BookStoreDAO bookDAO;

	@Override
	public List<BookDTO> fetchBookByAuthors(String author1, String author2, String author3) {

		List<BookBO> listBO = null;
		List<BookDTO> listDTO = new ArrayList();
		
		System.out.println("BookSeriviceImpl.fetchBookByAuthors()");

		try
		{
			listBO = bookDAO.getBookByAuthor(author1, author2, author3);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		listBO.forEach(bo -> {
			BookDTO dto = new BookDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});

		return listDTO;
	}

}
