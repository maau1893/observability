package org.acme

import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.jboss.logging.Logger
import java.util.UUID

@Path("/expenses")
class ExpenseResource(
    private val logger: Logger
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
        logger.info("Get all expenses")
        return expenseService.getExpenses()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun addExpense(expenseDTO: ExpenseDTO): List<Expense> {
        logger.info("Add expense")
        expenseService.addExpense(expenseMapper.toExpense(expenseDTO))
        return expenseService.getExpenses()
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteExpenseById(@PathParam("id") id: UUID): List<Expense> {
        logger.info("Delete expense by id")
        expenseService.deleteExpenseById(id)
        return expenseService.getExpenses()
    }


}
