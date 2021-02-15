package com.question.reponse.ws.services;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.reponse.ws.entities.QuestionEntity;
import com.question.reponse.ws.repositories.QuestionRepository;
import com.question.reponse.ws.shared.Utils;
import com.question.reponse.ws.shared.dto.QuestionDto;
import com.question.reponse.ws.shared.dto.ReponseDto;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	Utils util;

	public QuestionDto questionCreate(QuestionDto questionDto) {

		ModelMapper modelMapper = new ModelMapper();
		QuestionEntity questionEntity = new QuestionEntity();
		questionEntity.setTextQuestion(questionDto.getTextQuestion());
		questionEntity.setQuestionId(util.generateStringId(30));
		questionEntity.setId(questionDto.getId());
		questionEntity.setLanguage(questionDto.getLanguage());
		questionEntity.setDateDeCreation(questionDto.getDateDeCreation());
		questionEntity.setLastModified(questionDto.getLastModified());

	/*for(int i=0; i<questionDto.getReponses().size();i++) {
    ReponseDto reponse=questionDto.getReponses().get(i);
   // had set pour attacher l'address a un user
     reponse.getQuestions().add(questionDto);
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

}
