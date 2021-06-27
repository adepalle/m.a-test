package fr.adepalle.data.mapper.base

/**
 * Basic class to convert Model to Entity and vice versa
 * It also permit to convert lists and throw exception if error occurred during the mapping
 * @param K : Model
 * @param T : Entity
 */
abstract class ModelMapper<K : Any, T : Any> {
    fun transformEntityList(input: List<T>): List<K> {
        return input.mapNotNull {
            try {
                transformEntityToModel(it)
            } catch (e: Exception) {
                onMappingError(e)
                null
            }
        }
    }

    fun transformModelList(input: List<K>): List<T> {
        return input.mapNotNull {
            try {
                transformModelToEntity(it)
            } catch (e: Exception) {
                onMappingError(e)
                null
            }
        }
    }

    abstract fun transformModelToEntity(input: K): T
    abstract fun transformEntityToModel(input: T): K
    abstract fun onMappingError(error: Exception)
}