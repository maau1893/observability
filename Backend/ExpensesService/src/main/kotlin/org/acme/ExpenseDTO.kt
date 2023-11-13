package org.acme

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseDTO(
    @field:JsonProperty("name")
    val name: String,

    @field:JsonProperty("price")
    val price: Double
)
