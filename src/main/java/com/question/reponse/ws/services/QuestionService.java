package com.question.reponse.ws.services;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.reponse.ws.entities.QuestionEntity;
import com.question.reponse.ws.entities.ReponseEntity;
import com.question.reponse.ws.repositories.QuestionRepository;
import com.question.reponse.ws.repositories.ReponseRepository;
import com.question.reponse.ws.shared.Utils;
import com.question.reponse.ws.shared.dto.QuestionDto;
import com.question.reponse.ws.shared.dto.ReponseDto;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired 
	ReponseRepository  reponseRepository;

	@Autowired
	Utils util;
	private List<QuestionDto>  questions;

	public QuestionDto questionCreate(QuestionDto questionDto) {

		ModelMapper modelMapper = new ModelMapper();
		QuestionEntity questionEntity = new QuestionEntity();
		questionEntity.setTextQuestion(questionDto.getTextQuestion());
		questionEntity.setQuestionId(util.generateStringId(30));
		questionEntity.setId(questionDto.getId());
		questionEntity.setLanguage(questionDto.getLanguage());
		questionEntity.setDateDeCreation(new Date());
		questionEntity.setLastModified(new Date());

	/*for(int i=0; i<questionDto.getReponses().size();i++) {
    ReponseDto reponse=questionDto.getReponses().get(i);
    questions = reponse.getQuestions();
    questions.add(questionDto);
    reponse.setQuestions( questions);
    reponse.setReponseId(util.generateStringId(30));
	questionDto.getReponses().set(i,reponse);
	 }*/
		QuestionEntity questionSave = questionRepository.save(questionEntity);

		QuestionDto question = modelMapper.map(questionSave, QuestionDto.class);
		return question;
	}

	public QuestionDto getQuestion(String questionId) {
		QuestionEntity questionEntity = questionRepository.findByQuestionId(questionId);
		ModelMapper modelMapper = new ModelMapper();
		QuestionDto questionDto = modelMapper.map(questionEntity, QuestionDto.class);
		return questionDto;
	}

	public QuestionDto questionUpdate(String questionId, QuestionDto questionDto) {
		QuestionEntity questionEntity = questionRepository.findByQuestionId(questionId);
		questionEntity = questionRepository.findByQuestionId(questionId);
		// if(valueEntity ==null) throw new UsernameNotFoundException(valueId);
		questionEntity.setTextQuestion(questionDto.getTextQuestion());
		questionEntity.setLanguage(questionDto.getLanguage());
		questionEntity.setLastModified(new Date());
		QuestionEntity questionUpdate = questionRepository.save(questionEntity);
		ModelMapper modelMapper = new ModelMapper();
		QuestionDto questionUpdated = modelMapper.map(questionUpdate, QuestionDto.class);
		return questionUpdated;
	}

	public void questionDelete(String questionId) {
		QuestionEntity questionEntity = questionRepository.findByQuestionId(questionId);
		questionRepository.delete(questionEntity);

	}

	public void deleteAll() {
		questionRepository.deleteAll();
	}
	

	public List<QuestionDto> getAllQuestion() {
		List<QuestionEntity> questions= (List<QuestionEntity>) questionRepository.findAll();
		//ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<QuestionDto>>() {}.getType();
		List<QuestionDto> questionDto=new  ModelMapper().map(questions, listType);
		return questionDto;
		
		
	}
	
	public QuestionDto createQuestionResponse(String questionId, String reponseId) {
		ModelMapper modelMapper = new ModelMapper();
		ReponseEntity reponseEntity = reponseRepository.findByReponseId(reponseId);
		if (reponseEntity == null)
			throw new RuntimeException("The reponse doesn't exist");
		
		QuestionEntity questionEntity = questionRepository.findByQuestionId(questionId);
		if (questionEntity == null)
			throw new RuntimeException("The question doesn't exist");
		
		if(questionEntity.getReponses().contains(reponseEntity))
			throw new RuntimeException("user already added");
		
		questionEntity.getReponses().add(reponseEntity);
		
	         
		QuestionEntity  questionUpdated = questionRepository.save(questionEntity);
		
		QuestionDto reponse = modelMapper.map(questionUpdated, QuestionDto.class);
	
		return reponse;
	}

}
