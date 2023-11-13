package org.acme

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ExpenseMapper {

    fun toExpense(dto: ExpenseDTO): Expense {
        return Expense(
            name = dto.name,
            price = dto.price
        )
    }
}
