package com.rest.smoothchange.readiness.category.items.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.category.items.dao.ReadinessCategoryItemsDao;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;

@Repository
@Transactional
public class ReadinessCategoryItemsDaoImpl extends AbstractDAO<ReadinessCategoryItems> implements ReadinessCategoryItemsDao{

	 
}
