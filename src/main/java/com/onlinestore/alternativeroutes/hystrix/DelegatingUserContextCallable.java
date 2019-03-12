package com.onlinestore.alternativeroutes.hystrix;

import com.onlinestore.alternativeroutes.utils.UserContext;

import java.util.concurrent.Callable;

public class DelegatingUserContextCallable<T> implements Callable<T> {

	private final Callable<T> delegate;
	private UserContext originalUserContext;

	public DelegatingUserContextCallable(Callable<T> delegate, UserContext userContext) {
		this.delegate = delegate;
		this.originalUserContext = userContext;
	}

	@Override
	public T call() throws Exception {
		return null;
	}
}
