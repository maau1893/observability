package org.acme

import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID

@Path("/expenses")
class ExpenseResource(
    private val log: Logger = LoggerFactory.getLogger(ExpenseResource::class.java)
) {

    @Inject
    @field: Default
    lateinit var expenseService: ExpenseService

    @Inject
    @field: Default
    lateinit var expenseMapper: ExpenseMapper

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun hello(): List<Expense> {
        log.info("Get all expenses")
        return expenseService.getExpenses()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun addExpense(expenseDTO: ExpenseDTO): List<Expense> {
        log.info("Add expense")
        expenseService.addExpense(expenseMapper.toExpense(expenseDTO))
        return expenseService.getExpenses()
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteExpenseById(@PathParam("id") id: UUID): List<Expense> {
        log.info("Delete expense by id")
        expenseService.deleteExpenseById(id)
        return expenseService.getExpenses()
    }


}
