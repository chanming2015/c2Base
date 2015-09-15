package com.qingbo.ginkgo.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingbo.ginkgo.base.entity.CommonRegion;
import com.qingbo.ginkgo.base.repository.CommonRegionRepository;
import com.qingbo.ginkgo.base.service.CommonRegionService;
import com.qingbo.ginkgo.common.result.Result;

@Service("commonRegionService")
public class CommonRegionServiceImpl implements CommonRegionService {

	@Autowired CommonRegionRepository commonRegionRepository;

	@Override
	public Result<List<CommonRegion>> listRegionChildren(Integer code) {
		List<CommonRegion> regions = commonRegionRepository.findByParentCode(code);
		return Result.newSuccess(regions);
	}
	


}
