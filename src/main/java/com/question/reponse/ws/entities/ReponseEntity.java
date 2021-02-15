package com.question.reponse.ws.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity(name="reponses")
public class ReponseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@GeneratedValue
	private long id;
	@Column(nullable=false,length=60)
	private String reponseId;
	private String reponseQuestion;
	private String Language;
	private Date dateDeCreation;
	private Date lastModified;
	private Double scoreResponse;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="reponses")
	private List<QuestionEntity> questions;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReponseId() {
		return reponseId;
	}
	public void setReponseId(String reponseId) {
		this.reponseId = reponseId;
	}
	public String getReponseQuestion() {
		return reponseQuestion;
	}
	public void setReponseQuestion(String reponseQuestion) {
		this.reponseQuestion = reponseQuestion;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public Date getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public Double getScoreResponse() {
		return scoreResponse;
	}
	public void setScoreResponse(Double scoreResponse) {
		this.scoreResponse = scoreResponse;
	}
	public List<QuestionEntity> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}
	
	

}
