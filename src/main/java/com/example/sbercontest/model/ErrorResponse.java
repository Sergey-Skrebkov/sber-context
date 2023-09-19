package com.example.sbercontest.model;

/**
 * Модель для ответа на ошибочный запрос
 * @param errorMessage текст сообщения об ошибке
 */
public record ErrorResponse(String errorMessage) {
}
