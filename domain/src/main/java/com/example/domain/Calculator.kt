package com.example.domain

class Calculator {

    fun evaluate(inputs: String): Float {
        var opertaion: Operation? = null
        var result = 0f

        inputs.split(" ").forEachIndexed { index, value ->
            if (index == FIRST_INDEX) {
                val number = value.toFloatOrNull() ?: throw IllegalArgumentException()
                result = number
                return@forEachIndexed
            }

            when (index % 2) {
                EVEN_IS_NUMBER -> {
                    val number = value.toFloatOrNull() ?: throw IllegalArgumentException()

                    if (opertaion == null) {
                        throw IllegalArgumentException()
                    }

                    result = Operation.calculate(result, opertaion!!, number)
                }
                ODD_IS_OPERATION -> {
                    if (Operation.check(value).not()) {
                        throw IllegalArgumentException()
                    }

                    opertaion = Operation.get(value)
                }
                else -> {
                    throw IllegalArgumentException()
                }
            }
        }

        return result
    }

    companion object {

        private const val FIRST_INDEX = 0

        private const val EVEN_IS_NUMBER = 0

        private const val ODD_IS_OPERATION = 1
    }
}
