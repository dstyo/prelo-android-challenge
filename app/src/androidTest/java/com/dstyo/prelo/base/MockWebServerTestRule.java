package com.dstyo.prelo.base;

import org.hamcrest.Matcher;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.08.12
 */
public class MockWebServerTestRule implements TestRule {

    public static final String DOMAIN = "localhost";
    public static final int PORT = 1234;
    public static final SocketPolicy DEFAULT_SOCKET_POLICY;
    public static final int DEFAULT_STATUS_CODE = 200;
    private MockDispatcher mockDispatcher = new MockDispatcher();
    private MockWebServer mockWebServer = new MockWebServer();

    public MockWebServerTestRule() {
        this.mockWebServer.setDispatcher(this.mockDispatcher);
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new MockWebServerTestRule.MockHTTPServerStatement(base);
    }

    public void mock(Matcher<RecordedRequest> requestMatcher, int httpResponseCode, String response, Headers headers) throws IOException {
        this.mock(requestMatcher, httpResponseCode, response, headers, DEFAULT_SOCKET_POLICY);
    }

    public void mock(Matcher<RecordedRequest> requestMatcher, int httpResponseCode, String response, Headers headers, SocketPolicy socketPolicy) throws IOException {
        MockResponse mockResponse = (new MockResponse()).setResponseCode(httpResponseCode).setBody(response).setSocketPolicy(socketPolicy);
        if (headers != null) {
            mockResponse.setHeaders(headers);
        }

        this.mockDispatcher.mock(requestMatcher, mockResponse);
    }

    static {
        DEFAULT_SOCKET_POLICY = SocketPolicy.KEEP_OPEN;
    }

    private class MockHTTPServerStatement extends Statement {

        private Statement baseStatement;

        public MockHTTPServerStatement(Statement baseStatement) {
            this.baseStatement = baseStatement;
        }

        @Override
        public void evaluate() throws Throwable {
            MockWebServerTestRule.this.mockWebServer.start(PORT);

            try {
                this.baseStatement.evaluate();
            } finally {
                MockWebServerTestRule.this.mockWebServer.shutdown();
            }
        }
    }
}
