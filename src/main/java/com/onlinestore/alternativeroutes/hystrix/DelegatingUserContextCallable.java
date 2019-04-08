package com.onlinestore.alternativeroutes.hystrix;

import com.onlinestore.alternativeroutes.utils.UserContext;
import com.onlinestore.alternativeroutes.utils.UserContextHolder;

import java.util.concurrent.Callable;

/**
 * Implementation of the {@code Callable} interface.
 * <p>
 * Propagate thread context of the parent thread to Hystrix command.
 *
 * @param <V> result type of method call
 */
public class DelegatingUserContextCallable<V> implements Callable<V> {

	private final Callable<V> delegatedCallable;
	private UserContext originalUserContext;

	public DelegatingUserContextCallable(Callable<V> delegatedCallable, UserContext userContext) {
		this.delegatedCallable = delegatedCallable;
		this.originalUserContext = userContext;
	}

	public DelegatingUserContextCallable(Callable<V> delegatedCallable) {
		this(delegatedCallable, UserContextHolder.getContext());
	}

	public static <V> Callable<V> create(Callable<V> delegatedCallable, UserContext userContext) {
		return new DelegatingUserContextCallable<V>(delegatedCallable, userContext);
	}

	@Override
	public V call() throws Exception {
		UserContextHolder.setContext(originalUserContext);

		try {
			return delegatedCallable.call();
		} finally {
			this.originalUserContext = null;
		}
	}
}
