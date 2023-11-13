package org.acme

import jakarta.enterprise.context.ApplicationScoped
import java.util.*

@ApplicationScoped
class ExpenseService {

    var expenseStorage: MutableList<Expense> = mutableListOf(Expense("Initial expense", 30.9))

    fun addExpense(expense: Expense) {
        expenseStorage.add(expense)
    }

    fun getExpenses(): List<Expense> {
        return expenseStorage
    }

    fun deleteExpenseById(id: UUID) {
        expenseStorage.removeIf { it.id == id }
    }

}
