package com.question.reponse.ws.services;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.question.reponse.ws.entities.QuestionEntity;
import com.question.reponse.ws.entities.ReponseEntity;
import com.question.reponse.ws.repositories.QuestionRepository;
import com.question.reponse.ws.repositories.ReponseRepository;
import com.question.reponse.ws.shared.Utils;
import com.question.reponse.ws.shared.dto.ReponseDto;



@Service
public class ReponseService  {

	@Autowired 
	ReponseRepository  reponseRepository;

	@Autowired
	Utils util;
	
	@Autowired
	QuestionRepository questionRepository;

	public ReponseDto reponseCreate(ReponseDto reponseDto, String id) {

		ModelMapper modelMapper = new ModelMapper();
		ReponseEntity ReponseEntity = new ReponseEntity();
		ReponseEntity.setReponseQuestion(reponseDto.getReponseQuestion());
		ReponseEntity.setReponseId(util.generateStringId(30));
		ReponseEntity.setLanguage(reponseDto.getLanguage());
		ReponseEntity.setDateDeCreation(reponseDto.getDateDeCreation());
		ReponseEntity.setLastModified(reponseDto.getLastModified());
		ReponseEntity.setScoreResponse(reponseDto.getScoreResponse());
		
		ReponseEntity reponseSave = reponseRepository.save(ReponseEntity);

		ReponseDto reponse = modelMapper.map(reponseSave, ReponseDto.class);
		return reponse;
	}

	public ReponseDto getReponse(String reponseId) {
		ReponseEntity ReponseEntity = reponseRepository.findByReponseId(reponseId);
		ModelMapper modelMapper = new ModelMapper();
		ReponseDto reponseDto = modelMapper.map(ReponseEntity, ReponseDto.class);
		return reponseDto;
	}

	public ReponseDto reponseUpdate(String reponseId, ReponseDto reponseDto) {
		ReponseEntity ReponseEntity = reponseRepository.findByReponseId(reponseId);
//		// if(valueEntity ==null) throw new UsernameNotFoundException(valueId);
		ReponseEntity.setReponseQuestion(reponseDto.getReponseQuestion());
		ReponseEntity.setLanguage(reponseDto.getLanguage());
		ReponseEntity.setLastModified(new Date());
		ReponseEntity questionUpdate = reponseRepository.save(ReponseEntity);
		ModelMapper modelMapper = new ModelMapper();
		ReponseDto reponseUpdated = modelMapper.map(questionUpdate, ReponseDto.class);
		return reponseUpdated;
	}

	public void reponseDelete(String reponseId) {
		ReponseEntity ReponseEntity = reponseRepository.findByReponseId(reponseId);
		reponseRepository.delete(ReponseEntity);

	}

	public void deleteAll() {
		reponseRepository.deleteAll();
	}
	

	public List<ReponseDto> getAllresponse(String questionId) {
		QuestionEntity currentQuestion=questionRepository.findByQuestionId(questionId);
		List<ReponseEntity> reponses= (List<ReponseEntity>) reponseRepository.findAllByQuestions(currentQuestion);
		//ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<ReponseDto>>() {}.getType();
		List<ReponseDto> reponseDto=new  ModelMapper().map(reponses, listType);
		return reponseDto;
		
	}



}
