/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.accenture.banking.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.banking.model.Office;
import com.accenture.banking.resource.builder.EntityToDtoBuilder;
import com.accenture.banking.resource.dto.OfficeDto;
import com.accenture.banking.service.OfficeService;

/**
 * Restful class controller for Offices resources.
 * 
 * @author j.garcia.sanchez
 * 
 */
@RestController
@RequestMapping("/offices")
public class OfficeController {

	@Autowired
	private EntityToDtoBuilder dtoBuilder;

	@Autowired
	private OfficeService officeService;

	/**
	 * This method returns a Office by Id given
	 * 
	 * @return OfficeDto
	 */
	@RequestMapping(value = "/{officeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OfficeDto> getOfficeById(@PathVariable("officeId") Long officeId) {
		Office office = this.officeService.getOfficeById(officeId);
		if (office == null){
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		OfficeDto dto = dtoBuilder.buildOfficeDto(office);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
