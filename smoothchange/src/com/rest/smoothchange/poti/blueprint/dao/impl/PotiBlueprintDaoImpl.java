package com.rest.smoothchange.poti.blueprint.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.poti.blueprint.dao.PotiBlueprintDao;
import com.rest.smoothchange.poti.blueprint.entity.PotiBlueprint;
import com.rest.smoothchange.util.PotiComponentType;

@Repository
@Transactional
public class PotiBlueprintDaoImpl extends AbstractDAO<PotiBlueprint> implements PotiBlueprintDao{

	public List<PotiBlueprint> getPotiBluePrientComponentsByProjectIdAndComponentType(long projectId, PotiComponentType potiComponentType){
		
		Criteria criteria = getSession().createCriteria(PotiBlueprint.class);
		criteria.createAlias("projectBackground", "projectBackGround", JoinType.LEFT_OUTER_JOIN);
		if(projectId!=0) {
			criteria.add(Restrictions.eq("projectBackGround.id", projectId));
		}if(potiComponentType!=null) {
			criteria.add(Restrictions.eq("potiComponent", potiComponentType));
		}	
		return criteria.list();	
	}
	 
}
