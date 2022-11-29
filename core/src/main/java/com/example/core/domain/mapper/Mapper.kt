package com.example.core.domain.mapper

interface Mapper<Dto, Entity, Domain> {
    fun entityToDomain(entity: Entity): Domain
    fun dtoToDomain(dto: Dto): Domain
    fun domainToEntity(domain: Domain): Entity
}