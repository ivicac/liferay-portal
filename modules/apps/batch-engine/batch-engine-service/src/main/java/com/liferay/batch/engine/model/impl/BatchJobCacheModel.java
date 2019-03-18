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

package com.liferay.batch.engine.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.batch.engine.model.BatchJob;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BatchJob in entity cache.
 *
 * @author Matija Petanjek
 * @generated
 */
@ProviderType
public class BatchJobCacheModel
	implements CacheModel<BatchJob>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BatchJobCacheModel)) {
			return false;
		}

		BatchJobCacheModel batchJobCacheModel = (BatchJobCacheModel)obj;

		if (batchJobId == batchJobCacheModel.batchJobId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, batchJobId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{batchJobId=");
		sb.append(batchJobId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", key=");
		sb.append(key);
		sb.append(", name=");
		sb.append(name);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", status=");
		sb.append(status);
		sb.append(", callbackURL=");
		sb.append(callbackURL);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BatchJob toEntityModel() {
		BatchJobImpl batchJobImpl = new BatchJobImpl();

		batchJobImpl.setBatchJobId(batchJobId);

		if (createDate == Long.MIN_VALUE) {
			batchJobImpl.setCreateDate(null);
		}
		else {
			batchJobImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			batchJobImpl.setModifiedDate(null);
		}
		else {
			batchJobImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (key == null) {
			batchJobImpl.setKey("");
		}
		else {
			batchJobImpl.setKey(key);
		}

		if (name == null) {
			batchJobImpl.setName("");
		}
		else {
			batchJobImpl.setName(name);
		}

		if (startTime == Long.MIN_VALUE) {
			batchJobImpl.setStartTime(null);
		}
		else {
			batchJobImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			batchJobImpl.setEndTime(null);
		}
		else {
			batchJobImpl.setEndTime(new Date(endTime));
		}

		if (status == null) {
			batchJobImpl.setStatus("");
		}
		else {
			batchJobImpl.setStatus(status);
		}

		if (callbackURL == null) {
			batchJobImpl.setCallbackURL("");
		}
		else {
			batchJobImpl.setCallbackURL(callbackURL);
		}

		batchJobImpl.resetOriginalValues();

		return batchJobImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		batchJobId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		key = objectInput.readUTF();
		name = objectInput.readUTF();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		status = objectInput.readUTF();
		callbackURL = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(batchJobId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (callbackURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(callbackURL);
		}
	}

	public long batchJobId;
	public long createDate;
	public long modifiedDate;
	public String key;
	public String name;
	public long startTime;
	public long endTime;
	public String status;
	public String callbackURL;

}