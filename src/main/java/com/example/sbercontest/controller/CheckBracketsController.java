package com.example.sbercontest.controller;

import com.example.sbercontest.model.ErrorResponse;
import com.example.sbercontest.model.TextForCheck;
import com.example.sbercontest.service.CheckBracketsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Контреллер для получения запросов для проверки скобок
 */
@RestController
public class CheckBracketsController {
    /**
     * Post запрос принимающий в качестве параметров модель данных TextForCheck
     * @param textForCheck тело запроса
     * @return
     */
    @PostMapping("/checkBrackets")
    public ResponseEntity<?> checkBrackets(@RequestBody TextForCheck textForCheck) {
        if(textForCheck.getText().isEmpty()){
            return new ResponseEntity<>(new ErrorResponse("Пустой текст"),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(CheckBracketsService.checkBrackets(textForCheck), HttpStatus.OK);

    }
}
