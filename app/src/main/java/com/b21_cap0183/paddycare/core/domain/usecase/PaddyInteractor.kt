package com.b21_cap0183.paddycare.core.domain.usecase

import com.b21_cap0183.paddycare.core.domain.repository.IPaddyRepository

class PaddyInteractor(private val paddyRepository: IPaddyRepository): PaddyUseCase {

    override fun getAllDisease() = paddyRepository.getAllDisease()

    override fun getDiseaseById(id: Int) = paddyRepository.getDiseaseById(id)

    override fun getAllResult() = paddyRepository.getAllResult()

    override fun getResultById(id: Int) = paddyRepository.getResultById(id)
}