package com.hongyuli.search.service;

import com.hongyuli.search.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page, int rows) throws Exception;
}
