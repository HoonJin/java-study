package com.hoonjin.study.java.was.httpserver;

import lombok.Getter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Getter
@ToString
public class HttpRequest {

    private String method;
    private String path;
    private final Map<String, String> queryParameters = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, String> bodies = new HashMap<>();

    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parseRequestHeaders(reader);
        parseRequestBody(reader);
    }

    private void parseRequestLine(BufferedReader reader) throws IOException {
        String request = reader.readLine();
        if (request == null) {
            throw new IOException("EOF: No request line received");
        }
        String[] parts = request.split(" ");
        if (parts.length != 3) {
            throw new IOException("invalid request line: " + request);
        }

        method = parts[0];
        String[] pathPart = parts[1].split("\\?");
        path = pathPart[0];

        if (pathPart.length > 1) {
            parseQueryParameters(pathPart[1]);
        }

    }

    private void parseQueryParameters(String queryString) {
        for (String query : queryString.split("&")) {
            String[] keyAndValue = query.split("=");
            String key = URLDecoder.decode(keyAndValue[0], UTF_8);
            String value = keyAndValue.length > 1 ? URLDecoder.decode(keyAndValue[1], UTF_8) : "";
            queryParameters.put(key, value);
        }
    }

    private void parseRequestHeaders(BufferedReader reader) throws IOException {
        String line;
        while (!(line = reader.readLine()).isEmpty()) {
            String[] headerParts = line.split(": ");
            headers.put(headerParts[0].trim(), headerParts[1].trim());
        }
    }

    private void parseRequestBodies(String plainBody) {
        for (String query : plainBody.split("&")) {
            String[] keyAndValue = query.split("=");
            String key = URLDecoder.decode(keyAndValue[0], UTF_8);
            String value = keyAndValue.length > 1 ? URLDecoder.decode(keyAndValue[1], UTF_8) : "";
            bodies.put(key, value);
        }
    }

    private void parseRequestBody(BufferedReader reader) throws IOException {
        if (!headers.containsKey("Content-Length")) {
            return;
        }

        int contentLength = Integer.parseInt(headers.get("Content-Length"));
        char[] chars = new char[contentLength];
        int read = reader.read(chars);
        if (read != contentLength) {
            throw new IOException("Fail to read entire body. Expected " + contentLength);
        }

        String body = new String(chars);

        String contentType = headers.get("Content-Type");
        if ("application/x-www-form-urlencoded".equals(contentType)) {
            parseRequestBodies(body);
        }
    }

    public String getParameter(String name) {
        return queryParameters.get(name);
    }

    public String getBody(String name) {
        return bodies.get(name);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }
}
