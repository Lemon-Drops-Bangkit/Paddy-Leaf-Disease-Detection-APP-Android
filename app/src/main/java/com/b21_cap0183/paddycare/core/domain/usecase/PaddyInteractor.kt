package com.b21_cap0183.paddycare.core.domain.usecase

import com.b21_cap0183.paddycare.core.domain.repository.IPaddyRepository
import java.io.File
import javax.inject.Inject

class PaddyInteractor @Inject constructor(private val paddyRepository: IPaddyRepository) : PaddyUseCase {
    override fun getAllDisease() = paddyRepository.getAllDisease()

    override fun getAllResult() = paddyRepository.getAllResult()

    override fun postResult(image: File) = paddyRepository.postResult(image)
}