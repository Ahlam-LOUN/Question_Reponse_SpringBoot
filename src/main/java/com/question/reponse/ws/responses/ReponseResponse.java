package com.question.reponse.ws.responses;

import java.util.Date;
import java.util.List;

import com.question.reponse.ws.entities.QuestionEntity;

public class ReponseResponse {

	private String reponseId;
	private String reponseQuestion;
	private String Language;
	private Date dateDeCreation;
	private Date lastModified;
	private Double scoreResponse;
	private List<QuestionEntity> questions;

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
