package com.hongyuli.portal.service;

import com.hongyuli.portal.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
