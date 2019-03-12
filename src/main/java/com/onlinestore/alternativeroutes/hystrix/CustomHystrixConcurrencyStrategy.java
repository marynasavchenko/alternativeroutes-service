package com.onlinestore.alternativeroutes.hystrix;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.properties.HystrixProperty;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

	private HystrixConcurrencyStrategy existingConcurrencyStrategy;

	public CustomHystrixConcurrencyStrategy(HystrixConcurrencyStrategy existingConcurrencyStrategy) {
		this.existingConcurrencyStrategy = existingConcurrencyStrategy;
	}

	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
	                                        HystrixProperty<Integer> corePoolSize,
	                                        HystrixProperty<Integer> maxPoolSize,
	                                        HystrixProperty<Integer> keepAliveTime,
	                                        TimeUnit unit,
	                                        BlockingQueue<Runnable> workQueue) {
		if (existingConcurrencyStrategy != null)
			return existingConcurrencyStrategy.getThreadPool(threadPoolKey, corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);
		return super.getThreadPool(threadPoolKey, corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
		if (existingConcurrencyStrategy != null) return existingConcurrencyStrategy.getBlockingQueue(maxQueueSize);
		return super.getBlockingQueue(maxQueueSize);
	}

	@Override
	public <T> Callable<T> wrapCallable(Callable<T> callable) {
		return super.wrapCallable(callable);
	}

	@Override
	public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> requestVariableLifecycle) {
		if (existingConcurrencyStrategy != null)
			return existingConcurrencyStrategy.getRequestVariable(requestVariableLifecycle);
		return super.getRequestVariable(requestVariableLifecycle);
	}
}