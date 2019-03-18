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

package com.liferay.batch.engine.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the BatchJob service. Represents a row in the &quot;BatchJob&quot; database table, with each column mapped to a property of this class.
 *
 * @author Matija Petanjek
 * @see BatchJobModel
 * @generated
 */
@ImplementationClassName("com.liferay.batch.engine.model.impl.BatchJobImpl")
@ProviderType
public interface BatchJob extends BatchJobModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.batch.engine.model.impl.BatchJobImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BatchJob, Long> BATCH_JOB_ID_ACCESSOR =
		new Accessor<BatchJob, Long>() {

			@Override
			public Long get(BatchJob batchJob) {
				return batchJob.getBatchJobId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BatchJob> getTypeClass() {
				return BatchJob.class;
			}

		};

}