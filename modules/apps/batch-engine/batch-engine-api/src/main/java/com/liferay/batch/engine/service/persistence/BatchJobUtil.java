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

import com.liferay.batch.engine.model.BatchJob;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the batch job service. This utility wraps <code>com.liferay.batch.engine.service.persistence.impl.BatchJobPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matija Petanjek
 * @see BatchJobPersistence
 * @generated
 */
@ProviderType
public class BatchJobUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BatchJob batchJob) {
		getPersistence().clearCache(batchJob);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BatchJob> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BatchJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BatchJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BatchJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BatchJob> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BatchJob update(BatchJob batchJob) {
		return getPersistence().update(batchJob);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BatchJob update(
		BatchJob batchJob, ServiceContext serviceContext) {

		return getPersistence().update(batchJob, serviceContext);
	}

	/**
	 * Returns the batch job where key = &#63; or throws a <code>NoSuchBatchJobException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching batch job
	 * @throws NoSuchBatchJobException if a matching batch job could not be found
	 */
	public static BatchJob findByKey(String key)
		throws com.liferay.batch.engine.exception.NoSuchBatchJobException {

		return getPersistence().findByKey(key);
	}

	/**
	 * Returns the batch job where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching batch job, or <code>null</code> if a matching batch job could not be found
	 */
	public static BatchJob fetchByKey(String key) {
		return getPersistence().fetchByKey(key);
	}

	/**
	 * Returns the batch job where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching batch job, or <code>null</code> if a matching batch job could not be found
	 */
	public static BatchJob fetchByKey(String key, boolean retrieveFromCache) {
		return getPersistence().fetchByKey(key, retrieveFromCache);
	}

	/**
	 * Removes the batch job where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the batch job that was removed
	 */
	public static BatchJob removeByKey(String key)
		throws com.liferay.batch.engine.exception.NoSuchBatchJobException {

		return getPersistence().removeByKey(key);
	}

	/**
	 * Returns the number of batch jobs where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching batch jobs
	 */
	public static int countByKey(String key) {
		return getPersistence().countByKey(key);
	}

	/**
	 * Caches the batch job in the entity cache if it is enabled.
	 *
	 * @param batchJob the batch job
	 */
	public static void cacheResult(BatchJob batchJob) {
		getPersistence().cacheResult(batchJob);
	}

	/**
	 * Caches the batch jobs in the entity cache if it is enabled.
	 *
	 * @param batchJobs the batch jobs
	 */
	public static void cacheResult(List<BatchJob> batchJobs) {
		getPersistence().cacheResult(batchJobs);
	}

	/**
	 * Creates a new batch job with the primary key. Does not add the batch job to the database.
	 *
	 * @param batchJobId the primary key for the new batch job
	 * @return the new batch job
	 */
	public static BatchJob create(long batchJobId) {
		return getPersistence().create(batchJobId);
	}

	/**
	 * Removes the batch job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job that was removed
	 * @throws NoSuchBatchJobException if a batch job with the primary key could not be found
	 */
	public static BatchJob remove(long batchJobId)
		throws com.liferay.batch.engine.exception.NoSuchBatchJobException {

		return getPersistence().remove(batchJobId);
	}

	public static BatchJob updateImpl(BatchJob batchJob) {
		return getPersistence().updateImpl(batchJob);
	}

	/**
	 * Returns the batch job with the primary key or throws a <code>NoSuchBatchJobException</code> if it could not be found.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job
	 * @throws NoSuchBatchJobException if a batch job with the primary key could not be found
	 */
	public static BatchJob findByPrimaryKey(long batchJobId)
		throws com.liferay.batch.engine.exception.NoSuchBatchJobException {

		return getPersistence().findByPrimaryKey(batchJobId);
	}

	/**
	 * Returns the batch job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job, or <code>null</code> if a batch job with the primary key could not be found
	 */
	public static BatchJob fetchByPrimaryKey(long batchJobId) {
		return getPersistence().fetchByPrimaryKey(batchJobId);
	}

	/**
	 * Returns all the batch jobs.
	 *
	 * @return the batch jobs
	 */
	public static List<BatchJob> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BatchJob> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<BatchJob> findAll(
		int start, int end, OrderByComparator<BatchJob> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BatchJob> findAll(
		int start, int end, OrderByComparator<BatchJob> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the batch jobs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of batch jobs.
	 *
	 * @return the number of batch jobs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BatchJobPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BatchJobPersistence, BatchJobPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BatchJobPersistence.class);

		ServiceTracker<BatchJobPersistence, BatchJobPersistence>
			serviceTracker =
				new ServiceTracker<BatchJobPersistence, BatchJobPersistence>(
					bundle.getBundleContext(), BatchJobPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}