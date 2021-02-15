package com.question.reponse.ws.shared.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class QuestionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String QuestionId;
	private String textQuestion;
	private String Language;
	private Date dateDeCreation;
	private Date lastModified;
	private List<ReponseDto> reponses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(String questionId) {
		QuestionId = questionId;
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

	public List<ReponseDto> getReponses() {
		return reponses;
	}

	public void setReponses(List<ReponseDto> reponses) {
		this.reponses = reponses;
	}

}
