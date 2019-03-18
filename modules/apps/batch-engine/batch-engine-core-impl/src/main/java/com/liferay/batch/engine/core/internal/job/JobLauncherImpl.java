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

package com.liferay.batch.engine.core.internal.job;

import com.liferay.batch.engine.core.job.Job;
import com.liferay.batch.engine.core.job.JobExecution;
import com.liferay.batch.engine.core.job.JobFactory;
import com.liferay.batch.engine.core.job.JobLauncher;
import com.liferay.batch.engine.model.BatchJob;
import com.liferay.batch.engine.service.BatchJobLocalService;
import com.liferay.petra.concurrent.NoticeableExecutorService;
import com.liferay.petra.executor.PortalExecutorManager;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ivica Cardic
 */
@Component(immediate = true, service = JobLauncher.class)
public class JobLauncherImpl implements JobLauncher {

	@Override
	public JobExecution run(Job job) {
		Objects.requireNonNull(job);

		BatchJob batchJob = _addBatchJob(job.getKey(), job.getName());

		JobExecution jobExecution = new JobExecution(batchJob);

		JobRunnable jobRunnable = new JobRunnable(job, jobExecution);

		jobRunnable.run();

		return jobExecution;
	}

	@Override
	public JobExecution runAsync(Job job) {
		Objects.requireNonNull(job);

		BatchJob batchJob = _addBatchJob(job.getKey(), job.getName());

		JobExecution jobExecution = new JobExecution(batchJob);

		_submit(job, jobExecution);

		return jobExecution;
	}

	private BatchJob _addBatchJob(String key, String name) {
		return _batchJobLocalService.addBatchJob(key, name);
	}

	private void _submit(Job job, JobExecution jobExecution) {
		NoticeableExecutorService noticeableExecutorService =
			_portalExecutorManager.getPortalExecutor(
				JobLauncherImpl.class.getName());

		noticeableExecutorService.submit(new JobRunnable(job, jobExecution));
	}

	private static final Log _log = LogFactoryUtil.getLog(
		JobLauncherImpl.class);

	@Reference
	private BatchJobLocalService _batchJobLocalService;

	@Reference
	private JobFactory _jobFactory;

	@Reference
	private PortalExecutorManager _portalExecutorManager;

	private class JobRunnable implements Runnable {

		@Override
		public void run() {
			try {
				if (_log.isDebugEnabled()) {
					_log.debug(
						String.format(
							"Job %s launched", _jobExecution.getBatchJob()));
				}

				_job.execute(_jobExecution);
			}
			catch (Exception e) {
				_log.error(
					String.format(
						"Job %s failed to execute",
						_jobExecution.getBatchJob()),
					e);
			}
			finally {
				if (_log.isDebugEnabled()) {
					_log.debug(
						String.format(
							"Job %s completed", _jobExecution.getBatchJob()));
				}

				_jobFactory.dispose(_job);
			}
		}

		private JobRunnable(Job job, JobExecution jobExecution) {
			_job = job;
			_jobExecution = jobExecution;
		}

		private final Job _job;
		private final JobExecution _jobExecution;

	}

}