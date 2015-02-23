package com.ph.sinonet.spring.model.interceptor;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ph.sinonet.spring.model.entity.User;

public class EntityInterceptor extends EmptyInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(EntityInterceptor.class);
	
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		if(entity instanceof User){
			for(int i=0; i<propertyNames.length;i++){
				if("createTime".equals(propertyNames[i])){
					state[i] = new Date();
					log.info("onSave invoked..{}", entity);
					return true;
				}
			}
		}
		
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		
		if(entity instanceof User){	
			for(int i=0; i<propertyNames.length;i++){
				if("updateTime".equals(propertyNames[i])){
					currentState[i] = new Date();
					log.info("onUpdate invoked..{}", entity);
					return true;
				}
			}
		}
		
		return super.onFlushDirty(entity, id, currentState, previousState,
				propertyNames, types);
	}
}
