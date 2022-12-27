package com.group6.tibame104.groupproduct.model;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
@Repository
public class GroupproductHibernate implements GroupproductDAO_interface {
	@PersistenceContext
	private Session session;

	@Override
	public void insert(GroupproductVO groupproductVO) {
		session.persist(groupproductVO);
	}

	@Override
	public void update(GroupproductVO groupproductVO) {
		session.update(groupproductVO);
	}

	@Override
	public void delete(Integer groupbuyProductID) {
		final GroupproductVO groupproductVO = session.get(GroupproductVO.class,groupbuyProductID);
		session.remove(groupproductVO);
	}

	@Override
	public GroupproductVO findByPrimaryKey(Integer groupbuyProductID) {

		
		return session.get(GroupproductVO.class,groupbuyProductID);
	}

	@Override
	public List<GroupproductVO> getAll() {
		
		return null;
	}

	@Override
	public List<GroupproductVO> getAllBySearch(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
