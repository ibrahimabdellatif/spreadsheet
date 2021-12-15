package com.ibrahim.trainingonapachepoi

import androidx.annotation.Nullable
//this is 1.2 in table view process -> POJO class that used in increasing the readability and re-usability of a program
open class Cell(
    @field:Nullable @get:Nullable
    @param:Nullable val data: Any
)

class ColumnHeader(@Nullable data: Any) : Cell(data)
class RowHeader(@Nullable data: Any) : Cell(data)
