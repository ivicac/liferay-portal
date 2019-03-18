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

package com.liferay.batch.engine.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.batch.engine.exception.NoSuchBatchJobException;
import com.liferay.batch.engine.model.BatchJob;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the batch job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matija Petanjek
 * @see BatchJobUtil
 * @generated
 */
@ProviderType
public interface BatchJobPersistence extends BasePersistence<BatchJob> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BatchJobUtil} to access the batch job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, BatchJob> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the batch job where key = &#63; or throws a <code>NoSuchBatchJobException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching batch job
	 * @throws NoSuchBatchJobException if a matching batch job could not be found
	 */
	public BatchJob findByKey(String key) throws NoSuchBatchJobException;

	/**
	 * Returns the batch job where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching batch job, or <code>null</code> if a matching batch job could not be found
	 */
	public BatchJob fetchByKey(String key);

	/**
	 * Returns the batch job where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching batch job, or <code>null</code> if a matching batch job could not be found
	 */
	public BatchJob fetchByKey(String key, boolean retrieveFromCache);

	/**
	 * Removes the batch job where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the batch job that was removed
	 */
	public BatchJob removeByKey(String key) throws NoSuchBatchJobException;

	/**
	 * Returns the number of batch jobs where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching batch jobs
	 */
	public int countByKey(String key);

	/**
	 * Caches the batch job in the entity cache if it is enabled.
	 *
	 * @param batchJob the batch job
	 */
	public void cacheResult(BatchJob batchJob);

	/**
	 * Caches the batch jobs in the entity cache if it is enabled.
	 *
	 * @param batchJobs the batch jobs
	 */
	public void cacheResult(java.util.List<BatchJob> batchJobs);

	/**
	 * Creates a new batch job with the primary key. Does not add the batch job to the database.
	 *
	 * @param batchJobId the primary key for the new batch job
	 * @return the new batch job
	 */
	public BatchJob create(long batchJobId);

	/**
	 * Removes the batch job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job that was removed
	 * @throws NoSuchBatchJobException if a batch job with the primary key could not be found
	 */
	public BatchJob remove(long batchJobId) throws NoSuchBatchJobException;

	public BatchJob updateImpl(BatchJob batchJob);

	/**
	 * Returns the batch job with the primary key or throws a <code>NoSuchBatchJobException</code> if it could not be found.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job
	 * @throws NoSuchBatchJobException if a batch job with the primary key could not be found
	 */
	public BatchJob findByPrimaryKey(long batchJobId)
		throws NoSuchBatchJobException;

	/**
	 * Returns the batch job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job, or <code>null</code> if a batch job with the primary key could not be found
	 */
	public BatchJob fetchByPrimaryKey(long batchJobId);

	/**
	 * Returns all the batch jobs.
	 *
	 * @return the batch jobs
	 */
	public java.util.List<BatchJob> findAll();

	/**
	 * Returns a range of all the batch jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BatchJobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch jobs
	 * @param end the upper bound of the range of batch jobs (not inclusive)
	 * @return the range of batch jobs
	 */
	public java.util.List<BatchJob> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the batch jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BatchJobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch jobs
	 * @param end the upper bound of the range of batch jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of batch jobs
	 */
	public java.util.List<BatchJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BatchJob>
			orderByComparator);

	/**
	 * Returns an ordered range of all the batch jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BatchJobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch jobs
	 * @param end the upper bound of the range of batch jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of batch jobs
	 */
	public java.util.List<BatchJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BatchJob>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the batch jobs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of batch jobs.
	 *
	 * @return the number of batch jobs
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}