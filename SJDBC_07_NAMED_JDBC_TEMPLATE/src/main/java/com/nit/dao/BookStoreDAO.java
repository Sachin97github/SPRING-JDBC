package com.nit.dao;

import java.util.List;

import com.nit.bo.BookBO;

public interface BookStoreDAO {

	public List<BookBO> getBookByAuthor(String author1, String author2, String author3);
}
