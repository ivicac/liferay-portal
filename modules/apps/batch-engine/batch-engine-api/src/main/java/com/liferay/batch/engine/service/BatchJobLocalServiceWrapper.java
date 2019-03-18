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

package com.liferay.batch.engine.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BatchJobLocalService}.
 *
 * @author Matija Petanjek
 * @see BatchJobLocalService
 * @generated
 */
@ProviderType
public class BatchJobLocalServiceWrapper
	implements BatchJobLocalService, ServiceWrapper<BatchJobLocalService> {

	public BatchJobLocalServiceWrapper(
		BatchJobLocalService batchJobLocalService) {

		_batchJobLocalService = batchJobLocalService;
	}

	/**
	 * Adds the batch job to the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchJob the batch job
	 * @return the batch job that was added
	 */
	@Override
	public com.liferay.batch.engine.model.BatchJob addBatchJob(
		com.liferay.batch.engine.model.BatchJob batchJob) {

		return _batchJobLocalService.addBatchJob(batchJob);
	}

	@Override
	public com.liferay.batch.engine.model.BatchJob addBatchJob(
		String key, String name) {

		return _batchJobLocalService.addBatchJob(key, name);
	}

	/**
	 * Creates a new batch job with the primary key. Does not add the batch job to the database.
	 *
	 * @param batchJobId the primary key for the new batch job
	 * @return the new batch job
	 */
	@Override
	public com.liferay.batch.engine.model.BatchJob createBatchJob(
		long batchJobId) {

		return _batchJobLocalService.createBatchJob(batchJobId);
	}

	/**
	 * Deletes the batch job from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchJob the batch job
	 * @return the batch job that was removed
	 */
	@Override
	public com.liferay.batch.engine.model.BatchJob deleteBatchJob(
		com.liferay.batch.engine.model.BatchJob batchJob) {

		return _batchJobLocalService.deleteBatchJob(batchJob);
	}

	/**
	 * Deletes the batch job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job that was removed
	 * @throws PortalException if a batch job with the primary key could not be found
	 */
	@Override
	public com.liferay.batch.engine.model.BatchJob deleteBatchJob(
			long batchJobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchJobLocalService.deleteBatchJob(batchJobId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchJobLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _batchJobLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _batchJobLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchJobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _batchJobLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchJobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _batchJobLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _batchJobLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _batchJobLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.batch.engine.model.BatchJob fetchBatchJob(
		long batchJobId) {

		return _batchJobLocalService.fetchBatchJob(batchJobId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _batchJobLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the batch job with the primary key.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job
	 * @throws PortalException if a batch job with the primary key could not be found
	 */
	@Override
	public com.liferay.batch.engine.model.BatchJob getBatchJob(long batchJobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchJobLocalService.getBatchJob(batchJobId);
	}

	/**
	 * Returns a range of all the batch jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchJobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch jobs
	 * @param end the upper bound of the range of batch jobs (not inclusive)
	 * @return the range of batch jobs
	 */
	@Override
	public java.util.List<com.liferay.batch.engine.model.BatchJob> getBatchJobs(
		int start, int end) {

		return _batchJobLocalService.getBatchJobs(start, end);
	}

	/**
	 * Returns the number of batch jobs.
	 *
	 * @return the number of batch jobs
	 */
	@Override
	public int getBatchJobsCount() {
		return _batchJobLocalService.getBatchJobsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _batchJobLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _batchJobLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchJobLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public String getStatus(String key)
		throws com.liferay.batch.engine.exception.NoSuchBatchJobException {

		return _batchJobLocalService.getStatus(key);
	}

	/**
	 * Updates the batch job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param batchJob the batch job
	 * @return the batch job that was updated
	 */
	@Override
	public com.liferay.batch.engine.model.BatchJob updateBatchJob(
		com.liferay.batch.engine.model.BatchJob batchJob) {

		return _batchJobLocalService.updateBatchJob(batchJob);
	}

	@Override
	public BatchJobLocalService getWrappedService() {
		return _batchJobLocalService;
	}

	@Override
	public void setWrappedService(BatchJobLocalService batchJobLocalService) {
		_batchJobLocalService = batchJobLocalService;
	}

	private BatchJobLocalService _batchJobLocalService;

}