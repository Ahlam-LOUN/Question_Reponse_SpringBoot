package com.question.reponse.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.reponse.ws.entities.QuestionEntity;
@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {
	QuestionEntity findByQuestionId(String questionId);

}
