package com.qingbo.ginkgo.base.repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface TongjiRepository {
	int count(String sql);
	int count(String sql, Map<String, Object> params);
	List list(String sql);
	Object[] sums(String sql);
	float sum(String sql);
}
