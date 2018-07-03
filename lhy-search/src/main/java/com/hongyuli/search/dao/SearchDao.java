package com.hongyuli.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.hongyuli.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
