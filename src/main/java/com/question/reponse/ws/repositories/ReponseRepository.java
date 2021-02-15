package com.question.reponse.ws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.reponse.ws.entities.QuestionEntity;
import com.question.reponse.ws.entities.ReponseEntity;

@Repository
public interface ReponseRepository extends JpaRepository<ReponseEntity,Long>{


	ReponseEntity findByReponseId(String reponseId);

	List<ReponseEntity> findAllByQuestions(QuestionEntity currentQuestion);
	

}
