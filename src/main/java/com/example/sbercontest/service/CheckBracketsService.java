package com.example.sbercontest.service;

import com.example.sbercontest.model.TextForCheck;
import org.springframework.stereotype.Service;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Stack;

/**
 * Сервис для проверки скобок в тексте
 */
@Service
public class CheckBracketsService {
    /**
     * Статический метод для проверки скобок в тексте
     * @param textForCheck тела запроса с полем text
     * @return HashMap с ключем isCorrect и результатом проверки
     */
    public static HashMap<String, Boolean> checkBrackets(TextForCheck textForCheck) {
        CharacterIterator textIterator = new StringCharacterIterator(textForCheck.getText());
        Stack<Character> bracketsStack = new Stack<>();
        HashMap<String, Boolean> response = new HashMap<>();

        boolean hasTextBetweenBrackets = false;

        while (textIterator.current() != CharacterIterator.DONE) {
            if (textIterator.current() == '(') {
                bracketsStack.push(textIterator.current());
                hasTextBetweenBrackets = false;
            } else if (textIterator.current() == ')') {
                if (bracketsStack.isEmpty() || !hasTextBetweenBrackets) {
                    response.put("isCorrect", false);
                    return response;
                }
                bracketsStack.pop();
            } else if (!bracketsStack.isEmpty() || !hasTextBetweenBrackets) {
                hasTextBetweenBrackets = true;
            }
            textIterator.next();
        }
        response.put("isCorrect", bracketsStack.isEmpty());
        return response;
    }
}
