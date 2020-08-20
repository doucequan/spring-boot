package com.zhumj.component;

import com.zhumj.interfaces.CardService;

public class CardServiceImpl implements CardService {

    public void printCardName(String cardName) {
        System.out.println("cardName：" + cardName);
    }
}
