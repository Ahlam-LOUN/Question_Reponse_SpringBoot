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


import com.question.reponse.ws.requests.ReponseRequest;
import com.question.reponse.ws.responses.ReponseResponse;
import com.question.reponse.ws.services.ReponseService;
import com.question.reponse.ws.shared.dto.ReponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette classe permet de gerer les reponses")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Reponses")
public class ReponseController {
	@Autowired
	ReponseService reponseService;

	@ApiOperation("Cette methode permet de sauvgarder une reponse")
	@PostMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ReponseResponse> storeReponseInQuestion(@RequestBody @Valid ReponseResponse ReponseResponse,
			@PathVariable String id) {
		ModelMapper modelMapper = new ModelMapper();
		ReponseDto ReponseDto = modelMapper.map(ReponseResponse, ReponseDto.class);
		ReponseDto createReponse = reponseService.reponseCreate(ReponseDto, id);
		ReponseResponse newValue = modelMapper.map(createReponse, ReponseResponse.class);
		return new ResponseEntity<ReponseResponse>(newValue, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation("Cette methode permet de réqupérer une reponse")
	public ResponseEntity<ReponseResponse> getOneValue(@PathVariable String id) {
		// dynamique
		ReponseDto ReponseDto = reponseService.getReponse(id);
		ModelMapper modelMapper = new ModelMapper();
		ReponseResponse ReponseResponse = modelMapper.map(ReponseDto, ReponseResponse.class);
		// OK for Get ->200
		return new ResponseEntity<ReponseResponse>(ReponseResponse, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	@ApiOperation("Cette methode permet de supprimer une reponse")
	public ResponseEntity<Object> deleteReponse(@PathVariable String id) {
		reponseService.reponseDelete(id);
		// NO_CONTENT for delete 204
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation("Cette methode permet de modifier une reponse")
	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ReponseResponse> updateValue(@PathVariable String id,
			@RequestBody ReponseRequest reponseRequest) {
		// Presentation Layer
		ModelMapper modelMapper = new ModelMapper();
		ReponseDto ReponseDto = modelMapper.map(reponseRequest, ReponseDto.class);

		// Server Layer
		ReponseDto reponseUpdate = reponseService.reponseUpdate(id, ReponseDto);
		ModelMapper modelMappe = new ModelMapper();
		ReponseResponse reponseResponse = modelMappe.map(reponseUpdate, ReponseResponse.class);
		// Accepted for Put ->202
		return new ResponseEntity<ReponseResponse>(reponseResponse, HttpStatus.ACCEPTED);
	}

	@ApiOperation("Cette methode permet de supprimer toutes les reponses")
	@DeleteMapping()
	public ResponseEntity<Object> deleteAllReponses() {
		reponseService.deleteAll();
		// NO_CONTENT for delete 204
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation("Cette methode permet de recuperer toutes les reponses")
	@GetMapping(path = "/reponses", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ReponseResponse>> getReponses(@PathVariable String id) {
		List<ReponseDto> reponses = reponseService.getAllresponse(id);
		// ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<ReponseResponse>>() {
		}.getType();
		List<ReponseResponse> reponsesResponse = new ModelMapper().map(reponses, listType);
		return new ResponseEntity<List<ReponseResponse>>(reponsesResponse, HttpStatus.OK);

	}
	@ApiOperation("Cette methode permet de sauvgarder une reponse")
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ReponseResponse> storeReponse(@RequestBody @Valid ReponseResponse ReponseResponse,
			@PathVariable String id) {
		ModelMapper modelMapper = new ModelMapper();
		ReponseDto ReponseDto = modelMapper.map(ReponseResponse, ReponseDto.class);
		ReponseDto createReponse = reponseService.reponseCreate(ReponseDto);
		ReponseResponse newValue = modelMapper.map(createReponse, ReponseResponse.class);
		return new ResponseEntity<ReponseResponse>(newValue, HttpStatus.CREATED);
	}


}
