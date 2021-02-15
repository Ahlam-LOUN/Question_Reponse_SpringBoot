package com.question.reponse.ws.responses;

import java.util.Date;
import java.util.List;

import com.question.reponse.ws.entities.ReponseEntity;

public class QuestionResponse {

	private String questionId;
	private String textQuestion;
	private String Language;
	private Date dateDeCreation;
	private Date lastModified;
	private List<ReponseEntity> reponses;
	

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
