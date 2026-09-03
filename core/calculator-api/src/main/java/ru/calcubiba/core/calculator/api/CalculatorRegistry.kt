package ru.calcubiba.core.calculator.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CalculatorRegistry @Inject constructor(
    plugins: Set<@JvmSuppressWildcards CalculatorPlugin>,
) {
    private val sortedPlugins: List<CalculatorPlugin> = plugins
        .sortedWith(
            compareBy<CalculatorPlugin>(
                { it.descriptor.category.ordinal },
                { it.descriptor.order },
                { it.descriptor.title.lowercase() },
            ),
        )
        .also(::ensureUniqueIds)

    val all: List<CalculatorPlugin> = sortedPlugins

    fun descriptors(): List<CalculatorDescriptor> = all.map(CalculatorPlugin::descriptor)

    fun groupedByCategory(): Map<CalculatorCategory, List<CalculatorDescriptor>> =
        descriptors().groupBy(CalculatorDescriptor::category)

    fun findById(id: String): CalculatorPlugin? = all.firstOrNull { it.descriptor.id == id }

    fun requireById(id: String): CalculatorPlugin =
        findById(id) ?: error("Calculator with id '$id' is not registered.")

    fun search(query: String): List<CalculatorDescriptor> {
        val normalizedQuery = query.trim().lowercase()
        if (normalizedQuery.isBlank()) {
            return descriptors()
        }

        return descriptors().filter { descriptor ->
            descriptor.id.lowercase().contains(normalizedQuery) ||
                descriptor.title.lowercase().contains(normalizedQuery) ||
                descriptor.shortDescription.lowercase().contains(normalizedQuery)
        }
    }

    private fun ensureUniqueIds(plugins: List<CalculatorPlugin>) {
        val duplicates = plugins
            .groupBy { it.descriptor.id }
            .filterValues { it.size > 1 }
            .keys

        if (duplicates.isNotEmpty()) {
            throw DuplicateCalculatorIdException(duplicates.first())
        }
    }
}
