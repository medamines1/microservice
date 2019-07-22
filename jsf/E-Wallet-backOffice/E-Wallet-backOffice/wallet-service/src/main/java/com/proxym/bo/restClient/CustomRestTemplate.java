package com.proxym.bo.restClient;

import com.elm.commons.utilities.exceptions.RestBackendException;
import com.elm.commons.utilities.response.GenericResponse;
import com.elm.commons.utilities.response.GenericResponseBody;
import com.elm.commons.utilities.response.GenericResponseHeader;
import com.elm.commons.utilities.response.body.BooleanResponse;
import com.elm.commons.utilities.response.body.ListResponse;
import com.elm.commons.utilities.response.body.ObjectResponse;
import com.elm.commons.utilities.response.body.PaginatedListResponse;
import com.elm.commons.utilities.restclient.RestTemplateBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CustomRestTemplate {


    // Create a Rest template
    private RestTemplate restTemplate = RestTemplateBuilder.build();
    private final Logger logger = LoggerFactory.getLogger(CustomRestTemplate.class);

    public BooleanResponse getBooleanResponse(String uri) throws RestBackendException {
        return (BooleanResponse) getGenericResponseBody(uri, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
        });
    }

    public <T> ObjectResponse getObjectResponse(String uri, Class<T> type) throws RestBackendException {
        return (ObjectResponse<T>) getGenericResponseBody(uri, new ParameterizedTypeReference<GenericResponse<ObjectResponse<T>>>() {
        });
    }

    public <T> ListResponse<T> getListResponse(String uri, Class<T> type, HashMap<String, String> filters) throws RestBackendException {
        if (filters != null)
            uri += filtersToUri(filters);
        return (ListResponse<T>) getGenericResponseBody(uri, new ParameterizedTypeReference<GenericResponse<ListResponse<T>>>() {
        });
    }

    public <T> PaginatedListResponse getPaginatedListResponse(String uri, Class T, HashMap<String, String> filters) throws RestBackendException {
        if (filters != null)
            uri += filtersToUri(filters);
        return (PaginatedListResponse<T>) getGenericResponseBody(uri, new ParameterizedTypeReference<GenericResponse<PaginatedListResponse<T>>>() {
        });
    }

    public <T> void delete(String uri) throws RestBackendException {
        HttpEntity<T> httpEntity = new HttpEntity(RestTemplateBuilder.getBoHeaders());
        HttpEntity<GenericResponse> genericResponse = restTemplate.exchange(uri, HttpMethod.DELETE, httpEntity, GenericResponse.class);
        testHeader(genericResponse.getBody().getHeader());
    }

    public <T> void putObject(String uri, T obj) throws RestBackendException {
        HttpEntity<T> httpEntity = new HttpEntity(obj, RestTemplateBuilder.getBoHeaders());
        HttpEntity<GenericResponse> genericResponse = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, GenericResponse.class);
        testHeader(genericResponse.getBody().getHeader());
    }

    public <T> void putParams(String uri) throws RestBackendException {
        HttpEntity<T> httpEntity = new HttpEntity(RestTemplateBuilder.getBoHeaders());
        HttpEntity<GenericResponse> genericResponse = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, GenericResponse.class);
        testHeader(genericResponse.getBody().getHeader());
    }

    public <T> void postObject(String uri, T obj) throws RestBackendException {
        HttpEntity<T> httpEntity = new HttpEntity(obj, RestTemplateBuilder.getBoHeaders());
        HttpEntity<GenericResponse> responseHttpEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, GenericResponse.class);
        if (responseHttpEntity.hasBody()) testHeader(responseHttpEntity.getBody().getHeader());
    }

    public <T, R> ListResponse<R> postObjectGetListResponse(String uri, T obj, Class R) throws RestBackendException {
        return ((ListResponse<R>) postObjectGetGenericResponseBody(uri, obj, new ParameterizedTypeReference<GenericResponse<ListResponse<R>>>() {
        }));
    }

    public <T, R> ObjectResponse<R> postObjectGetObjectResponse(String uri, T obj, Class R) throws RestBackendException {
        return ((ObjectResponse<R>) postObjectGetGenericResponseBody(uri, obj, new ParameterizedTypeReference<GenericResponse<ObjectResponse<R>>>() {
        }));
    }

    public <T, R extends GenericResponseBody> GenericResponseBody postObjectGetGenericResponseBody(String uri, T obj, ParameterizedTypeReference<GenericResponse<R>> typeReference) throws RestBackendException {
        HttpEntity<T> httpEntity = new HttpEntity(obj, RestTemplateBuilder.getBoHeaders());
        HttpEntity<GenericResponse<R>> responseHttpEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, typeReference);
        testHeader(responseHttpEntity.getBody().getHeader());
        return responseHttpEntity.getBody().getBody();
    }

    public <T, R extends GenericResponseBody> GenericResponseBody putObjectGetGenericResponseBody(String uri, T obj, ParameterizedTypeReference<GenericResponse<R>> typeReference) throws RestBackendException {
        HttpEntity<T> httpEntity = new HttpEntity(obj, RestTemplateBuilder.getBoHeaders());
        HttpEntity<GenericResponse<R>> responseHttpEntity = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, typeReference);
        testHeader(responseHttpEntity.getBody().getHeader());
        return responseHttpEntity.getBody().getBody();
    }


    public <T extends GenericResponseBody> GenericResponseBody getGenericResponseBody(String uri, ParameterizedTypeReference<GenericResponse<T>> typeReference) throws RestBackendException {
        HttpEntity<String> httpEntity = new HttpEntity(RestTemplateBuilder.getBoHeaders());
        ResponseEntity<GenericResponse<T>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, typeReference);
        GenericResponse<T> genericResponse = responseEntity.getBody();
        testHeader(genericResponse.getHeader());
        return genericResponse.getBody();
    }

    public <T, R extends GenericResponseBody> GenericResponseBody deleteObjectGetGenericResponseBody(String uri, T obj, ParameterizedTypeReference<GenericResponse<R>> typeReference) throws RestBackendException {
        HttpEntity<T> httpEntity = new HttpEntity(obj, RestTemplateBuilder.getBoHeaders());
        HttpEntity<GenericResponse<R>> responseHttpEntity = restTemplate.exchange(uri, HttpMethod.DELETE, httpEntity, typeReference);
        testHeader(responseHttpEntity.getBody().getHeader());
        return responseHttpEntity.getBody().getBody();
    }


    public Boolean postUserToRocketChat(String uri, MultiValueMap<String, String> body) throws RestBackendException {
        HttpEntity<?> httpEntity = new HttpEntity<Object>(body, RestTemplateBuilder.emptyHeaders());
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
        return (response.getStatusCodeValue() == 200);
    }

    public<F , R extends GenericResponseBody> GenericResponseBody postObjWithListFiles(String uri, F obj , InputStream is , String fileName, ParameterizedTypeReference<GenericResponse<R>> typeReference) throws IOException {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("file", new MultipartInputStreamFileResource(is, fileName));
        map.add("Content", obj);
        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity(map, RestTemplateBuilder.getBoHeaders());
        ResponseEntity<GenericResponse<R>> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, typeReference);
        GenericResponse<R> genericResponse = responseEntity.getBody();
        testHeader(genericResponse.getHeader());
        return genericResponse.getBody();
    }


    public void testHeader(GenericResponseHeader genericResponseHeader) throws RestBackendException {
        if (!genericResponseHeader.getStatusCode().equals("000"))
            throw new RestBackendException(genericResponseHeader);
    }

    public String filtersToUri(HashMap<String, String> filters) {
        String params = "";
        if (filters.size() > 0) {
            boolean first = true;
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (first) {
                    params += "?" + key + "=" + value;
                    first = false;
                } else {
                    params += "&" + key + "=" + value;
                }
            }
        }
        return params;
    }

}