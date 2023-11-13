package org.acme

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class Expense(
    @field:JsonProperty("name")
    val name: String,

    @field:JsonProperty("price")
    val price: Double,

    @field:JsonProperty("id")
    val id: UUID = UUID.randomUUID()

)
