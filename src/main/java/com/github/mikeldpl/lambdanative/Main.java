package com.github.mikeldpl.lambdanative;

import java.util.concurrent.atomic.AtomicInteger;

import com.github.mikeldpl.lambda.runtime.LambdaRuntime;
import com.github.mikeldpl.lambda.runtime.LambdaRuntimeApi;
import com.github.mikeldpl.lambda.runtime.aws.AwsLambdaRuntimeApi;


public class Main {
    public static void main(String[] args) {
        final LambdaRuntimeApi awsLambdaRuntimeApi = new AwsLambdaRuntimeApi();
        AtomicInteger i = new AtomicInteger(0);
        new LambdaRuntime(awsLambdaRuntimeApi,
                          invocation -> "{\"counter\": \"" + i.incrementAndGet() + "\"}",
                          (invocation, e) -> "{\"error_message\": \"" + e + "\"}").run();
    }
}
