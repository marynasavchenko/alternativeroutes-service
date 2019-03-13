package com.onlinestore.alternativeroutes.hystrix;

import com.onlinestore.alternativeroutes.utils.UserContext;

import java.util.concurrent.Callable;

public class DelegatingUserContextCallable<T> implements Callable<T> {

	private final Callable<T> delegatedCallable;
	private UserContext originalUserContext;

	public DelegatingUserContextCallable(Callable<T> delegatedCallable, UserContext userContext) {
		this.delegatedCallable = delegatedCallable;
		this.originalUserContext = userContext;
	}

	@Override
	public T call() throws Exception {
		return null;
	}
}
