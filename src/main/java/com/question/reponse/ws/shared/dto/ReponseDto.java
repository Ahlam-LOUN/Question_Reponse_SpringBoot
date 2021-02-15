package com.question.reponse.ws.shared.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String ReponseId;
	private String reponseQuestion;
	private String Language;
	private Date dateDeCreation;
	private Date lastModified;
	private Double scoreResponse;

	private List<QuestionDto> questions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReponseId() {
		return ReponseId;
	}

	public void setReponseId(String reponseId) {
		ReponseId = reponseId;
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

	public List<QuestionDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDto> questions) {
		this.questions = questions;
	}

}
