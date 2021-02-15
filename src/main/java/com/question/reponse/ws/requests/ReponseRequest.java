package com.question.reponse.ws.requests;

import java.util.Date;

public class ReponseRequest {

	private String reponseQuestion;
	private String Language;
	private Date dateDeCreation;
	private Date lastModified;
	private Double scoreResponse;

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

}
