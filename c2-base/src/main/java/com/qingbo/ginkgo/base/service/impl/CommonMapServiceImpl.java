package com.qingbo.ginkgo.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingbo.ginkgo.base.entity.CommonMap;
import com.qingbo.ginkgo.base.entity.CommonMapEntry;
import com.qingbo.ginkgo.base.repository.CommonMapRepository;
import com.qingbo.ginkgo.base.service.CommonMapService;

@Service("commonMapService")
public class CommonMapServiceImpl implements CommonMapService {

	@Autowired CommonMapRepository commonMapRepository;
	
	/** @author XuMaoSen 
	 */
	@Override
	public Map<String, Map<String, String>> buildTotalMap() {
		Map<String, Map<String, String>> totalMap = null;

		totalMap = new HashMap<String, Map<String, String>>();
		List<CommonMap> mapsResult = commonMapRepository.findAll();
		
		for(CommonMap commonMap : mapsResult){
			Map<String, String> map = new HashMap<String, String>();
			for(CommonMapEntry entry : commonMap.getEntries()){
				map.put(entry.getKey(), entry.getValue());
			}
			totalMap.put(commonMap.getName(), map);
		}
		return totalMap;
	}


}
