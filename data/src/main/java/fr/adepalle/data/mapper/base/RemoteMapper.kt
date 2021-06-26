package fr.adepalle.data.mapper.base

/**
 * Basic class to convert Remote to Entity and vice versa
 * It also permit to convert lists and throw exception if error occurred during the mapping
 * @param K : Remote
 * @param T : Entity
 */
abstract class RemoteMapper<K : Any?, T : Any?> {
    fun transformEntityList(input: List<T>): List<K> {
        return input.mapNotNull {
            try {
                transformEntityToRemote(it)
            } catch (e: Exception) {
                onMappingError(e)
                null
            }
        }
    }

    fun transformRemoteEntityList(input: List<K>): List<T> {
        return input.mapNotNull {
            try {
                transformRemoteToEntity(it)
            } catch (e: Exception) {
                onMappingError(e)
                null
            }
        }
    }

    abstract fun transformEntityToRemote(input: T): K
    abstract fun transformRemoteToEntity(input: K): T
    abstract fun onMappingError(error: Exception)
}