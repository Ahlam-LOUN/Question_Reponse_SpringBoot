package com.question.reponse.ws.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.reponse.ws.requests.QuestionRequest;
import com.question.reponse.ws.responses.QuestionResponse;
import com.question.reponse.ws.services.QuestionService;
import com.question.reponse.ws.shared.dto.QuestionDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette classe permet de gerer les questions")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Questions")
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@PostMapping( consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE }

	)
	@ApiOperation("Cette methode permet de sauvgarder une question")
	public ResponseEntity<QuestionResponse> storeQuestion(@RequestBody @Valid QuestionRequest questionRequest) {
		ModelMapper modelMapper = new ModelMapper();
		QuestionDto questionDto = modelMapper.map(questionRequest, QuestionDto.class);
		QuestionDto createQuestion = questionService.questionCreate(questionDto);
		QuestionResponse newValue = modelMapper.map(createQuestion, QuestionResponse.class);
		return new ResponseEntity<QuestionResponse>(newValue, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation("Cette methode permet de réqupérer une question")
	public ResponseEntity<QuestionResponse> getOneValue(@PathVariable String id) {
		QuestionDto questionDto = questionService.getQuestion(id);
		ModelMapper modelMapper = new ModelMapper();
		QuestionResponse questionResponse = modelMapper.map(questionDto, QuestionResponse.class);
		// OK for Get ->200
		return new ResponseEntity<QuestionResponse>(questionResponse, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	@ApiOperation("Cette methode permet de supprimer une question")
	public ResponseEntity<Object> deleteQuestion(@PathVariable String id) {
		questionService.questionDelete(id);
		// NO_CONTENT for delete 204
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation("Cette methode permet de modifier une question")
	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<QuestionResponse> updateValue(@PathVariable String id,
			@RequestBody QuestionRequest questionRequest) {
		// Presentation Layer
		ModelMapper modelMapper = new ModelMapper();
		QuestionDto questionDto = modelMapper.map(questionRequest, QuestionDto.class);

		// Server Layer
		QuestionDto questionUpdate = questionService.questionUpdate(id, questionDto);
		ModelMapper modelMappe = new ModelMapper();
		QuestionResponse questionResponse = modelMappe.map(questionUpdate, QuestionResponse.class);
		// Accepted for Put ->202
		return new ResponseEntity<QuestionResponse>(questionResponse, HttpStatus.ACCEPTED);
	}

	@ApiOperation("Cette methode permet de supprimer toutes les questions")
	@DeleteMapping()
	public ResponseEntity<Object> deleteAlQuestions() {
		questionService.deleteAll();
		// NO_CONTENT for delete 204
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation("Cette methode permet de recuperer toutes les questions")
	@GetMapping(path = "/questions", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<QuestionResponse>> getValues() {
		List<QuestionDto> questions = questionService.getAllQuestion();
		// ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<QuestionResponse>>() {
		}.getType();
		List<QuestionResponse> questionsResponse = new ModelMapper().map(questions, listType);
		return new ResponseEntity<List<QuestionResponse>>(questionsResponse, HttpStatus.OK);

	}

}
