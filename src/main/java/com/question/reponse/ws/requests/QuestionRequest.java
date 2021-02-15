package com.question.reponse.ws.requests;

import java.util.Date;
import java.util.List;


public class QuestionRequest {
	private String textQuestion;
	private String Language;
	private Date dateDeCreation;
	private Date lastModified;

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

}
