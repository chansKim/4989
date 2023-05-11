package com.ju.chan.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ju.chan.dto.FollowDto;
import com.ju.chan.dto.MemberDto;
import com.ju.chan.dto.ResourceDto;

@Repository
public class MemberDaoImpl implements IMemberDao {

	private String ns = "member.";

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private DataSourceTransactionManager tManager;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public boolean memberAdd(MemberDto memberDto, FollowDto followDto) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = tManager.getTransaction(def);
		Object obj = null;
		try{
			getSqlSession().insert(ns + "addFollow_init", followDto);
			obj = getSqlSession().insert(ns + "addMember", memberDto);
		} catch(Exception e) {
			tManager.rollback(status);
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		tManager.commit(status);
		
		return obj == null ? false : true;
	}

	public MemberDto login(MemberDto dto) {
		MemberDto login = getSqlSession().selectOne(ns + "login", dto);
		return login;
	}

	public void uploadMainPic(ResourceDto resDto) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = tManager.getTransaction(def);
		try{
			getSqlSession().insert(ns + "uploadMainPic", resDto);
			getSqlSession().update(ns + "uploadMainPic_Member", resDto.getM_mail());
		} catch(Exception e) {
			tManager.rollback(status);
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		tManager.commit(status);

	}

	@Override
	public void withdrawal(MemberDto memberDto) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = tManager.getTransaction(def);
		try{
			getSqlSession().delete(ns + "withdrawal", memberDto);
			getSqlSession().delete(ns + "withdrawal_follow", memberDto);
		} catch(Exception e) {
			tManager.rollback(status);
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		tManager.commit(status);

	}
}
