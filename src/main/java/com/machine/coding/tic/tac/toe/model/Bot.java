package com.machine.coding.tic.tac.toe.model;

import com.machine.coding.tic.tac.toe.model.enums.BotDifficultyLevel;
import com.machine.coding.tic.tac.toe.strategies.BotPlayingStrategy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
        public Bot(String name, Symbols symbol) {
        super(name, symbol);
    }
}
