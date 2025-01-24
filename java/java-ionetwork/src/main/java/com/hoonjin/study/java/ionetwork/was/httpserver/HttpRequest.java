package com.hoonjin.study.java.ionetwork.was.httpserver;

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

    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parseRequestHeaders(reader);
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

    public String getParameter(String name) {
        return queryParameters.get(name);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }
}
