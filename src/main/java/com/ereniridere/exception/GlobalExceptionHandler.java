package com.ereniridere.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private List<String> addMapValue(List<String> list, String newValue) {
		list.add(newValue);
		return list;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		Map<String, List<String>> errorsMap = new HashMap<>();

		// burada errorların hepsini yakaladık
		for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
			String fieldString = ((FieldError) objectError).getField();// field alanını aldık burada

			if (errorsMap.containsKey(fieldString)) {
				// burada errorsMap.get(fieldString) ile o field a ait listeyi döndürürür.
				errorsMap.put(fieldString, addMapValue(errorsMap.get(fieldString), objectError.getDefaultMessage()));
			} else {

				errorsMap.put(fieldString, addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
			}
		}

		return ResponseEntity.badRequest().body(createApiError(errorsMap));

	}

	// GENERİC YAPARAK daha esnek bir hata yönetimi oluşturduk.
	private <T> ApiError<T> createApiError(T errorsMap) {
		ApiError apiError = new ApiError();

		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(errorsMap);

		return apiError;
	}
}
