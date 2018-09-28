package com.rest.smoothchange.change.readiness.categories.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.change.readiness.categories.dao.ChangeReadinessCategoriesDao;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;
import com.rest.smoothchange.change.readiness.categories.mapper.ChangeReadinessCategoriesMapper;
import com.rest.smoothchange.change.readiness.categories.service.ChangeReadinessCategoriesService;


@Service
@Transactional
public class ChangeReadinessCategoriesServiceImpl extends AbstractService<ChangeReadinessCategoriesDao, ChangeReadinessCategoriesDto, ChangeReadinessCategoriesMapper, ChangeReadinessCategories>  implements ChangeReadinessCategoriesService{

	
}
