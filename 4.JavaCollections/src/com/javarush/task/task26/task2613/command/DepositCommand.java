package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class DepositCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        try {
            String currencyCode = ConsoleHelper.askCurrencyCode();
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            String[] nominalAndAmount = ConsoleHelper.getValidTwoDigits(currencyManipulator.getCurrencyCode());
            currencyManipulator.addAmount(Integer.parseInt(nominalAndAmount[0]), Integer.parseInt(nominalAndAmount[1]));
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage("Error!");
        }
    }
}
