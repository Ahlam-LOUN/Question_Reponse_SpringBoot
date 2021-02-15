package com.question.reponse.ws.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;




@Entity(name="questions")
public class QuestionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@javax.persistence.Id
	@GeneratedValue
	private long id;
	@Column(nullable=false,length=60)
	private String questionId;
	@Column(nullable=false,length=60)
	private String textQuestion;
	private String Language;
	private Date dateDeCreation;
	private Date lastModified;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name = "Questions_reponses", joinColumns = { @JoinColumn(name = "questionId") }, inverseJoinColumns = {
			@JoinColumn(name = "reponseId") })
	private List<ReponseEntity> reponses;
	
	
	
	
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getTextQuestion() {
		return textQuestion;
	}
	public void setTextQuestion(String textQuestion) {
		this.textQuestion = textQuestion;
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
	public List<ReponseEntity> getReponses() {
		return reponses;
	}
	public void setReponses(List<ReponseEntity> reponses) {
		this.reponses = reponses;
	}
	
	
}
