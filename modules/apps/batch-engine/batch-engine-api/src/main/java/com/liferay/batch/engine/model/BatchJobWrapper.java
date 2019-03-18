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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link BatchJob}.
 * </p>
 *
 * @author Matija Petanjek
 * @see BatchJob
 * @generated
 */
@ProviderType
public class BatchJobWrapper implements BatchJob, ModelWrapper<BatchJob> {

	public BatchJobWrapper(BatchJob batchJob) {
		_batchJob = batchJob;
	}

	@Override
	public Class<?> getModelClass() {
		return BatchJob.class;
	}

	@Override
	public String getModelClassName() {
		return BatchJob.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("batchJobId", getBatchJobId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("key", getKey());
		attributes.put("name", getName());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("status", getStatus());
		attributes.put("callbackURL", getCallbackURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long batchJobId = (Long)attributes.get("batchJobId");

		if (batchJobId != null) {
			setBatchJobId(batchJobId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String callbackURL = (String)attributes.get("callbackURL");

		if (callbackURL != null) {
			setCallbackURL(callbackURL);
		}
	}

	@Override
	public Object clone() {
		return new BatchJobWrapper((BatchJob)_batchJob.clone());
	}

	@Override
	public int compareTo(BatchJob batchJob) {
		return _batchJob.compareTo(batchJob);
	}

	/**
	 * Returns the batch job ID of this batch job.
	 *
	 * @return the batch job ID of this batch job
	 */
	@Override
	public long getBatchJobId() {
		return _batchJob.getBatchJobId();
	}

	/**
	 * Returns the callback url of this batch job.
	 *
	 * @return the callback url of this batch job
	 */
	@Override
	public String getCallbackURL() {
		return _batchJob.getCallbackURL();
	}

	/**
	 * Returns the create date of this batch job.
	 *
	 * @return the create date of this batch job
	 */
	@Override
	public Date getCreateDate() {
		return _batchJob.getCreateDate();
	}

	/**
	 * Returns the end time of this batch job.
	 *
	 * @return the end time of this batch job
	 */
	@Override
	public Date getEndTime() {
		return _batchJob.getEndTime();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _batchJob.getExpandoBridge();
	}

	/**
	 * Returns the key of this batch job.
	 *
	 * @return the key of this batch job
	 */
	@Override
	public String getKey() {
		return _batchJob.getKey();
	}

	/**
	 * Returns the modified date of this batch job.
	 *
	 * @return the modified date of this batch job
	 */
	@Override
	public Date getModifiedDate() {
		return _batchJob.getModifiedDate();
	}

	/**
	 * Returns the name of this batch job.
	 *
	 * @return the name of this batch job
	 */
	@Override
	public String getName() {
		return _batchJob.getName();
	}

	/**
	 * Returns the primary key of this batch job.
	 *
	 * @return the primary key of this batch job
	 */
	@Override
	public long getPrimaryKey() {
		return _batchJob.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _batchJob.getPrimaryKeyObj();
	}

	/**
	 * Returns the start time of this batch job.
	 *
	 * @return the start time of this batch job
	 */
	@Override
	public Date getStartTime() {
		return _batchJob.getStartTime();
	}

	/**
	 * Returns the status of this batch job.
	 *
	 * @return the status of this batch job
	 */
	@Override
	public String getStatus() {
		return _batchJob.getStatus();
	}

	@Override
	public int hashCode() {
		return _batchJob.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _batchJob.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _batchJob.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _batchJob.isNew();
	}

	@Override
	public void persist() {
		_batchJob.persist();
	}

	/**
	 * Sets the batch job ID of this batch job.
	 *
	 * @param batchJobId the batch job ID of this batch job
	 */
	@Override
	public void setBatchJobId(long batchJobId) {
		_batchJob.setBatchJobId(batchJobId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_batchJob.setCachedModel(cachedModel);
	}

	/**
	 * Sets the callback url of this batch job.
	 *
	 * @param callbackURL the callback url of this batch job
	 */
	@Override
	public void setCallbackURL(String callbackURL) {
		_batchJob.setCallbackURL(callbackURL);
	}

	/**
	 * Sets the create date of this batch job.
	 *
	 * @param createDate the create date of this batch job
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_batchJob.setCreateDate(createDate);
	}

	/**
	 * Sets the end time of this batch job.
	 *
	 * @param endTime the end time of this batch job
	 */
	@Override
	public void setEndTime(Date endTime) {
		_batchJob.setEndTime(endTime);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_batchJob.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_batchJob.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_batchJob.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the key of this batch job.
	 *
	 * @param key the key of this batch job
	 */
	@Override
	public void setKey(String key) {
		_batchJob.setKey(key);
	}

	/**
	 * Sets the modified date of this batch job.
	 *
	 * @param modifiedDate the modified date of this batch job
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_batchJob.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this batch job.
	 *
	 * @param name the name of this batch job
	 */
	@Override
	public void setName(String name) {
		_batchJob.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_batchJob.setNew(n);
	}

	/**
	 * Sets the primary key of this batch job.
	 *
	 * @param primaryKey the primary key of this batch job
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_batchJob.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_batchJob.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the start time of this batch job.
	 *
	 * @param startTime the start time of this batch job
	 */
	@Override
	public void setStartTime(Date startTime) {
		_batchJob.setStartTime(startTime);
	}

	/**
	 * Sets the status of this batch job.
	 *
	 * @param status the status of this batch job
	 */
	@Override
	public void setStatus(String status) {
		_batchJob.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<BatchJob> toCacheModel() {
		return _batchJob.toCacheModel();
	}

	@Override
	public BatchJob toEscapedModel() {
		return new BatchJobWrapper(_batchJob.toEscapedModel());
	}

	@Override
	public String toString() {
		return _batchJob.toString();
	}

	@Override
	public BatchJob toUnescapedModel() {
		return new BatchJobWrapper(_batchJob.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _batchJob.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BatchJobWrapper)) {
			return false;
		}

		BatchJobWrapper batchJobWrapper = (BatchJobWrapper)obj;

		if (Objects.equals(_batchJob, batchJobWrapper._batchJob)) {
			return true;
		}

		return false;
	}

	@Override
	public BatchJob getWrappedModel() {
		return _batchJob;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _batchJob.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _batchJob.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_batchJob.resetOriginalValues();
	}

	private final BatchJob _batchJob;

}