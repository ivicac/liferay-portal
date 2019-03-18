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

package com.liferay.batch.engine.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.batch.engine.exception.NoSuchBatchJobException;
import com.liferay.batch.engine.model.BatchJob;
import com.liferay.batch.engine.model.impl.BatchJobImpl;
import com.liferay.batch.engine.model.impl.BatchJobModelImpl;
import com.liferay.batch.engine.service.persistence.BatchJobPersistence;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the batch job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matija Petanjek
 * @generated
 */
@ProviderType
public class BatchJobPersistenceImpl
	extends BasePersistenceImpl<BatchJob> implements BatchJobPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BatchJobUtil</code> to access the batch job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BatchJobImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByKey;
	private FinderPath _finderPathCountByKey;

	/**
	 * Returns the batch job where key = &#63; or throws a <code>NoSuchBatchJobException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching batch job
	 * @throws NoSuchBatchJobException if a matching batch job could not be found
	 */
	@Override
	public BatchJob findByKey(String key) throws NoSuchBatchJobException {
		BatchJob batchJob = fetchByKey(key);

		if (batchJob == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBatchJobException(msg.toString());
		}

		return batchJob;
	}

	/**
	 * Returns the batch job where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching batch job, or <code>null</code> if a matching batch job could not be found
	 */
	@Override
	public BatchJob fetchByKey(String key) {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the batch job where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching batch job, or <code>null</code> if a matching batch job could not be found
	 */
	@Override
	public BatchJob fetchByKey(String key, boolean retrieveFromCache) {
		key = Objects.toString(key, "");

		Object[] finderArgs = new Object[] {key};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByKey, finderArgs, this);
		}

		if (result instanceof BatchJob) {
			BatchJob batchJob = (BatchJob)result;

			if (!Objects.equals(key, batchJob.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BATCHJOB_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				List<BatchJob> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByKey, finderArgs, list);
				}
				else {
					BatchJob batchJob = list.get(0);

					result = batchJob;

					cacheResult(batchJob);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByKey, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BatchJob)result;
		}
	}

	/**
	 * Removes the batch job where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the batch job that was removed
	 */
	@Override
	public BatchJob removeByKey(String key) throws NoSuchBatchJobException {
		BatchJob batchJob = findByKey(key);

		return remove(batchJob);
	}

	/**
	 * Returns the number of batch jobs where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching batch jobs
	 */
	@Override
	public int countByKey(String key) {
		key = Objects.toString(key, "");

		FinderPath finderPath = _finderPathCountByKey;

		Object[] finderArgs = new Object[] {key};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BATCHJOB_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_KEY_KEY_2 = "batchJob.key = ?";

	private static final String _FINDER_COLUMN_KEY_KEY_3 =
		"(batchJob.key IS NULL OR batchJob.key = '')";

	public BatchJobPersistenceImpl() {
		setModelClass(BatchJob.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the batch job in the entity cache if it is enabled.
	 *
	 * @param batchJob the batch job
	 */
	@Override
	public void cacheResult(BatchJob batchJob) {
		entityCache.putResult(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
			batchJob.getPrimaryKey(), batchJob);

		finderCache.putResult(
			_finderPathFetchByKey, new Object[] {batchJob.getKey()}, batchJob);

		batchJob.resetOriginalValues();
	}

	/**
	 * Caches the batch jobs in the entity cache if it is enabled.
	 *
	 * @param batchJobs the batch jobs
	 */
	@Override
	public void cacheResult(List<BatchJob> batchJobs) {
		for (BatchJob batchJob : batchJobs) {
			if (entityCache.getResult(
					BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
					batchJob.getPrimaryKey()) == null) {

				cacheResult(batchJob);
			}
			else {
				batchJob.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all batch jobs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BatchJobImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the batch job.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BatchJob batchJob) {
		entityCache.removeResult(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
			batchJob.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BatchJobModelImpl)batchJob, true);
	}

	@Override
	public void clearCache(List<BatchJob> batchJobs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BatchJob batchJob : batchJobs) {
			entityCache.removeResult(
				BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
				batchJob.getPrimaryKey());

			clearUniqueFindersCache((BatchJobModelImpl)batchJob, true);
		}
	}

	protected void cacheUniqueFindersCache(
		BatchJobModelImpl batchJobModelImpl) {

		Object[] args = new Object[] {batchJobModelImpl.getKey()};

		finderCache.putResult(
			_finderPathCountByKey, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByKey, args, batchJobModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		BatchJobModelImpl batchJobModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {batchJobModelImpl.getKey()};

			finderCache.removeResult(_finderPathCountByKey, args);
			finderCache.removeResult(_finderPathFetchByKey, args);
		}

		if ((batchJobModelImpl.getColumnBitmask() &
			 _finderPathFetchByKey.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {batchJobModelImpl.getOriginalKey()};

			finderCache.removeResult(_finderPathCountByKey, args);
			finderCache.removeResult(_finderPathFetchByKey, args);
		}
	}

	/**
	 * Creates a new batch job with the primary key. Does not add the batch job to the database.
	 *
	 * @param batchJobId the primary key for the new batch job
	 * @return the new batch job
	 */
	@Override
	public BatchJob create(long batchJobId) {
		BatchJob batchJob = new BatchJobImpl();

		batchJob.setNew(true);
		batchJob.setPrimaryKey(batchJobId);

		return batchJob;
	}

	/**
	 * Removes the batch job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job that was removed
	 * @throws NoSuchBatchJobException if a batch job with the primary key could not be found
	 */
	@Override
	public BatchJob remove(long batchJobId) throws NoSuchBatchJobException {
		return remove((Serializable)batchJobId);
	}

	/**
	 * Removes the batch job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the batch job
	 * @return the batch job that was removed
	 * @throws NoSuchBatchJobException if a batch job with the primary key could not be found
	 */
	@Override
	public BatchJob remove(Serializable primaryKey)
		throws NoSuchBatchJobException {

		Session session = null;

		try {
			session = openSession();

			BatchJob batchJob = (BatchJob)session.get(
				BatchJobImpl.class, primaryKey);

			if (batchJob == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBatchJobException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(batchJob);
		}
		catch (NoSuchBatchJobException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BatchJob removeImpl(BatchJob batchJob) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(batchJob)) {
				batchJob = (BatchJob)session.get(
					BatchJobImpl.class, batchJob.getPrimaryKeyObj());
			}

			if (batchJob != null) {
				session.delete(batchJob);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (batchJob != null) {
			clearCache(batchJob);
		}

		return batchJob;
	}

	@Override
	public BatchJob updateImpl(BatchJob batchJob) {
		boolean isNew = batchJob.isNew();

		if (!(batchJob instanceof BatchJobModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(batchJob.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(batchJob);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in batchJob proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BatchJob implementation " +
					batchJob.getClass());
		}

		BatchJobModelImpl batchJobModelImpl = (BatchJobModelImpl)batchJob;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (batchJob.getCreateDate() == null)) {
			if (serviceContext == null) {
				batchJob.setCreateDate(now);
			}
			else {
				batchJob.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!batchJobModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				batchJob.setModifiedDate(now);
			}
			else {
				batchJob.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (batchJob.isNew()) {
				session.save(batchJob);

				batchJob.setNew(false);
			}
			else {
				batchJob = (BatchJob)session.merge(batchJob);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!BatchJobModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
			batchJob.getPrimaryKey(), batchJob, false);

		clearUniqueFindersCache(batchJobModelImpl, false);
		cacheUniqueFindersCache(batchJobModelImpl);

		batchJob.resetOriginalValues();

		return batchJob;
	}

	/**
	 * Returns the batch job with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the batch job
	 * @return the batch job
	 * @throws NoSuchBatchJobException if a batch job with the primary key could not be found
	 */
	@Override
	public BatchJob findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBatchJobException {

		BatchJob batchJob = fetchByPrimaryKey(primaryKey);

		if (batchJob == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBatchJobException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return batchJob;
	}

	/**
	 * Returns the batch job with the primary key or throws a <code>NoSuchBatchJobException</code> if it could not be found.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job
	 * @throws NoSuchBatchJobException if a batch job with the primary key could not be found
	 */
	@Override
	public BatchJob findByPrimaryKey(long batchJobId)
		throws NoSuchBatchJobException {

		return findByPrimaryKey((Serializable)batchJobId);
	}

	/**
	 * Returns the batch job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the batch job
	 * @return the batch job, or <code>null</code> if a batch job with the primary key could not be found
	 */
	@Override
	public BatchJob fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BatchJob batchJob = (BatchJob)serializable;

		if (batchJob == null) {
			Session session = null;

			try {
				session = openSession();

				batchJob = (BatchJob)session.get(
					BatchJobImpl.class, primaryKey);

				if (batchJob != null) {
					cacheResult(batchJob);
				}
				else {
					entityCache.putResult(
						BatchJobModelImpl.ENTITY_CACHE_ENABLED,
						BatchJobImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return batchJob;
	}

	/**
	 * Returns the batch job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param batchJobId the primary key of the batch job
	 * @return the batch job, or <code>null</code> if a batch job with the primary key could not be found
	 */
	@Override
	public BatchJob fetchByPrimaryKey(long batchJobId) {
		return fetchByPrimaryKey((Serializable)batchJobId);
	}

	@Override
	public Map<Serializable, BatchJob> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BatchJob> map = new HashMap<Serializable, BatchJob>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BatchJob batchJob = fetchByPrimaryKey(primaryKey);

			if (batchJob != null) {
				map.put(primaryKey, batchJob);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BatchJob)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_BATCHJOB_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (BatchJob batchJob : (List<BatchJob>)q.list()) {
				map.put(batchJob.getPrimaryKeyObj(), batchJob);

				cacheResult(batchJob);

				uncachedPrimaryKeys.remove(batchJob.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					BatchJobModelImpl.ENTITY_CACHE_ENABLED, BatchJobImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the batch jobs.
	 *
	 * @return the batch jobs
	 */
	@Override
	public List<BatchJob> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BatchJob> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<BatchJob> findAll(
		int start, int end, OrderByComparator<BatchJob> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<BatchJob> findAll(
		int start, int end, OrderByComparator<BatchJob> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<BatchJob> list = null;

		if (retrieveFromCache) {
			list = (List<BatchJob>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BATCHJOB);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BATCHJOB;

				if (pagination) {
					sql = sql.concat(BatchJobModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BatchJob>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BatchJob>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the batch jobs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BatchJob batchJob : findAll()) {
			remove(batchJob);
		}
	}

	/**
	 * Returns the number of batch jobs.
	 *
	 * @return the number of batch jobs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BATCHJOB);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BatchJobModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the batch job persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED,
			BatchJobModelImpl.FINDER_CACHE_ENABLED, BatchJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED,
			BatchJobModelImpl.FINDER_CACHE_ENABLED, BatchJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED,
			BatchJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByKey = new FinderPath(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED,
			BatchJobModelImpl.FINDER_CACHE_ENABLED, BatchJobImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] {String.class.getName()},
			BatchJobModelImpl.KEY_COLUMN_BITMASK);

		_finderPathCountByKey = new FinderPath(
			BatchJobModelImpl.ENTITY_CACHE_ENABLED,
			BatchJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(BatchJobImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BATCHJOB =
		"SELECT batchJob FROM BatchJob batchJob";

	private static final String _SQL_SELECT_BATCHJOB_WHERE_PKS_IN =
		"SELECT batchJob FROM BatchJob batchJob WHERE batchJobId IN (";

	private static final String _SQL_SELECT_BATCHJOB_WHERE =
		"SELECT batchJob FROM BatchJob batchJob WHERE ";

	private static final String _SQL_COUNT_BATCHJOB =
		"SELECT COUNT(batchJob) FROM BatchJob batchJob";

	private static final String _SQL_COUNT_BATCHJOB_WHERE =
		"SELECT COUNT(batchJob) FROM BatchJob batchJob WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "batchJob.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BatchJob exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BatchJob exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BatchJobPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

}