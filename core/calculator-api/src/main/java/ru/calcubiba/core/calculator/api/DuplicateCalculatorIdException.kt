package ru.calcubiba.core.calculator.api

class DuplicateCalculatorIdException(id: String) :
    IllegalStateException("Calculator with id '$id' is registered more than once.")
