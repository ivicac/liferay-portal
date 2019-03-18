/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.batch.engine.service.impl;

import com.liferay.batch.engine.core.job.BatchStatus;
import com.liferay.batch.engine.exception.NoSuchBatchJobException;
import com.liferay.batch.engine.model.BatchJob;
import com.liferay.batch.engine.service.base.BatchJobLocalServiceBaseImpl;

/**
 * The implementation of the batch job local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.batch.engine.service.BatchJobLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Matija Petanjek
 * @see BatchJobLocalServiceBaseImpl
 */
public class BatchJobLocalServiceImpl extends BatchJobLocalServiceBaseImpl {

	@Override
	public BatchJob addBatchJob(String key, String name) {
		BatchJob batchJob = batchJobPersistence.create(
			counterLocalService.increment(BatchJob.class.getName()));

		batchJob.setKey(key);
		batchJob.setName(name);
		batchJob.setStatus(BatchStatus.UNKNOWN.toString());

		return batchJobPersistence.update(batchJob);
	}

	@Override
	public String getStatus(String key) throws NoSuchBatchJobException {
		BatchJob batchJob = batchJobPersistence.findByKey(key);

		return batchJob.getStatus();
	}

}