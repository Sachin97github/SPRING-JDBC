package com.nit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nit.bo.BookBO;

//@Repository("bookDAO")
public class BookStoreDAOImpl implements BookStoreDAO {

	private static final String GET_BOOK_BY_AUTHORS = "SELECT BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLISHER,STATUS,CATEGORY FROM BOOK_STORE WHERE AUTHOR IN(:auth1,:auth2,:auth3) ORDER BY AUTHOR";
	@Autowired
	private NamedParameterJdbcTemplate njt;

	public List<BookBO> getBookByAuthor(String author1, String author2, String author3) {

		List<BookBO> listBO1 = null;

		Map<String, Object> paramMap = null;
		paramMap = new HashMap();
		paramMap.put("auth1", author1);
		paramMap.put("auth2", author2);
		paramMap.put("auth3", author3);

		listBO1 = njt.query(GET_BOOK_BY_AUTHORS, paramMap, rs -> {
			List<BookBO> listBO = null;
			while (rs.next()) {
				BookBO bo = new BookBO();

				bo.setBookId(rs.getInt(1));
				bo.setBookName(rs.getString(2));
				bo.setAuthor(rs.getString(3));
				bo.setPrice(rs.getFloat(4));
				bo.setPublisher(rs.getString(5));
				bo.setStatus(rs.getString((6)));
				bo.setCategory(rs.getString(7));
				listBO.add(bo);
			} // while
			return listBO;
		}// lambda
		);// jt.query

		return listBO1;
	}// getBOOKbyauthor

}// class
