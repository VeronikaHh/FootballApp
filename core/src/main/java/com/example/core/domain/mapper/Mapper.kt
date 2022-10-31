package com.example.core.domain.mapper

interface Mapper<Dto,Entity, Domain> {
    fun mapToDomain(entity: Entity): Domain
    fun map(dto: Dto): Domain
    fun mapToEntity(domain: Domain): Entity
}