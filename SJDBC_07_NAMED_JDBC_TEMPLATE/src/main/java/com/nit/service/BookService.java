package com.nit.service;

import java.util.List;

import com.nit.dto.BookDTO;

public interface BookService {
	
	public List<BookDTO> fetchBookByAuthors(String author1,String author2,String author3);
}
