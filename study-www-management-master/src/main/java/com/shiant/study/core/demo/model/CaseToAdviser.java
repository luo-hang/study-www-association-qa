package com.shiant.study.core.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_study_case_to_adviser")
public class CaseToAdviser implements Serializable {

	private static final long serialVersionUID = -8427025966770652794L;

	@Id
	@Column(name="c2aid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long c2aid;

	@Column(name="cid")
	private Long cid;
	
	@Column(name="aid")
	private Long aid;

	public Long getC2aid() {
		return c2aid;
	}

	public void setC2aid(Long c2aid) {
		this.c2aid = c2aid;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}
	
}
