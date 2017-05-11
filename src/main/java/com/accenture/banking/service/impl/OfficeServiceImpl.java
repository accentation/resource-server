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

package com.accenture.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.banking.model.Office;
import com.accenture.banking.respository.OfficeRepository;
import com.accenture.banking.service.OfficeService;

/**
 * Service layer implementation to develop all business methods regarding
 * Offices.
 * 
 * @author j.garcia.sanchez
 *
 */
@Service ("officeService")
@Transactional
class OfficeServiceImpl implements OfficeService {


	@Autowired
	private OfficeRepository officeRepository;


	/**
	 * Return office by Id
	 * 
	 * @param id:
	 *            id of the entity
	 * @return Office
	 */
	@Override
	public Office getOfficeById(Long id) {
		return this.officeRepository.findOne(id);
	}

}
