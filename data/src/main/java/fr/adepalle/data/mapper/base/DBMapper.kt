package fr.adepalle.data.mapper.base

/**
 * Basic class to convert DBEntity to Entity and vice versa
 * It also permit to convert lists and throw exception if error occurred during the mapping
 * @param K : DBEntity
 * @param T : Entity
 */
abstract class DBMapper<K : Any, T : Any> {
    fun transformEntityList(input: List<T>): List<K> {
        return input.mapNotNull {
            try {
                transformEntityToDB(it)
            } catch (e: Exception) {
                onMappingError(e)
                null
            }
        }
    }

    fun transformDBEntityList(input: List<K>): List<T> {
        return input.mapNotNull {
            try {
                transformDBToEntity(it)
            } catch (e: Exception) {
                onMappingError(e)
                null
            }
        }
    }

    abstract fun transformDBToEntity(input: K): T
    abstract fun transformEntityToDB(input: T): K
    abstract fun onMappingError(error: Exception)
}