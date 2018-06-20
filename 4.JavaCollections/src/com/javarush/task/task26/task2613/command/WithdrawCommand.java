package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException
    {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        boolean isValid = true;
        while (isValid)
        {
            ConsoleHelper.writeMessage("Enter the amount, please:");
            String amount = ConsoleHelper.readString();
            if ((!amount.matches("\\d+")))
            {
                ConsoleHelper.writeMessage("Incorrect input! Retry input, please:");
                continue;
            }
            if (Integer.parseInt(amount) == 0)
            {
                ConsoleHelper.writeMessage("Incorrect input! Retry input, please:");
                continue;
            }
            if (currencyManipulator.isAmountAvailable(Integer.parseInt(amount)))
            {
                try
                {
                    Map<Integer, Integer> map = currencyManipulator.withdrawAmount(Integer.parseInt(amount));

                    for (Map.Entry<Integer, Integer> pair : map.entrySet())
                    {
                        ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                    }
                    ConsoleHelper.writeMessage("Successful transaction!");
                    isValid = false;
                }
                catch (NotEnoughMoneyException ignore)
                {
                    ConsoleHelper.writeMessage("These banknotes is impossible to give the requested amount.");
                }

            } else
            {
                ConsoleHelper.writeMessage("Not enough money!");
            }


        }


    }
}

