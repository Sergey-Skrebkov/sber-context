package com.example.sbercontest;

import com.example.sbercontest.model.TextForCheck;
import com.example.sbercontest.service.CheckBracketsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CheckBracketsServiceTests {
    @Test
    public void testSuccessCheckBracketsGoodText(){
        TextForCheck text = new TextForCheck();
        text.setText("(good)");
        HashMap<String, Boolean> hashMap = CheckBracketsService.checkBrackets(text);
        Assertions.assertTrue(hashMap.get("isCorrect"));
    }

    @Test
    public void testSuccessCheckBracketsBadText(){
        TextForCheck text = new TextForCheck();
        text.setText("(good()");
        HashMap<String, Boolean> hashMap = CheckBracketsService.checkBrackets(text);
        Assertions.assertFalse(hashMap.get("isCorrect"));
    }
}
